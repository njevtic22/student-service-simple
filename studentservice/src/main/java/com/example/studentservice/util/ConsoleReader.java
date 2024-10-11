package com.example.studentservice.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class ConsoleReader {
    private final Scanner cin;
    private final PrintStream cout;        // sugar code
    private final DateTimeUtil dateUtil;

    public ConsoleReader(
            @Qualifier("scanner.system.in") Scanner cin,
            @Qualifier("system.out") PrintStream cout,
            DateTimeUtil dateUtil
    ) {
        this.cin = cin;
        this.cout = cout;
        this.dateUtil = dateUtil;
    }

    public byte nextByte() {
        return nextByte("");
    }

    public byte nextByte(String label) {
        return nextRead(label, cin::nextByte, "byte");
    }

    public char nextChar() {
        return nextChar("");
    }

    public char nextChar(String label) {
        TypeReader<Character> charReader = () -> {
            String s = cin.next().strip();
            if (s.length() == 1) {
                return s.charAt(0);
            } else {
                throw new InputMismatchException("Character is expected, but string is read");
            }
        };

        return nextRead(label, charReader, "character");
    }

    public short nextShort() {
        return nextShort("");
    }

    public short nextShort(String label) {
        return nextRead(label, cin::nextShort, "short");
    }

    public int nextInt() {
        return nextInt("");
    }

    public int nextInt(String label) {
        return nextRead(label, cin::nextInt, "integer");
    }

    public long nextLong() {
        return nextLong("");
    }

    public long nextLong(String label) {
        return nextRead(label, cin::nextLong, "long");
    }

    public float nextFloat() {
        return nextFloat("");
    }

    public float nextFloat(String label) {
        return nextRead(label, cin::nextFloat, "float");
    }

    public double nextDouble() {
        return nextDouble("");
    }

    public double nextDouble(String label) {
        return nextRead(label, cin::nextDouble, "double");
    }

    public String nextLine() {
        return nextLine("");
    }

    public String nextLine(String label) {
//        Old way
//        String input = "";
//        boolean read = false;
//
//        do {
//            cout.print(label);
//            input = cin.nextLine();
//            read = !input.isBlank();
//
//            if (!read) {
//                cout.println("\nYou did not enter anything.\nTry again.\n");
//            }
//        } while (!read);
//
//        return input;

        TypeReader<String> strReader = () -> {
            String input = cin.next().strip();
            // if is not needed because scanner.next() skips whitespace until it reaches character
            if (input.isBlank()) {
                throw new InputMismatchException("String is blank");
            }
            return input;
        };
        // handler is not needed because scanner.next() skips whitespace until it reaches character
        ExceptionHandler<InputMismatchException> handler = e -> cout.println("\nYou did not enter anything.\nTry again.\n");
        return nextRead(label, strReader, handler);
    }

    public boolean nextBoolean() {
        return nextBoolean("");
    }

    public boolean nextBoolean(String label) {
        return nextRead(label, cin::nextBoolean, "boolean");
    }

    public boolean nextDecision() {
        return nextDecision("");
    }

    public boolean nextDecision(String label) {
        return nextDecision(label, "yes", "no");
    }

    public boolean nextDecision(String label, String yes, String no) {
        TypeReader<Boolean> reader = () -> {
            String decision = nextStringDecision(yes, no);
            return decision.equalsIgnoreCase(yes);
        };
        ExceptionHandler<InputMismatchException> handler = e -> cout.println("\nYou did not enter \"" + yes + "\" or \"" + no + "\".\nTry again.\n");
        return nextRead(label, reader, handler);
    }

    public String nextStringDecision() {
        return nextStringDecision("");
    }

    public String nextStringDecision(String label) {
        return nextStringDecision(label, "yes", "no");
    }

    public String nextStringDecision(String label, String yes, String no) {
        TypeReader<String> reader = () -> nextStringDecision(yes, no);
        ExceptionHandler<InputMismatchException> handler = e -> cout.println("\nYou did not enter \"" + yes + "\" or \"" + no + "\".\nTry again.\n");
        return nextRead(label, reader, handler);
    }

    private String nextStringDecision(String yes, String no) {
        String decision = cin.next().strip();
        if (!decision.equalsIgnoreCase(yes) && !decision.equalsIgnoreCase(no)) {
            throw new InputMismatchException("String is not \"" + yes + "\" nor \"" + no + "\"");
        }
        return decision;
    }

    public LocalDate nextDate() {
        return nextDate("");
    }

    public LocalDate nextDate(String label) {
        return nextDate(label, DateTimeUtil.ISO_DATE);
    }

    public LocalDate nextDate(String label, String format) {
        TypeReader<LocalDate> dateReader = () -> {
            String input = cin.next().strip();
            return dateUtil.parseDate(input, format);
        };
        // Check nextLine for comments
        ExceptionHandler<DateTimeException> parseHandler = e -> cout.println("\nYou did not enter date in '" + format + "' format or date is invalid.\nTry again.\n");
        return nextRead(label, dateReader, Throwable::printStackTrace, parseHandler);
    }

    public LocalTime nextTime() {
        // use parser as well
        return nextTime("", "HH:mm:ss");
    }

    public LocalTime nextTime(String label, String format) {
        // use parser as well
        return null;
    }

    public LocalDateTime nextDateTime() {
        // use parser as well
        return nextDateTime("", "uuuu-MM-dd'T'HH:mm:ss");
    }

    public LocalDateTime nextDateTime(String label, String format) {
        // use parser as well
        return null;
    }

    public void close() {
        cin.close();
    }

    private <T> T nextRead(String label, TypeReader<T> reader, String type) {
        ExceptionHandler<InputMismatchException> handler = e ->
                cout.println("\nYou did not enter " + type + " or there was an overflow.\nTry again.\n");
        return nextRead(label, reader, handler);
    }

    private <T> T nextRead(String label, TypeReader<T> reader, ExceptionHandler<InputMismatchException> handler) {
        return nextRead(label, reader, handler, Throwable::printStackTrace);
    }

    private <T> T nextRead(
            String label,
            TypeReader<T> reader,
            ExceptionHandler<InputMismatchException> mismatchHandler,
            ExceptionHandler<DateTimeException> parseHandler
    ) {
        T input = null;
        while (input == null) {
            input = readOnce(label, reader, mismatchHandler, parseHandler);
        }
        return input;
    }

    private <T> T readOnce(
            String label,
            TypeReader<T> reader,
            ExceptionHandler<InputMismatchException> mismatchHandler,
            ExceptionHandler<DateTimeException> parseHandler
    ) {
        T input = null;

        try {
            cout.print(label);
            input = reader.nextType();
        } catch (InputMismatchException e) {
            mismatchHandler.handle(e);
        } catch (DateTimeException e) {
            parseHandler.handle(e);
        } finally {
            cin.nextLine();
        }

        return input;
    }
}
