package ua.com.juja.study.sqlcmd.io;

import ua.com.juja.study.sqlcmd.database.QueryResult;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 11/27/14
 * Time: 12:57 PM
 */
public interface ResultWriter {
    public void writeQueryResult(QueryResult queryResult) throws IOException;
}
