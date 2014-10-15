package ua.com.juja.study.sqlcmd.database.mock;

import ua.com.juja.study.sqlcmd.config.SqlCmdConfig;
import ua.com.juja.study.sqlcmd.database.DatabaseConnection;
import ua.com.juja.study.sqlcmd.database.DatabaseExecutor;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 10/15/14
 * Time: 11:42 PM
 */
public class MockDatabaseExecutor implements DatabaseExecutor {

    @Override
    public DatabaseConnection connectToDb(SqlCmdConfig config) {
        System.out.println("Database connection established with config " + config);
        return new DatabaseConnection();
    }

}
