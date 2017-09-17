package data;

import static data.DB.getConnection;
import domain.Person;
import domain.Phone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Sep 16, 2017
 */
public class PersonMapperDetailed implements IPersonMapper{

    public Person getPerson(int id) {
        return null;
    }

    public List<Person> getAllPersons() throws SQLException {
        List<Person> persons = new ArrayList();
        String sql = "select person.personID, firstName, lastName, phoneNo, description from person, phone where person.PersonID = phone.personID";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
        int lastId = -1;
        Person person = null;
        while (rs.next()) {
            int personId = rs.getInt("personid");
            if (personId != lastId) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                person = new Person(firstName, lastName);
            }
            person.addPhone(new Phone(rs.getString("phoneNo"), rs.getString("description")));
            persons.add(person);
        }
        return persons;
    }

    public int addPerson(Person p) throws Exception {
        Connection conn = DB.getConnection();
        String insertPerson = "INSERT INTO person (firstName, lastName) VALUES (?, ?)";
        String insertPhone = "INSERT INTO phone (phoneNo, description, personID) VALUES (?, ?, ?)";
        PreparedStatement personPstmt = conn.prepareStatement(insertPerson, Statement.RETURN_GENERATED_KEYS);
        PreparedStatement phonePstmt = conn.prepareStatement(insertPhone);
        ResultSet rs = null; int personId = 0;
        try {
            personPstmt.setString(1, p.getFirstName());
            personPstmt.setString(2, p.getLastName());
            //To create a transaction we need to not have automatic commit after each statement.
            conn.setAutoCommit(false);
            int result = personPstmt.executeUpdate();
            rs = personPstmt.getGeneratedKeys();
            rs.next();
            personId = rs.getInt(1);
            if (result == 1){
                List<Phone> phones = p.getPhones();
                for (Phone phone : phones) {
                    phonePstmt.setString(1, phone.getNumber());
                    phonePstmt.setString(2, phone.getDescription());
                    phonePstmt.setInt(3, personId); 
                    phonePstmt.executeUpdate();
                }
            conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); //This should go in the log file.
            // roll back the transaction
                if (conn != null) {
                    conn.rollback();
                }
            } finally {
                    conn.setAutoCommit(true);
                    if (personPstmt != null) {
                        personPstmt.close();
                    }
                    if (phonePstmt != null) {
                        phonePstmt.close();
                    }
                    if (rs != null) {
                        phonePstmt.close();
                    }
            }
        return personId;
    }
    
    @Override
    public void addPhone(int personId, String number, String desc) throws SQLException {
        Connection conn = DB.getConnection();
        String insertPhone = "INSERT INTO phone (phoneNo, description, personID) VALUES (?, ?, ?)";
        PreparedStatement phonePstmt = conn.prepareStatement(insertPhone);
        ResultSet rs = null;
        phonePstmt.setString(1, number);
        phonePstmt.setString(2, desc);
        phonePstmt.setInt(3, personId);
        phonePstmt.executeUpdate();
    }
    
    public static void main(String[] args) {
        IPersonMapper pm = new PersonMapperDetailed();
        Person p = new Person("Pedro", "Jensen");
        p.addPhone(new Phone("33334355", "mobile"));
        p.addPhone(new Phone("34340443", "home"));
        try {
            //pm.addPerson(p);
            pm.getAllPersons().forEach(person->System.out.println(person));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
