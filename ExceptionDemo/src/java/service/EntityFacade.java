package service;

import data.DBFacade;
import java.sql.SQLException;

/**
 *
 * @author tha
 */
public class EntityFacade {
    DBFacade dbf = new DBFacade();
    
    public String getStringFromDB() throws DataException{
        return dbf.getStringFromMapper();
    }
}
