package data;

import domain.Person;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Sep 16, 2017
 */
public interface IPersonMapper {
    int addPerson(Person p) throws Exception;
    List<Person> getAllPersons() throws SQLException;
    void addPhone(int id, String number, String desc) throws SQLException;
}
