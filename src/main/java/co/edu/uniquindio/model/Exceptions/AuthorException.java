package co.edu.uniquindio.model.Exceptions;

/**
 * Exception class to handle errors related to authors.
 */
public class AuthorException extends Exception {

    /**
     * Constructor for creating an AuthorException with a custom message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public AuthorException(String message) {
        super(message);
    }
}
