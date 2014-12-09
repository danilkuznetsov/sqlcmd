package ua.com.juja.study.sqlcmd.database;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 11/27/14
 * Time: 12:17 PM
 */
public class AsyncDatabaseExecutor implements DatabaseExecutor {

    private DatabaseExecutor executor;

    public AsyncDatabaseExecutor(DatabaseExecutor executor) {
        this.executor = executor;
    }

    @Override
    public QueryResult executeSqlScript(final String sqlScript) throws DatabaseException {
        //TODO implement me :)
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public String[] getDatabaseList() throws DatabaseException {
        return executor.getDatabaseList();
    }

    @Override
    public void changeDatabase(String databaseName) throws DatabaseException {
        executor.changeDatabase(databaseName);
    }
}
