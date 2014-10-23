package ua.com.juja.study.sqlcmd.engine;

import ua.com.juja.study.sqlcmd.database.DatabaseExecutor;
import ua.com.juja.study.sqlcmd.database.Row;
import ua.com.juja.study.sqlcmd.sql.QueryHistory;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 10/22/14
 * Time: 11:28 PM
 */
public class KeyboardManager {
    private QueryHistory history;
    private DatabaseExecutor databaseExecutor;

    public Row[] executeQuery(String query) {
        history.addQueryToTheHead(query);
        return databaseExecutor.executeSqlScript(query);
    }
}
