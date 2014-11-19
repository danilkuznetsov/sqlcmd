package ua.com.juja.study.sqlcmd.config;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 11/19/14
 * Time: 1:44 PM
 */
public class ValidationException extends Exception {

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }
}
