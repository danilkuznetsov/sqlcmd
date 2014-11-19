package ua.com.juja.study.sqlcmd.database;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 11/19/14
 * Time: 1:50 PM
 */
public class DatabaseException extends Exception {

    private String query;

    public DatabaseException() {
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, String query) {
        super(message);
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
