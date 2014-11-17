package ua.com.juja.study.sqlcmd.io;

import jline.ConsoleReader;
import jline.CursorBuffer;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 11/17/14
 * Time: 9:42 PM
 */
public class SqlConsoleReader {

    public static final int SEMICOLON = 59;
    public static final int NEW_LINE = 10;
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
                case NEW_LINE:
                    if (previousKey == SEMICOLON) {
                        exit = true;
                    } else {
                        sb.append(" ");
                        newLine();
                    }
                    break;
                case 127:
                    consoleReader.backspace();

                    break;
                default:
                    sb.appendCodePoint(key);
                    cursorBuffer.write((char) key);
                    writer.write(key);
            }
            previousKey = key;
            consoleReader.flushConsole();
        }
        return sb.toString();
    }

    private void newLine() throws IOException {
        consoleReader.moveCursor(0);
        consoleReader.printNewline();
        cursorBuffer.getBuffer().setLength(0);
        cursorBuffer.cursor = 0;

    }

//    private class ConsoleWriter extends PrintWriter{
//        private StringBuilder input = new StringBuilder();
//        public ConsoleWriter(Writer out) {
//            super(out);
//        }
//
//        @Override
//        public void write(int codePoint) {
//            super.write(codePoint);
//            input.appendCodePoint(codePoint);
//        }
//
//        @Override
//        public void write(char[] buf) {
//            super.write(buf);
//            input.append(buf);
//        }
//
//        public String getInputAndClear(){
//            String res = input.toString();
//            input = new StringBuilder();
//            return res;
//        }
//    }
}
