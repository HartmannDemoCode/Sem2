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
    //== load an order and the associated order details
    Connection con;
    public OrderMapper(Connection conn){
    con = conn;
    }
    public OrderMapper(){}

    public Order getOrder(int ono, Connection con) {
        Order o = null;
        String SQLString1 = // get order
                "select * "
                + "from orders "
                + "where ono = ?";
        String SQLString2 = // get order details
                "select od.pno, od.qty "
                + "from odetails od "
                + "where od.ono = ? ";         // foreign key match 
        PreparedStatement statement = null;

        try {
            //=== get order
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, ono);     // primary key value
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                o = new Order(ono,
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5));
            }

            //=== get order details
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, ono);          // foreign key value
            rs = statement.executeQuery();
            while (rs.next()) {
                o.addDetail(new OrderDetail(
                        ono,
                        rs.getInt(1),
                        rs.getInt(2)));
            }
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - getOrder");
            System.out.println(e.getMessage());
        } finally // must close statement
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

    //== Insert new order (tuple)
    public boolean saveNewOrder(Order o, Connection con) {
        int rowsInserted = 0;
        String SQLString1 =
                "select orderseq.nextval  "
                + "from dual";
        String SQLString2 =
                "insert into orders "
                + "values (?,?,?,?,?)";
        PreparedStatement statement = null;

        try {
            //== get unique ono
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                o.setOno(rs.getInt(1));
            }

            //== insert tuple
            statement = con.prepareStatement(SQLString2);
            statement.setInt(1, o.getOno());
            statement.setInt(2, o.getCustomerNo());
            statement.setInt(3, o.getEmployeeNo());
            statement.setString(4, o.getReceived());
            statement.setString(5, o.getShipped());
            rowsInserted = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - saveNewOrder");
            System.out.println(e.getMessage());
        } finally // must close statement
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in OrderMapper - saveNewOrder");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }
    

    //== Insert new order detail (tuple)
    public boolean saveNewOrderDetail(OrderDetail od, Connection con) {
        int rowsInserted = 0;
        String SQLString =
                "insert into odetails "
                + "values (?,?,?)";
        PreparedStatement statement = null;

        try {
            //== insert tuple
            statement = con.prepareStatement(SQLString);
            statement.setInt(1, od.getOno());
            statement.setInt(2, od.getPno());
            statement.setInt(3, od.getQty());
            rowsInserted = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - saveNewOrderDetail");
            System.out.println(e.getMessage());
        } finally // must close statement
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
     * The Purpose of this method is to update customer (cno) and/or employee (eno)
     * This method takes to parameters newCno and newEno if either of the them = 0 it will not be updated
     * @param o
     * @param con
     * @param newCno
     * @param newEno
     * @return 
     */
    public Boolean updateOrder(Order o, Connection con, int newCno, int newEno)
    {
          int ono = o.getOno(); 
	  int cno = o.getCustomerNo(); if(newCno==0){newCno = cno;}
	  int eno = o.getEmployeeNo(); if(newEno==0){newEno = eno;}
//        String received = o.getReceived();
//	  String shipped = o.getShipped();
//	  ArrayList<OrderDetail> orderDetails = o.getDetails();
          PreparedStatement st;
          try
          {
          String sql = "UPDATE orders SET cno = ?, eno = ? WHERE ono = ?";
          st = con.prepareStatement(sql);
          st.setInt(1, newCno);
          st.setInt(2, newEno);
          st.setInt(3, ono);
          int resp = st.executeUpdate();
              if(resp == 1){
                  System.out.println("succes in updating the order");
                  
              }
          return true;
          } catch(Exception ee){
              System.out.println("Fejl i updateOrder: "+ee.getLocalizedMessage());
              return false;
          }
    }
    /**
     * Delete an order based on the order no.
     * @param ono
     * @param con
     * @return 
     */
    public boolean deleteOrder(int ono)
    {
        
        PreparedStatement st;
        try{
           con.setAutoCommit(false);
           String sql = "DELETE FROM orders WHERE ono = ?";
           st = con.prepareStatement(sql);
           st.setInt(1, ono);
            System.out.println("ono: " + ono);
           int ret = st.executeUpdate();
            System.out.printf("Return: %d row(s) were effected", ret);
           con.commit();
           st.close();
           return true;
        }
          catch(Exception e){
          System.out.println("Fejl: " + e.getMessage());
          return false;
          }
}
//    public void deleteOrder(int ono)
//    {
//    try{
//    String sql = "DELETE FROM orders WHERE ono ="+ono;
//    Statement st = con.createStatement();
//    con.setAutoCommit(true);
//    st.executeUpdate(sql);
//    }catch(Exception e){
//        System.out.println("Fejl: "+e.getMessage());
//    }
//    }
}
