/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logic.User;

/**
 *
 * @author thomas
 */
public class DB {
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/wpss2018e";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    
public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            
        } catch(SQLException | ClassNotFoundException se){
           se.printStackTrace();
        }
        return conn;
    }
    
    public static void main(String[] args) {
        
        try {
            String sql = "SELECT username, password FROM users";
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("username: "+username);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}
