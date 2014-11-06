package ua.com.juja.study.sqlcmd.sql;

public class ArrayQueryHistory implements QueryHistory {

    private String[] queryList = new String[QUERY_BUFFER_COUNT];
    private int currentQueryIndex = -1;
    private int queryCount = 0;

    @Override
    public String getNextQuery() {
        if (queryCount > 0 && queryCount - 1 > currentQueryIndex) {
            return queryList[++currentQueryIndex];
        }
        return null;
    }

    @Override
    public String getPreviousQuery() {
        if (queryCount > 0 && currentQueryIndex > 0) {
            return queryList[--currentQueryIndex];
        }
        return null;
    }

    @Override
    public void addQueryToTheHead(String query) {
        addQueryToTheHead(queryList, query);
        if (queryCount < QUERY_BUFFER_COUNT) {
            queryCount++;
        }
        // Reset query index
        currentQueryIndex = -1;
    }

    private void addQueryToTheHead(String[] queryList, String query) {
        for (int i = queryList.length - 2; i >= 0; i--) {
            queryList[i + 1] = queryList[i];
        }
        queryList[0] = query;
    }
}
