package ua.com.juja.study.sqlcmd.sql;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 10/22/14
 * Time: 11:23 PM
 */
public interface QueryHistory {
    public abstract String getNextQuery();

    public abstract String getPreviousQuery();

    public abstract void addQueryToTheHead(String query);
}
