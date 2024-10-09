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
        Byte input = null;
        while (input == null) {
            input = read(label, cin::nextByte, "byte");
        }
        return input;
    }

    public char nextChar() {
        return nextChar("");
    }

    public char nextChar(String label) {
        Character input = null;

        TypeReader<Character> charReader = () -> {
            String s = cin.next().strip();
            if (s.length() == 1) {
                return s.charAt(0);
            } else {
                throw new InputMismatchException("Character is expected, but string is read");
            }
        };

        while (input == null) {
            input = read(label, charReader, "character");
        }
        return input;
    }

    public short nextShort() {
        return nextShort("");
    }

    public short nextShort(String label) {
        Short input = null;
        while (input == null) {
            input = read(label, cin::nextShort, "short");
        }
        return input;
    }

    public int nextInt() {
        return nextInt("");
    }

    public int nextInt(String label) {
        Integer input = null;
        while (input == null) {
            input = read(label, cin::nextInt, "integer");
        }
        return input;
    }

    public long nextLong() {
        return nextLong("");
    }

    public long nextLong(String label) {
        return 0;
    }

    public float nextFloat() {
        return nextFloat("");
    }

    public float nextFloat(String label) {
        return 0;
    }

    public double nextDouble() {
        return nextDouble("");
    }

    public double nextDouble(String label) {
        return 0;
    }

    public String nextLine() {
        return nextLine("");
    }

    public String nextLine(String label) {
        String input = "";
        boolean notRead = true;

        do {
            cout.print(label);
            input = cin.nextLine();
            notRead = input.isBlank();

            if (notRead) {
                cout.println("\nYou did not enter anything.\nTry again.\n");
            }
        } while (notRead);

        return input;
    }

    public boolean nextBoolean() {
        return nextBoolean("");
    }

    public boolean nextBoolean(String label) {
        return false;
    }

    public boolean nextDecision() {
        return nextDecision("");
    }

    public boolean nextDecision(String label) {
        return false;
    }

    public String nextStringDecision() {
        return nextStringDecision("");
    }

    public String nextStringDecision(String label) {
        return "";
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

    private <T> T read(String label, TypeReader<T> reader, String type) {
        T input = null;

        try {
            cout.print(label);
            input = reader.nextType();
        } catch (InputMismatchException e) {
            cout.println("\nYou did not enter " + type + " or there was an overflow.\nTry again.\n");
        } finally {
            cin.nextLine();
        }

        return input;
    }
}
