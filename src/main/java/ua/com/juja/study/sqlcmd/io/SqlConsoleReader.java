package ua.com.juja.study.sqlcmd.io;

import jline.ConsoleReader;
import jline.CursorBuffer;

import java.io.*;

import static ua.com.juja.study.sqlcmd.io.KeyCodes.*;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 11/17/14
 * Time: 9:42 PM
 */
public class SqlConsoleReader {

    private ConsoleReader consoleReader;
    private Writer writer;
    private CursorBuffer cursorBuffer;

    public SqlConsoleReader(InputStream inputStream, OutputStream out) throws IOException {
        writer = new PrintWriter(out);
        consoleReader = new ConsoleReader(inputStream, writer);
        cursorBuffer = consoleReader.getCursorBuffer();
    }

    public String readQuery() throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean exit = false;
        int previousKey = 0;
        while (!exit) {
            int key = consoleReader.readVirtualKey();
            switch (key) {
                case KeyCodes.NEW_LINE:
                    sb.append(cursorBuffer.toString());
                    if (previousKey == SEMICOLON) {
                        exit = true;
                    } else {
                        sb.append(" ");
                        newLine();
                    }
                    break;
                case BACKSPACE:
                    consoleReader.backspace();
                    break;
                case LEFT:
                    consoleReader.moveCursor(-1);
                    break;
                case RIGHT:
                    consoleReader.moveCursor(1);
                    break;
                case END:
                    moveToEnd();
                    break;
                case KeyCodes.HOME:
                    moveToBegin();
                    break;
                case 98:

                default:
                    cursorBuffer.write((char) key);
                    writer.write(key);
            }
            previousKey = key;
            consoleReader.flushConsole();
        }
        return sb.toString();
    }

    private void moveToBegin() throws IOException {
        consoleReader.moveCursor(-cursorBuffer.length());
    }

    private void moveToEnd() throws IOException {
        consoleReader.moveCursor(cursorBuffer.length() - cursorBuffer.cursor);
    }

    private void newLine() throws IOException {
        consoleReader.moveCursor(0);
        consoleReader.printNewline();
        cursorBuffer.clearBuffer();
        cursorBuffer.cursor = 0;
    }

}
