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

    public void getData() throws MyCustomException {
        throw new MyCustomException("MyCustomEx message");
    }
}
