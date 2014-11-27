package ua.com.juja.study.sqlcmd;

import ua.com.juja.study.sqlcmd.config.SqlCmdConfig;
import ua.com.juja.study.sqlcmd.config.ValidationException;
import ua.com.juja.study.sqlcmd.di.ApplicationContext;
import ua.com.juja.study.sqlcmd.di.DefaultApplicationContext;

import java.io.IOException;

import static ua.com.juja.study.sqlcmd.config.SqlCmdConfigValidator.validateCmdOption;

/**
 */
public class SqlCmd {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void main(String[] args) {
        SqlCmdConfig config = parseCmdOption(args);
        try {
            validateCmdOption(config);
            applicationContext = new DefaultApplicationContext(config);
            applicationContext.getKeyboardManager().startListenUserKeyboard();
        } catch (ValidationException e) {
            System.err.println("Invalid initial parameters. Unable to continue working");
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error with input/output happened. Unable to continue working");
            System.err.println(e.getMessage());
            System.exit(1);
        } finally {
            applicationContext.shutdown();
        }
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

}
