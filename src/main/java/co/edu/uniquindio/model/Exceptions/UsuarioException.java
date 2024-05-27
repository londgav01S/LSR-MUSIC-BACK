package co.edu.uniquindio.model.Exceptions;

/**
 * Exception class to handle errors related to users.
 */
public class UsuarioException extends Exception {

    /**
     * Constructor for creating a UsuarioException with a custom message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public UsuarioException(String message) {
        super(message);
    }
}
