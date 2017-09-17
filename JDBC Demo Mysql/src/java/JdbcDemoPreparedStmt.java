/**
 *
 * @author tha
 */
import java.sql.*;
import java.time.*;
public class JdbcDemoPreparedStmt {
    public static void main(String[] args) {
        JdbcDemoPreparedStmt thisOne = new JdbcDemoPreparedStmt();
        //Test run getStudent
        //thisOne.getStudentsByLastName("Petersen");
        
       //Test run insert
        thisOne.insertNewStudent(new Student("Jespersen", "Kasper", "Geology", new java.util.Date(), 2));
        
    }
    private void getStudentsByLastName(String lname) {
        try {
            PreparedStatement stmt = null;
            Connection conn = DB.getConnection();
            
            String sql = "SELECT studentid, firstname, lastname, major FROM student WHERE lastname = ?";
            
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, lname);
            ResultSet rs = stmt.executeQuery();
            
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
            DB.close(stmt, rs, conn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void insertNewStudent(Student stud){
        try {
            PreparedStatement stmt = null;
            Connection conn = DB.getConnection();
            String sql = "INSERT INTO student (lastname, firstname, major, bday, FK_classId) VALUES(?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, stud.getLastname());
            stmt.setString(2, stud.getFirstname());
            stmt.setString(3, stud.getMajor());
            stmt.setDate(4, new java.sql.Date(stud.getBday().getTime())); //Convert java.util.date to java.sql.date type
            stmt.setInt(5, stud.getClassId());
            
            stmt.executeUpdate();
            DB.close(stmt, null, conn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
