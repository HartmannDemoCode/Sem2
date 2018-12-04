package dataSource;

/**
 *
 * @author tha
 */
public class OrderLine {
    private int orderid;
    private int partid;
    private int qty;

    public OrderLine(int orderid, int partid, int qty) {
        this.orderid = orderid;
        this.partid = partid;
        this.qty = qty;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getPartid() {
        return partid;
    }

    public void setPartid(int partid) {
        this.partid = partid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "partid: " + partid + ", qty: " + qty;
    }
    
}
