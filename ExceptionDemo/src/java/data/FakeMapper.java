package data;
import java.sql.SQLException;

/**
 *
 * @author tha
 */
public class FakeMapper {
    public String getString() throws SQLException{
        throw new SQLException();
        //return "some text";
    }
}
