package com.example.studentservice.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class ConsoleReader {
    private final Scanner cin;
    private final PrintStream cout;        // sugar code
    private final DateTimeService parser;

    public ConsoleReader(
            @Qualifier("scanner.system.in") Scanner cin,
            @Qualifier("system.out") PrintStream cout,
            DateTimeService parser
    ) {
        this.cin = cin;
        this.cout = cout;
        this.parser = parser;
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
        InputMismatchHandler handler = e -> cout.println("\nYou did not enter anything.\nTry again.\n");
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
        InputMismatchHandler handler = e -> cout.println("\nYou did not enter \"" + yes + "\" or \"" + no + "\".\nTry again.\n");
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
        InputMismatchHandler handler = e -> cout.println("\nYou did not enter \"" + yes + "\" or \"" + no + "\".\nTry again.\n");
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
        // use parser as well
        return nextDate("", "uuuu-MM-dd");
    }

    public LocalDate nextDate(String label, String format) {
        // use parser as well
        return null;
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
        InputMismatchHandler handler = e ->
                cout.println("\nYou did not enter " + type + " or there was an overflow.\nTry again.\n");
        return nextRead(label, reader, handler);
    }

    private <T> T nextRead(String label, TypeReader<T> reader, InputMismatchHandler handler) {
        T input = null;
        while (input == null) {
            input = readOnce(label, reader, handler);
        }
        return input;
    }

    private <T> T readOnce(String label, TypeReader<T> reader, InputMismatchHandler handler) {
        T input = null;

        try {
            cout.print(label);
            input = reader.nextType();
        } catch (InputMismatchException e) {
            handler.handle(e);
        } finally {
            cin.nextLine();
        }

        return input;
    }
}
