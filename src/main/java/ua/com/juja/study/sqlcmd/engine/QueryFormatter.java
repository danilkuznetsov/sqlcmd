package ua.com.juja.study.sqlcmd.engine;

import ua.com.juja.study.sqlcmd.database.DatabaseException;
import ua.com.juja.study.sqlcmd.database.QueryResult;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 11/27/14
 * Time: 1:06 PM
 */
public class QueryFormatter {
    public String formatQueryResult(QueryResult queryResult) {
        try {
            queryResult.getRowList();
        } catch (DatabaseException e) {
            return e.getMessage();
        }
        return queryResult.toString();
    }
}
