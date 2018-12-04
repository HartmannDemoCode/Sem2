package data;

import java.sql.SQLException;
import service.DataException;

/**
 *
 * @author tha
 */
public class DBFacade {
    FakeMapper fm;
    FakeMapper2 fm2;

    public DBFacade() {
        fm = new FakeMapper();
        fm2 = new FakeMapper2();
    }
    
    public String getStringFromMapper() throws DataException {
        
        try {
            return fm.getString();
        } catch (SQLException ex) {
           throw new DataException("Noget gik galt i hentning af string fra "+ex.getMessage()); //here we wrap the SQLException in a Self made exception
        }
    }
    public String getStringFromMapper2() throws DataException{
        try {
        return fm2.getString2();
        } catch (SQLException ex) {
           throw new DataException(ex.getMessage());
        }
    }
}
