/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.logic;

import domain.exceptions.MyCustomException;

/**
 *
 * @author tha
 */
public class Demo {
    dataaccess.DataMapper dm = new dataaccess.DataMapper();
    public void doSomething() throws MyCustomException{
        dm.getData();
    }
}
