/*

 */
package service;

/**
 *
 * @author tha
 * Message: This exception is a general exception used to wrap exceptions comming from the data source layer.
 * In this way we can maintain a total seperation between the data source layer and the prensentation layer
 * It is useful when we want to propagate the exception all the way up to the servlet to create a meaningful response to the user.
 * The self made exception can be very specific like: CreateBuildingException or more general like DataException.
 */
public class DataException extends Exception {

    /**
     * Creates a new instance of <code>DataException</code> without detail
     * message.
     */
    public DataException() {
    }

    /**
     * Constructs an instance of <code>DataException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DataException(String msg) {
        super(msg);
    }
}
