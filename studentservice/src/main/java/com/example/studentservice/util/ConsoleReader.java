package com.example.studentservice.util;

import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class ConsoleReader {
    private final Scanner cin = new Scanner(System.in);
    private final PrintStream cout = System.out;        // sugar code
    private final DateTimeService parser;

    public ConsoleReader(DateTimeService parser) {
        this.parser = parser;
    }

    public byte nextByte() {
        return nextByte("");
    }

    public byte nextByte(String label) {
        return 0;
    }

    public char nextChar() {
        return nextChar("");
    }

    public char nextChar(String label) {
        return 0;
    }

    public short nextShort() {
        return nextShort("");
    }

    public short nextShort(String label) {
        return 0;
    }

    public int nextInt() {
        return nextInt("");
    }

    public int nextInt(String label) {
        int input = 0;
        boolean read = false;

        do {
            try {
                cout.print(label);
                input = cin.nextInt();
                read = true;

            } catch (InputMismatchException e) {
                cout.println("\nYou did not enter integer or there was an overflow.\nTry again.\n");
            } finally {
                cin.nextLine();
            }

//           Another way
//            try {
//                i = Integer.parseInt(nextLine(label));
//                read = true;
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//            }
        } while (!read);
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
        boolean read = false;

        do {
            cout.print(label);
            input = cin.nextLine();

            if (input.isBlank()) {
                cout.println("\nYou did not enter anything.\nTry again.\n");
            } else {
                read = true;
            }
        } while (!read);

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
}
