/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domain.exceptions.MyCustomException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class DataMapper {
    public List<String> getData() throws MyCustomException{
        throw new MyCustomException("MyCustomEx message");
        
    }
}
