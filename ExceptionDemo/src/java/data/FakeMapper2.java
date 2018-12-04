package data;

import java.sql.SQLException;

/**
 *
 * @author tha
 */
public class FakeMapper2 {
    public String getString2() throws SQLException{
        throw new SQLException();
        //return "some text";
    }
}
