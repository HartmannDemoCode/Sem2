package dataSource;

import java.sql.Date;

/**
 *
 * @author tha
 */
public class Order {
    private int orderid;
    private int customerid;
    private int employeeid;
    private Date recieved;
    private Date shipped;

    public Order(int orderid, int customerid, int employeeid, Date recieved, Date shipped) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.employeeid = employeeid;
        this.recieved = recieved;
        this.shipped = shipped;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public Date getRecieved() {
        return recieved;
    }

    public void setRecieved(Date recieved) {
        this.recieved = recieved;
    }

    public Date getShipped() {
        return shipped;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    @Override
    public String toString() {
        return "orderid: " + orderid + ", customerid: " + customerid + ", employeeid: " + employeeid + ", recieved: " + recieved + ", shipped: " + shipped;
    }
    
    
    
}
