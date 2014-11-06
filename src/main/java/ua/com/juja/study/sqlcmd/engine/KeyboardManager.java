package ua.com.juja.study.sqlcmd.engine;

import ua.com.juja.study.sqlcmd.database.DatabaseExecutor;
import ua.com.juja.study.sqlcmd.database.Row;
import ua.com.juja.study.sqlcmd.sql.QueryHistory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 10/22/14
 * Time: 11:28 PM
 */
public class KeyboardManager {
    private static final String QUERY_NEWLINE_SEPARATOR = " ";
    private QueryHistory history;
    private DatabaseExecutor databaseExecutor;

    public KeyboardManager(QueryHistory queryHistory, DatabaseExecutor databaseExecutor) {
        this.history = queryHistory;
        this.databaseExecutor = databaseExecutor;
    }

    public void startListenUserKeyboard() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;
        StringBuilder query = new StringBuilder();
        while (!exit) {
            String line = reader.readLine();
            if ("\\q".equals(line)) {
                exit = true;
            } else if (line != null && line.length() > 0) {
                query.append(line);
                char lastChar = line.charAt(line.length() - 1);
                if (lastChar == ';') {
                    executeQuery(query.toString());
                    query = new StringBuilder();
                } else {
                    query.append(QUERY_NEWLINE_SEPARATOR);
                }
            }
        }
    }

    public Row[] executeQuery(String query) {
        history.addQueryToTheHead(query);
        return databaseExecutor.executeSqlScript(query);
    }
}
