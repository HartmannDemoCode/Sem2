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
public class PersonMapperSimple implements IPersonMapper {

    @Override
    public List<Person> getAllPersons() throws SQLException {
        List<Person> persons = new ArrayList();
        String sql = "select person.personID, firstName, lastName, phoneNo, description from person, phone where person.PersonID = phone.personID ORDER BY person.personID";
        ResultSet rs = getConnection().prepareStatement(sql).executeQuery();
        int lastId = -1;
        Person person = null;
        while (rs.next()) {
            int personId = rs.getInt("personid");
            if (personId != lastId) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                person = new Person(personId, firstName, lastName);
                persons.add(person);
            }
            person.addPhone(new Phone(rs.getString("phoneNo"), rs.getString("description")));
            lastId = personId;
        }
        return persons;
    }
    
    @Override
    public int addPerson(Person p) throws Exception {
        Connection conn = DB.getConnection();
        String insertPerson = "INSERT INTO person (firstName, lastName) VALUES (?, ?)";
        PreparedStatement personPstmt = conn.prepareStatement(insertPerson, Statement.RETURN_GENERATED_KEYS);
        
        personPstmt.setString(1, p.getFirstName());
        personPstmt.setString(2, p.getLastName());
        int result = personPstmt.executeUpdate();
        ResultSet rs = personPstmt.getGeneratedKeys();
        rs.next();
        int personId = rs.getInt(1);
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
        IPersonMapper pm = new PersonMapperSimple();
        Person p = new Person("Kalle", "Karlsen");
        
        try {
//            int id = pm.addPerson(p);
//            pm.addPhone(id, "11334355", "mobile");
//            pm.addPhone(id, "22340443", "home");
              pm.getAllPersons().forEach(person->System.out.println(person));
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
