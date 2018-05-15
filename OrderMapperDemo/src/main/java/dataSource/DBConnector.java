package dataSource;

import java.sql.Connection;
import java.sql.DriverManager;

//Encapsulates code to connect to DB
//hau
public class DBConnector {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=UTF-8&characterSetResults=UTF-8";
    private static String USER = "root";
    private static String PASSWORD = "root";

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("\n*** Remember to insert your username and password in the DBConnector class! ***\n");
            System.out.println("\n*** Remember to point to add maven dependency for MySQL connector! ***\n");
            System.out.println("eror in DBConnector.getConnection()");
            System.out.println(e);
        }

        return con;
    }

    public void releaseConnection(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
