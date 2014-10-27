package ua.com.juja.study.sqlcmd;

import ua.com.juja.study.sqlcmd.config.SqlCmdConfig;

/**
 */
public class SqlCmd {
    public static void main(String[] args) {
        SqlCmdConfig config = parseCmdOption(args);
        if (!validateCmdOption(config))
            System.out.println("args[] is correct ");
        else System.exit(1);
    }

    public static SqlCmdConfig parseCmdOption(String[] args) {
        int position = 0;
        SqlCmdConfig config = new SqlCmdConfig();

        while (position < args.length - 1) {
            String curArg = args[position];

            if (curArg.equals(SqlCmdConfig.SHORT_ARG_USER_NAME) || curArg.equals(SqlCmdConfig.LONG_ARG_USER_NAME)) {
                position++;
                if (!args[position].startsWith("-"))
                    config.setUserName(args[position]);
                continue;
            }
            if (curArg.equals(SqlCmdConfig.SHORT_ARG_USER_PASSWORD) || curArg.equals(SqlCmdConfig.LONG_ARG_USER_PASSWORD)) {
                position++;
                if (!args[position].startsWith("-"))
                    config.setPassword(args[position]);
                continue;
            }
            if (curArg.equals(SqlCmdConfig.SHORT_ARG_DB_URL) || curArg.equals(SqlCmdConfig.LONG_ARG_DB_URL)) {
                position++;
                if (!args[position].startsWith("-"))
                    config.setDbUrl(args[position]);
                continue;
            }
            if (curArg.equals(SqlCmdConfig.SHORT_ARG_DRIVER_NAME) || curArg.equals(SqlCmdConfig.LONG_ARG_DRIVER_NAME)) {
                position++;
                if (!args[position].startsWith("-"))
                    config.setDriverName(args[position]);
                continue;
            }

            position++;
        }

        return config;
    }

    public static boolean validateCmdOption(SqlCmdConfig config) {
        StringBuilder strError = new StringBuilder();
        boolean error = false;

        if ((config.getUserName() == null) || config.getUserName().isEmpty()) {
            error = true;
            strError.append("value arg user name is incorrect;");
        }

        if (config.getPassword() == null || config.getPassword().isEmpty()) {
            error = true;
            strError.append("value arg user password is incorrect;");
        }

        if (config.getDbUrl() == null || config.getDbUrl().isEmpty()) {
            error = true;
            strError.append("value arg db url is incorrect;");
        }

        if (config.getDriverName() == null || config.getDriverName().isEmpty()) {
            error = true;
            strError.append("value arg driver name is incorrect;");
        }

        if (error)
            System.out.println(strError.toString());

        return error;
    }
}
