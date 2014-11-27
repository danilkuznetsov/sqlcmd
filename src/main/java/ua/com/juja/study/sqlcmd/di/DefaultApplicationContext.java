package ua.com.juja.study.sqlcmd.di;

import ua.com.juja.study.sqlcmd.config.SqlCmdConfig;
import ua.com.juja.study.sqlcmd.database.AsyncDatabaseExecutor;
import ua.com.juja.study.sqlcmd.database.DatabaseExecutor;
import ua.com.juja.study.sqlcmd.database.mock.MockDatabaseExecutor;
import ua.com.juja.study.sqlcmd.engine.KeyboardManager;
import ua.com.juja.study.sqlcmd.sql.ArrayQueryHistory;
import ua.com.juja.study.sqlcmd.sql.QueryHistory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 11/19/14
 * Time: 2:20 PM
 */
public class DefaultApplicationContext implements ApplicationContext {

    private SqlCmdConfig config;
    private QueryHistory queryHistory;
    private DatabaseExecutor databaseExecutor;
    private KeyboardManager keyboardManager;
    private ExecutorService executorService;

    public DefaultApplicationContext(SqlCmdConfig config) {
        this.config = config;
        executorService = Executors.newFixedThreadPool(5);
        databaseExecutor = new AsyncDatabaseExecutor(new MockDatabaseExecutor());
        queryHistory = new ArrayQueryHistory();
        keyboardManager = new KeyboardManager(queryHistory, databaseExecutor);
    }

    @Override
    public QueryHistory getQueryHistory() {
        return queryHistory;
    }

    @Override
    public DatabaseExecutor getDatabaseExecutor() {
        return databaseExecutor;
    }

    @Override
    public KeyboardManager getKeyboardManager() {
        return keyboardManager;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }


}
