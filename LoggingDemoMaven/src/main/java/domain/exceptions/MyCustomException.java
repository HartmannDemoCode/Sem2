/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.exceptions;

/**
 *
 * @author tha
 */
public class MyCustomException extends Exception {
    
    private Exception ex;
    public MyCustomException() {
    }

    /**
     * Constructs an instance of <code>MyCustomException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MyCustomException(String msg) {
        super(msg);
        this.ex = ex;
    }
}
