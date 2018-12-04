package dataSource;

import java.util.List;

/**
 *
 * @author tha
 */
public class Invoice {
    private Order order;
    private List<OrderLine> orderlines;

    public Invoice(Order order, List<OrderLine> orderlines) {
        this.order = order;
        this.orderlines = orderlines;
    }
    
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderLine> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<OrderLine> orderlines) {
        this.orderlines = orderlines;
    }

    @Override
    public String toString() {
        String output = "Invoice: " + order.getOrderid() + "\n";
        for (OrderLine orderline : orderlines) {
            output += orderline + "\n";
        }
        return output;
    }
    
}
