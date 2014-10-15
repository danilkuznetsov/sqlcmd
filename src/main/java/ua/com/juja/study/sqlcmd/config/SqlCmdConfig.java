package ua.com.juja.study.sqlcmd.config;

/**
 * Created by kuznetsov.danil on 10/15/14.
 */
public class SqlCmdConfig {
    private String userName;
    private String password;
    private String dbUrl;
    private String driverName;

    public static final String SHORT_ARG_USER_NAME = "-u";
    public static final String LONG_ARG_USER_NAME = "-user";
    public static final String SHORT_ARG_USER_PASSWORD = "-p";
    public static final String LONG_ARG_USER_PASSWORD = "-password";
    public static final String SHORT_ARG_DB_URL = "-url";
    public static final String LONG_ARG_DB_URL = "-url";
    public static final String SHORT_ARG_DRIVER_NAME = "-d";
    public static final String LONG_ARG_DRIVER_NAME = "-driver";

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SqlCmdConfig{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", password='").append("*****").append('\'');
        sb.append(", dbUrl='").append(dbUrl).append('\'');
        sb.append(", driverName='").append(driverName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
