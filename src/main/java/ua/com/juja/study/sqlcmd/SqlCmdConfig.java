package ua.com.juja.study.sqlcmd;

/**
 * Created by kuznetsov.danil on 10/15/14.
 */
public class SqlCmdConfig {
    private String valueArgUserName;
    private String valueArgUserPassword;
    private String valueArgDbURL;
    private String valueArgDriverName;

    public static final String SHORT_ARG_USER_NAME = "-u";
    public static final String LONG_ARG_USER_NAME = "-user";
    public static final String SHORT_ARG_USER_PASSWORD = "-p";
    public static final String LONG_ARG_USER_PASSWORD = "-password";
    public static final String SHORT_ARG_DB_URL = "-url";
    public static final String LONG_ARG_DB_URL = "-url";
    public static final String SHORT_ARG_DRIVER_NAME = "-d";
    public static final String LONG_ARG_DRIVER_NAME = "-driver";

    public void setValueArgUserName(String valueArgUserName) {
        this.valueArgUserName = valueArgUserName;
    }

    public String getValueArgUserName() {
        return valueArgUserName;
    }

    public void setValueArgUserPassword(String valueArgUserPassword) {
        this.valueArgUserPassword = valueArgUserPassword;
    }

    public String getValueArgUserPassword() {
        return valueArgUserPassword;
    }

    public void setValueArgDbURL(String valueArgDbURL) {
        this.valueArgDbURL = valueArgDbURL;
    }

    public String getValueArgDbURL() {
        return valueArgDbURL;
    }

    public void setValueArgDriverName(String valueArgDriverName) {
        this.valueArgDriverName = valueArgDriverName;
    }

    public String getValueArgDriverName() {
        return valueArgDriverName;
    }


}
