package dataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class TransactionDemo {
    public void doTransaction(List<PreparedStatement> stmts){
        Connection conn = null;
        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);
            for (PreparedStatement stmt : stmts) {
                int result = stmt.executeUpdate();
                if(result == 0)
                    throw new SQLException();
            }
            DB.getConnection().commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        try {
            //Testing the transaction:
            TransactionDemo td = new TransactionDemo();
            List<PreparedStatement> stmts = new ArrayList();
            
            //Insert a new order with 4 products:
            String sql0 = "insert into orders values(120,1111,1000,'2016-12-10','2016-12-12')";
            String sql1 = "insert into odetails values(120,10506,1)";
            String sql2 = "insert into odetails values(120,10507,3)";
            String sql3 = "insert into odetails values(120,10508,5)";
            String sql4 = "insert into odetails values(120,10509,7)";
            
            Connection conn = DB.getConnection().crea;
            stmts.add(DB.getStatement(sql0, null));
            stmts.add(DB.getStatement(sql1, null));
            stmts.add(DB.getStatement(sql2, null));
            stmts.add(DB.getStatement(sql3, null));
            stmts.add(DB.getStatement(sql4, null));
            
            td.doTransaction(stmts);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
    }
}
