package ua.com.juja.study.sqlcmd.database.mock;

import ua.com.juja.study.sqlcmd.config.SqlCmdConfig;
import ua.com.juja.study.sqlcmd.database.DatabaseExecutor;
import ua.com.juja.study.sqlcmd.database.Row;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 10/15/14
 * Time: 11:42 PM
 */
public class MockDatabaseExecutor implements DatabaseExecutor {

    @Override
    public boolean connectToDb(SqlCmdConfig config) {
        System.out.println("Database connection established with config " + config);
        return true;
    }

    @Override
    public Row[] executeSqlScript(String sqlScript) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public String[] getDatabaseList() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void changeDatabase(String databaseName) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
