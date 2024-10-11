package com.example.studentservice.util.old;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class is designed to be singleton to provide only one instance of Scanner(System.in)
 * which eliminates multiple Scanners for System.in.
 * Meant for reading exclusively from console (System.in).
 *
 * VEB project
 */
public class V2RawConsoleReader {
    private static V2RawConsoleReader instance;
    private Scanner scanner = new Scanner(System.in);
    private String dateFormat = null;
    private SimpleDateFormat formatter = null;

    private V2RawConsoleReader() { }

    public static V2RawConsoleReader getInstance() {
        if (instance == null)
            instance = new V2RawConsoleReader();
        return instance;
    }

    public byte nextByte() {
        byte b = 0;
        try {
            b = scanner.nextByte();
        } finally {
            scanner.nextLine();
        }
        return b;
    }

    public char nextChar() {
        char c = '\u0000';
        String s = scanner.nextLine().strip();
        if (s.length() == 1)
            c = s.charAt(0);
        else
            throw new InputMismatchException("Character is expected, not string.");
        return c;
    }

    public short nextShort() {
        short s = 0;
        try {
            s = scanner.nextShort();
        } catch (InputMismatchException e) {
            scanner.nextLine();
        }
        return s;
    }

    public int nextInt() {
        int i;
        try {
            i = scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
        return i;
    }

    public long nextLong() {
        long l;
        try {
            l = scanner.nextLong();
        } finally {
            scanner.nextLine();
        }
        return l;
    }

    public float nextFloat() {
        float f;
        try {
            f = scanner.nextFloat();
        } finally {
            scanner.nextLine();
        }
        return f;
    }

    public double nextDouble() {
        double d;
        try {
            d = scanner.nextDouble();
        } finally {
            scanner.nextLine();
        }
        return d;
    }

    public String nextLine() {
        String s = scanner.nextLine().strip();
        if (s.isEmpty())
            throw new InputMismatchException("Input string must not be empty.");
        return s;
    }

    public boolean nextBoolean() {
        boolean b;
        try {
            b = scanner.nextBoolean();
        } finally {
            scanner.nextLine();
        }
        return b;
    }

    public boolean nextDecision() {
        String s = scanner.nextLine().strip();
        if (!s.equalsIgnoreCase("da") && !s.equalsIgnoreCase("ne"))
            throw new InputMismatchException("String does not represent decision (yes or no)");
        return s.equalsIgnoreCase("da");
    }

    public String nextStringDecision() {
        String s = scanner.nextLine().strip();
        if (!s.equalsIgnoreCase("da") && !s.equalsIgnoreCase("ne"))
            throw new InputMismatchException("String does not represent decision (yes or no)");
        return s;
    }

    public Date nextDate() throws ParseException {
        if (dateFormat == null)
            dateFormat = "dd.MM.yyyy."; // "dd.MM.yyyy. HH:mm"

        if (formatter == null) {
            formatter = new SimpleDateFormat(dateFormat);
            formatter.setLenient(false);
        }
        return formatter.parse(nextLine());
    }

    public void closeScanner() {
        scanner.close();
    }

    public String getDateFormat() {
        if (dateFormat == null)
            dateFormat = "dd.MM.yyyy. HH:mm:ss"; // "dd.MM.yyyy. HH:mm"
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        formatter.applyPattern(this.dateFormat);
    }
}
