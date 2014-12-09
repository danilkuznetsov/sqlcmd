package ua.com.juja.study.sqlcmd.database;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 10/17/14
 * Time: 6:57 PM
 */
public class Row {

    public static final String ROWS_AFFECTED = "ROWS_AFFECTED";

    private Map<String, Object> values = new HashMap<>();

    public void addColumnValue(String columnName, Object columnValue) {
        values.put(columnName, columnValue);
    }

    public Object getValue(String column) {
        return values.get(column);
    }
}
