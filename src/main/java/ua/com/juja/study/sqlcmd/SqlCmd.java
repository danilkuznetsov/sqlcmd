package ua.com.juja.study.sqlcmd;

/**
 * Hello world!
 */
public class SqlCmd {
    public static void main(String[] args) {
        System.out.println(validateCmdOption(parseCmdOption(args)));
    }

    public static SqlCmdConfig parseCmdOption(String[] args) {
        int position = 0;
        SqlCmdConfig config = new SqlCmdConfig();

        while (position < args.length-1) {
            String curArg = args[position];

            if (curArg.equals(SqlCmdConfig.SHORT_ARG_USER_NAME) || curArg.equals(SqlCmdConfig.LONG_ARG_USER_NAME)) {
                position++;
                if (!args[position].startsWith("-"))
                    config.setValueArgUserName(args[position]);
                continue;
            }
            if (curArg.equals(SqlCmdConfig.SHORT_ARG_USER_PASSWORD) || curArg.equals(SqlCmdConfig.LONG_ARG_USER_PASSWORD)) {
                position++;
                if (!args[position].startsWith("-"))
                    config.setValueArgUserPassword(args[position]);
                continue;
            }
            if (curArg.equals(SqlCmdConfig.SHORT_ARG_DB_URL) || curArg.equals(SqlCmdConfig.LONG_ARG_DB_URL)) {
                position++;
                if (!args[position].startsWith("-"))
                    config.setValueArgDbURL(args[position]);
                continue;
            }
            if (curArg.equals(SqlCmdConfig.SHORT_ARG_DRIVER_NAME) || curArg.equals(SqlCmdConfig.LONG_ARG_DRIVER_NAME)) {
                position++;
                if (!args[position].startsWith("-"))
                    config.setValueArgDriverName(args[position]);
                continue;
            }

            position++;
        }

        return config;
    }

    public static String validateCmdOption(SqlCmdConfig config) {
        StringBuilder result = new StringBuilder();

        if ((config.getValueArgUserName() == null) || config.getValueArgUserName().isEmpty()) {
            result.append("value arg user name is incorrect;");
        }

        if (config.getValueArgUserPassword() == null || config.getValueArgUserPassword().isEmpty()) {
            result.append("value arg user password is incorrect;");
        }

        if (config.getValueArgDbURL() == null || config.getValueArgDbURL().isEmpty()) {
            result.append("value arg db url is incorrect;");
        }

        if (config.getValueArgDriverName() == null || config.getValueArgDriverName().isEmpty()) {
            result.append("value arg driver name is incorrect;");
        }

        return result.toString();
    }
}
