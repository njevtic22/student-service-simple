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
        String input = null;
        while (input == null) {
            cout.print(label);
            String tmp = cin.nextLine().strip();

            if (tmp.isBlank()) {
                cout.println(Colors.likeError("\nYou did not enter anything.\nTry again.\n"));
            } else {
                input = tmp;
            }
        }
        return input;

//        Doesn't work if line has spaces because scanner.next() stops at whitespace
//        TypeReader<String> strReader = () -> {
//            String input = cin.next().strip();
//            // if is not needed because scanner.next() skips whitespace until it reaches character
//            if (input.isBlank()) {
//                throw new InputMismatchException("String is blank");
//            }
//            return input;
//        };
//        // handler is not needed because scanner.next() skips whitespace until it reaches character
//        ExceptionHandler<InputMismatchException> handler = e ->
//                cout.println(Colors.likeError("\nYou did not enter anything.\nTry again.\n"));
//        return nextRead(label, strReader, handler);
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
        ExceptionHandler<InputMismatchException> handler = e ->
                cout.println(Colors.likeError("\nYou did not enter \"" + yes + "\" or \"" + no + "\".\nTry again.\n"));
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
        ExceptionHandler<InputMismatchException> handler = e ->
                cout.println(Colors.likeError("\nYou did not enter \"" + yes + "\" or \"" + no + "\".\nTry again.\n"));
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
        ExceptionHandler<DateTimeException> parseHandler = e ->
                cout.println(Colors.likeError("\nYou did not enter date in '" + format + "' format or date is invalid.\nTry again.\n"));
        return nextRead(label, dateReader, Throwable::printStackTrace, parseHandler);
    }

    public LocalTime nextTime() {
        return nextTime("");
    }

    public LocalTime nextTime(String label) {
        return nextTime(label, DateTimeUtil.ISO_TIME);
    }

    public LocalTime nextTime(String label, String format) {
        TypeReader<LocalTime> timeReader = () -> {
            String input = cin.next();
            return dateUtil.parseTime(input, format);
        };
        // Check nextLine for comments
        ExceptionHandler<DateTimeException> parseHandler = e ->
                cout.println(Colors.likeError("\nYou did not enter time in '" + format + "' format or time is invalid.\nTry again.\n"));
        return nextRead(label, timeReader, Throwable::printStackTrace, parseHandler);
    }

    public LocalDateTime nextDateTime() {
        return nextDateTime("");
    }

    public LocalDateTime nextDateTime(String label) {
        return nextDateTime(label, DateTimeUtil.ISO_DATE_TIME);
    }

    public LocalDateTime nextDateTime(String label, String format) {
        // seems simpler
        LocalDateTime date = null;
        while (date == null) {
            cout.print(label);
            String input = cin.nextLine().strip();
            try {
                date = dateUtil.parseDateTime(input, format);
            } catch (DateTimeException e) {
                cout.println(Colors.likeError(
                        "\nYou did not enter date and time in '" + format + "' format or date and time is invalid.\nTry again.\n"));
            }
        }
        return date;

        // ignores asdf in "31.12.1980. 23:59:59 asdf"
//        TypeReader<LocalDateTime> dateTimeReader = () -> {
//            String[] formatSplit = format.split(" ");
//            StringBuilder input = new StringBuilder(formatSplit.length * 2);
//
//            // All of this is to leave new line for cin.nextLine() at the end of readOnce
//            for (String formatPart : formatSplit) {
//                String inputPart = cin.next();
//                if (inputPart.length() > formatPart.length() + 2) {
//                    break;
//                }
//
//                input.append(inputPart);
//                input.append(" ");
//            }
//
//            int inputLength = input.length();
//            if (inputLength > 0) {
//                input.setLength(inputLength - 1);
//            }
//            return dateUtil.parseDateTime(input.toString(), format);
//        };
//        // Check nextLine for comments
//        ExceptionHandler<DateTimeException> parseHandler = e ->
//                cout.println(Colors.likeError(
//                "\nYou did not enter date and time in '" + format + "' format or date and time is invalid.\nTry again.\n"));
//        return nextRead(label, dateTimeReader, Throwable::printStackTrace, parseHandler);
    }

    public void close() {
        cin.close();
    }

    private <T> T nextRead(String label, TypeReader<T> reader, String type) {
        ExceptionHandler<InputMismatchException> handler = e ->
                cout.println(Colors.likeError("\nYou did not enter " + type + " or there was an overflow.\nTry again.\n"));
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
