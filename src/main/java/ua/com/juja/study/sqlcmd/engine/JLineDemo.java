package ua.com.juja.study.sqlcmd.engine;

import jline.ConsoleReader;
import jline.CursorBuffer;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: viktor
 * Date: 11/12/14
 * Time: 2:08 PM
 */
public class JLineDemo {
    public static void main(String[] args) throws IOException {
        Writer writer = new PrintWriter(System.out);
        ConsoleReader consoleReader = new ConsoleReader(System.in, writer);
        CursorBuffer buf = consoleReader.getCursorBuffer();
        int key = 0;
        while ((key = consoleReader.readVirtualKey()) != 27) {
            System.out.println(key);
            switch (key) {
                case 127:
                    consoleReader.backspace();
                    break;
                case 10:
                    consoleReader.moveCursor(0);
                    consoleReader.printNewline();
                    buf.getBuffer().setLength(0);
                    buf.cursor = 0;
                    break;
                default:
                    buf.write((char) key);
                    writer.write(key);
            }
            consoleReader.flushConsole();
        }

    }

    private static String convertCodePoint(int key) {
        return new StringBuilder().appendCodePoint(key).toString();
    }
}
