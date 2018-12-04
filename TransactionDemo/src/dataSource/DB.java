package dataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tha
 */
public class DB {

    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/sem2?zeroDateTimeBehavior=convertToNull";
    public static final String user = "root";
    public static final String pwd = "";
    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        if (conn == null) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
                conn = DriverManager.getConnection(url, user, pwd);
        }
        return conn;
    }

    public static PreparedStatement getStatement(String sql, String[] params) throws SQLException {
        PreparedStatement pstmt = null;
        
            Connection conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            if(params != null){
                for(int i = 1; i <= params.length; i ++) {
                    pstmt.setString(i, params[i-1]);
                }
            }
        
        return pstmt;
    }

    public static void main(String[] args) throws SQLException { //TEST
        
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customers");
            ResultSet rs = pstmt.executeQuery();
            String name, street, phone;
            while (rs.next()) {
                name = rs.getString("cname");
                street = rs.getString("street");
                phone = rs.getString("phone");
                System.out.println(name + " : " + street + " : " + phone);
            }
    }
}
