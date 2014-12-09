package ua.com.juja.study.sqlcmd.database.jdbc;

import ua.com.juja.study.sqlcmd.config.SqlCmdConfig;
import ua.com.juja.study.sqlcmd.database.DatabaseException;
import ua.com.juja.study.sqlcmd.database.DatabaseExecutor;
import ua.com.juja.study.sqlcmd.database.QueryResult;

import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 12/3/14
 * Time: 12:05 PM
 */
public class JdbcDatabaseExecutor implements DatabaseExecutor {

    private Connection connection;

    public JdbcDatabaseExecutor(SqlCmdConfig config) throws DatabaseException {
        //TODO implement init db
    }

    @Override
    public QueryResult executeSqlScript(String sqlScript) throws DatabaseException {
        //TODO
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public String[] getDatabaseList() throws DatabaseException {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void changeDatabase(String databaseName) throws DatabaseException {
        throw new UnsupportedOperationException("Not implemented");
    }

}
