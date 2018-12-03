/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domain.exceptions.MyCustomException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tha
 */
public class DataMapper {

    public List<String> getData() throws MyCustomException {
        try {
            DB.getConnection().prepareStatement("SELECT username, password FROM users");
        } catch (SQLException ex) {
            throw new MyCustomException("MyCustomEx message", ex);
//            Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
