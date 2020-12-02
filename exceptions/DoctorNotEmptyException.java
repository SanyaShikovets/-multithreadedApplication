package exceptions;

/**
 * @author Sasha Shikovets
 * @version 1.0
 */

public class DoctorNotEmptyException extends Exception {

    /**
     * Constructor
     * @param message message to provide for this exception
     */
    public DoctorNotEmptyException(String message){
        super("All doctors is busy: " + message);
    }

    /**
     * Constructor
     * @param message message to provide for this exception
     * @param e throwable object, for example, another exception
     */
    public DoctorNotEmptyException(String message, Throwable e){
        super("All doctors is busy, man is: " + message, e);
    }

    /**
     * Get message of exception
     * @return text of message in String format
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    /**
     * Prints stack trace of exception
     */
    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
