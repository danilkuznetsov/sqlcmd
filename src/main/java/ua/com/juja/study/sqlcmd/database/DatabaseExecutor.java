package ua.com.juja.study.sqlcmd.database;

import ua.com.juja.study.sqlcmd.config.SqlCmdConfig;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 10/15/14
 * Time: 11:39 PM
 */
public interface DatabaseExecutor {

    public abstract boolean connectToDb(SqlCmdConfig config) throws DatabaseException;

    public abstract QueryResult executeSqlScript(String sqlScript) throws DatabaseException;

    public abstract String[] getDatabaseList() throws DatabaseException;

    public abstract void changeDatabase(String databaseName) throws DatabaseException;
}
