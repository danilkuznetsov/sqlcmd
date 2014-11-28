package ua.com.juja.study.sqlcmd.di;

import ua.com.juja.study.sqlcmd.database.DatabaseExecutor;
import ua.com.juja.study.sqlcmd.engine.KeyboardManager;
import ua.com.juja.study.sqlcmd.sql.QueryHistory;

import java.util.concurrent.ExecutorService;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 11/19/14
 * Time: 2:14 PM
 */
public interface ApplicationContext {

    public QueryHistory getQueryHistory();

    public DatabaseExecutor getDatabaseExecutor();

    public KeyboardManager getKeyboardManager();

    public ExecutorService getExecutorService();

    public void shutdown();
}
