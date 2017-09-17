/**
 *
 * @author tha
 */
//STEP 1. Import required packages
import java.sql.*;
public class JdbcDemo {
   
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
           //STEP 2: Register JDBC driver
           // This step causes the JVM to load the desired driver implementation into memory so it can fulfill your JDBC requests.
           Class.forName(DB.driver);

           //STEP 3: Open a connection
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB.url,DB.username,DB.password);

           //STEP 4: Execute a query
           System.out.println("Creating statement...");
           stmt = conn.createStatement();
           String sql;
           sql = "SELECT studentid, firstname, lastname, major FROM student";
           ResultSet rs = stmt.executeQuery(sql);

           //STEP 5: Extract data from result set
           while(rs.next()){
              //Retrieve by column name
              int id  = rs.getInt("studentid");
              String major = rs.getString("major");
              String first = rs.getString("firstname");
              String last = rs.getString("lastname");

              //Display values
              System.out.print("ID: " + id);
              System.out.print(", major: " + major);
              System.out.print(", First: " + first);
              System.out.println(", Last: " + last);
           }
           //STEP 6: Clean-up environment
           rs.close();
           stmt.close();
           conn.close();
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}
