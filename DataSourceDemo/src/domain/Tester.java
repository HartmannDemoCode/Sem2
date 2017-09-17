/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import dataSource.OrderMapper;
import java.sql.Connection;

/**
 *
 * @author tha
 */
public class Tester {
    public static void main(String args[]) {
    dataSource.DBConnector dbc = new dataSource.DBConnector();
        //Order o = new Order(1021, 1111, 1000, "2004-4-5", "2004-12-12");
    Connection con = dbc.getConnection();
    OrderMapper om = new OrderMapper(con);
//  om.updateOrder(o, con, 2222, 1002);
   om.deleteOrder(1025);
    
  }        
}
