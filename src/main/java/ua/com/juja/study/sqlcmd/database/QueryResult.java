package ua.com.juja.study.sqlcmd.database;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 11/27/14
 * Time: 12:30 PM
 */
public class QueryResult {
    private Row[] rowList;
    private Future<Row[]> futureRowList;

    public QueryResult(Row[] rowList) {
        this.rowList = rowList;
    }

    public QueryResult(Future<Row[]> futureRowList) {
        this.futureRowList = futureRowList;
    }

    public Row[] getRowList() throws DatabaseException {
        if (futureRowList == null) {
            return rowList;
        }
        try {
            return futureRowList.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new DatabaseException("Exception with async execution " + e.getMessage());
        }
    }

    public boolean isReady() {
        if (futureRowList == null) {
            return true;
        }
        return futureRowList.isDone();
    }
}
