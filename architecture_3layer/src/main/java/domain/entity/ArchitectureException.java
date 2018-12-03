/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entity;

/**
 *
 * @author thomas
 */
public class ArchitectureException extends Exception {

    /**
     * Creates a new instance of <code>ArchitectureException</code> without
     * detail message.
     */
    public ArchitectureException() {
    }

    /**
     * Constructs an instance of <code>ArchitectureException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ArchitectureException(String msg) {
        super(msg);
    }
}
