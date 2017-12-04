package dataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import domain.Order;
import domain.OrderDetail;

//=== Maps between objects and tables
//=== Encapsulates SQL-statements
// hau
public class OrderMapper {

    Connection con;

    public OrderMapper(Connection conn) {
        con = conn;
    }

    //Get an order and all of its odetails (order lines)
    public Order getOrder(int ono) throws Exception {
        Order o = null;
        String sqlSelectOrder = "select cno, empno, received, shipped from orders where ono = ?";
        String sqlSelectOdetails = "select od.pno, od.qty from odetails od where od.ono = ? ";         // foreign key match 
        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(sqlSelectOrder);
            statement.setInt(1, ono);     // primary key value
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                java.sql.Date rec = rs.getDate("received");
                java.sql.Date ship = rs.getDate("shipped");
                java.util.Date received = (rec != null)? new Date(rec.getTime()):null;
                java.util.Date shipped = (ship != null)? new Date(ship.getTime()):null;
                o = new Order(ono,
                        rs.getInt("cno"),
                        rs.getInt("empno"),
                        received,
                        shipped);
            } else {
                throw new Exception("No order by that ID");
            }

            //=== get order details
            statement = con.prepareStatement(sqlSelectOdetails);
            statement.setInt(1, ono);          // foreign key value
            rs = statement.executeQuery();
            while (rs.next()) {
                o.addDetail(new OrderDetail(
                        ono,
                        rs.getInt("pno"),
                        rs.getInt("qty")));
            }
        } catch (SQLException e) {
            System.out.println("Fail in OrderMapper - getOrder");
            System.out.println(e.getMessage());
        } finally // must close pstmt
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - getOrder");
                System.out.println(e.getMessage());
            }
        }
        return o;
    }
    public List<Order> getAllOrders() throws SQLException{
        List<Order> orders = new ArrayList();
        String sql = "select ord.ono, cno, empno, ord.received, ord.shipped, pr.pno, pr.pname, od.qty, pr.descr, pr.price from orders ord, products pr, odetails od where od.pno = pr.pno and od.ono = ord.ono ORDER BY ord.ono";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        int previous = 0; Order order = null;
        while (rs.next()) {
            int current = rs.getInt("ono");
            if(previous != current){
                java.sql.Date ship = rs.getDate("shipped");
                java.sql.Date rec = rs.getDate("received");
                java.util.Date shipped = (ship != null)? new Date(ship.getTime()):null;
                java.util.Date received = (rec != null)? new Date(rec.getTime()):null;
                order = new Order(current, rs.getInt("cno"), rs.getInt("empno"), received, shipped);
                orders.add(order);
            }
            order.addDetail(new OrderDetail(current, rs.getInt("pno"), rs.getInt("qty")));
            previous = current;
        }
        return orders;
    }
    
    //== Insert new order (tuple) and return order with its generated id
    public Order saveNewOrder(Order o) {
        String sqlInsert = "insert into orders (cno, empno) values (?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, o.getCustomerNo());
            pstmt.setInt(2, o.getEmployeeNo());
            int i = pstmt.executeUpdate(); System.out.println("rows affected: "+i);
            
            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                int autoIncKey = rs.getInt(1);
                System.out.println("autoIncKey: "+autoIncKey);
                o.setOno(autoIncKey);
                System.out.println("ONO: "+o.getOno());
                for (OrderDetail detail : o.getDetails()) {
                    detail.setOno(autoIncKey);
                    saveNewOrderDetail(detail);
                }
            } else {
                throw new Exception("Order was not saved, some error orrured");
            }

        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - saveNewOrder");
            e.printStackTrace();
        } finally // must close pstmt
        {
            try {
                pstmt.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - saveNewOrder");
                System.out.println(e.getMessage());
            }
        }
        return o;
    }

    //== Insert new order detail (tuple)
    public boolean saveNewOrderDetail(OrderDetail od) {
        int rowsInserted = 0;
        String sql = "insert into odetails values (?,?,?)";
        PreparedStatement statement = null;

        try {
            //== insert tuple
            statement = con.prepareStatement(sql);
            statement.setInt(1, od.getOno());
            statement.setInt(2, od.getPno());
            statement.setInt(3, od.getQty());
            rowsInserted = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - saveNewOrderDetail");
            System.out.println(e.getMessage());
        } finally // must close pstmt
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - saveNewOrderDetail");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }

    /**
     * The Purpose of this method is to update customer (cno) and/or employee
     * (eno) This method takes to parameters newCno and newEno if either of the
     * them = 0 it will not be updated
     *
     * @param o
     * @param con
     * @param newCno
     * @param newEno
     * @return
     */
    public Boolean updateOrder(Order o) {
        int ono = o.getOno();
        int cno = o.getCustomerNo();
        int empno = o.getEmployeeNo();
        Date shipped = o.getShipped();

        PreparedStatement st;
        try {
            String sql = "UPDATE orders SET cno = ?, empno = ?, shipped = ? WHERE ono = ?";
            st = con.prepareStatement(sql);
            st.setInt(1, cno);
            st.setInt(2, empno);
            st.setDate(3, new java.sql.Date(shipped.getTime()));
            st.setInt(4, ono);
            int resp = st.executeUpdate();
            if (resp == 1) {
                System.out.println("succes in updating the order");
            }
            return true;
        } catch (Exception ee) {
            System.out.println("Fejl i updateOrder: " + ee.getLocalizedMessage());
            return false;
        }
    }

    /**
     * Delete an order based on the order no.
     *
     * @param ono
     * @param con
     * @return
     */
    public boolean deleteOrder(int ono) {

        PreparedStatement st;
        try {
            con.setAutoCommit(false);
            String sql = "DELETE FROM orders WHERE ono = ?";
            st = con.prepareStatement(sql);
            st.setInt(1, ono);
            
            int ret = st.executeUpdate();
            System.out.printf("Return: %d row(s) were effected", ret);
            con.commit();
            st.close();
            return true;
        } catch (Exception e) {
            System.out.println("Fejl: " + e.getMessage());
            return false;
        }
    }
    public static void main(String[] args) throws Exception {
        OrderMapper om = new OrderMapper(new DBConnector().getConnection());
        Order order = new Order(2, 1);
        order.addDetail(new OrderDetail(2, 4));
        order.addDetail(new OrderDetail(1, 2));
        order.addDetail(new OrderDetail(3, 6));
        order = om.saveNewOrder(order);
        
        System.out.println("order: "+order);
        int oid = order.getOno();
        order = om.getOrder(oid);
        
        System.out.println("getOrder: ");
        System.out.println(order);
        order.setShipped(new Date());
        om.updateOrder(order);
        System.out.println("updated order: ");
        System.out.println(order);
        System.out.println("get all orders: ");
        om.getAllOrders().stream().forEach(System.out::println);
    }
}
