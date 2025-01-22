package com.example.studentservice.util;

import com.example.studentservice.core.error.InputCanceledException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.io.PrintStream;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
public class ConsoleReader {
    private final Scanner cin;
    private final PrintStream cout;        // sugar code
    private final DateTimeUtil dateUtil;
    // unnecessary because you could just call method which does not require validator
    private final Consumer<?> empty = o -> {};

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
        return nextByte(label, getEmpty());
    }

    public byte nextByte(Consumer<Byte> validator) {
        return nextByte("", validator);
    }

    public byte nextByte(String label, Consumer<Byte> validator) {
        return nextValid(label, cin::nextByte, validator, "byte");
    }

    public char nextChar() {
        return nextChar("");
    }

    public char nextChar(String label) {
        return nextChar(label, getEmpty());
    }

    public char nextChar(Consumer<Character> validator) {
        return nextChar("", validator);
    }

    public char nextChar(String label, Consumer<Character> validator) {
        Supplier<Character> reader = () -> {
            String input = cin.next();
            if (input.length() == 1) {
                return input.charAt(0);
            } else {
                throw new InputMismatchException("Character is expected, but string is read");
            }
        };

        return nextValid(label, reader, validator, "character");
    }

    public short nextShort() {
        return nextShort("");
    }

    public short nextShort(String label) {
        return nextShort(label, getEmpty());
    }

    public short nextShort(Consumer<Short> validator) {
        return nextShort("", validator);
    }

    public short nextShort(String label, Consumer<Short> validator) {
        return nextValid(label, cin::nextShort, validator, "short");
    }

    public int nextInt() {
        return nextInt("");
    }

    public int nextInt(String label) {
        return nextInt(label, getEmpty());
    }

    public int nextInt(Consumer<Integer> validator) {
        return nextInt("", validator);
    }

    public int nextInt(String label, Consumer<Integer> validator) {
        return nextValid(label, cin::nextInt, validator, "integer");
    }

    public long nextLong() {
        return nextLong("");
    }

    public long nextLong(String label) {
        return nextLong(label, getEmpty());
    }

    public long nextLong(Consumer<Long> validator) {
        return nextLong("", validator);
    }

    public long nextLong(String label, Consumer<Long> validator) {
        return nextValid(label, cin::nextLong, validator, "long");
    }

    public float nextFloat() {
        return nextFloat("");
    }

    public float nextFloat(String label) {
        return nextFloat(label, getEmpty());
    }

    public float nextFloat(Consumer<Float> validator) {
        return nextFloat("", validator);
    }

    public float nextFloat(String label, Consumer<Float> validator) {
        return nextValid(label, cin::nextFloat, validator, "float");
    }

    public double nextDouble() {
        return nextDouble("");
    }

    public double nextDouble(String label) {
        return nextDouble(label, getEmpty());
    }

    public double nextDouble(Consumer<Double> validator) {
        return nextDouble("", validator);
    }

    public double nextDouble(String label, Consumer<Double> validator) {
        return nextValid(label, cin::nextDouble, validator, "double");
    }

    public boolean nextBoolean() {
        return nextBoolean("");
    }

    public boolean nextBoolean(String label) {
        return nextBoolean(label, getEmpty());
    }

    public boolean nextBoolean(Consumer<Boolean> validator) {
        return nextBoolean("", validator);
    }

    public boolean nextBoolean(String label, Consumer<Boolean> validator) {
        return nextValid(label, cin::nextBoolean, validator, "boolean");
    }

    // TODO: add boolean blankAllowed without validator
    public String nextLine() {
        return nextLine("");
    }

    public String nextLine(String label) {
        return nextLine(label, getEmpty());
    }

    public String nextLine(Consumer<String> validator) {
        return nextLine("", validator);
    }

    public String nextLine(String label, Consumer<String> validator) {
        return nextLine(label, validator, false);
    }

    public String nextLine(String label, Consumer<String> validator, boolean blankAllowed) {
        String input = null;
        while (input == null) {
            cout.print(label);
            String tmp = cin.nextLine();

            if (!blankAllowed) {
                tmp = tmp.strip();
                if (tmp.isEmpty()) {
                    cout.println(Colors.likeError("\nYou did not enter anything.\nTry again."));
                    continue;
                }
            }

            try {
                validator.accept(tmp);
                input = tmp;
            } catch (RuntimeException e) {
                handleFailedValidation(e);
            }
        }
        return input;
    }

    public String nextPassword() {
        return nextPassword("");
    }

    public String nextPassword(String label) {
        return nextPassword(label, getEmpty());
    }

    public String nextPassword(Consumer<String> validator) {
        return nextPassword("", validator);
    }

    public String nextPassword(String label, Consumer<String> validator) {
        Console console = System.console();
        if (console == null) {
            return nextLine(label, validator, true);
        }

        String password = null;
        while (password == null) {
            String tmp = new String(console.readPassword(label));

            try {
                validator.accept(tmp);
                password = tmp;
            } catch (RuntimeException e) {
                handleFailedValidation(e);
            }
        }

        return password;
    }

    public boolean nextDecision() {
        return nextDecision("");
    }

    public boolean nextDecision(String label) {
        return nextDecision(label, "yes", "no");
    }

    public boolean nextDecision(String label, String yes, String no) {
        Supplier<Boolean> reader = () -> {
            String decision = nextStringDecision(yes, no);
            return decision.equalsIgnoreCase(yes);
        };
        Consumer<InputMismatchException> handler = e ->
                cout.println(Colors.likeError("\nYou did not enter \"" + yes + "\" or \"" + no + "\".\nTry again."));
        return nextRead(label, reader, handler);
    }

    public String nextStringDecision() {
        return nextStringDecision("");
    }

    public String nextStringDecision(String label) {
        return nextStringDecision(label, "yes", "no");
    }

    public String nextStringDecision(String label, String yes, String no) {
        Supplier<String> reader = () -> nextStringDecision(yes, no);
        Consumer<InputMismatchException> handler = e ->
                cout.println(Colors.likeError("\nYou did not enter \"" + yes + "\" or \"" + no + "\".\nTry again."));
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
        return nextDate(label, format, getEmpty());
    }

    public LocalDate nextDate(Consumer<LocalDate> validator) {
        return nextDate("", validator);
    }

    public LocalDate nextDate(String label, Consumer<LocalDate> validator) {
        return nextDate(label, DateTimeUtil.ISO_DATE, validator);
    }

    public LocalDate nextDate(String label, String format, Consumer<LocalDate> validator) {
        // If date format has spaces then this solution would not work
        // then maybe it would be better to implement it like nextDateTime
        Supplier<LocalDate> reader = () -> {
            String input = cin.next();
            return dateUtil.parseDate(input, format);
        };

        Consumer<DateTimeException> handler = e ->
                cout.println(Colors.likeError("\nYou did not enter date in '" + format + "' format or date is invalid.\nTry again."));
        return nextValid(label, reader, validator, Throwable::printStackTrace, handler);
    }

    public LocalTime nextTime() {
        return nextTime("");
    }

    public LocalTime nextTime(String label) {
        return nextTime(label, DateTimeUtil.ISO_TIME);
    }

    public LocalTime nextTime(String label, String format) {
        return nextTime(label, format, getEmpty());
    }

    public LocalTime nextTime(Consumer<LocalTime> validator) {
        return nextTime("", validator);
    }

    public LocalTime nextTime(String label, Consumer<LocalTime> validator) {
        return nextTime(label, DateTimeUtil.ISO_TIME, validator);
    }

    public LocalTime nextTime(String label, String format, Consumer<LocalTime> validator) {
        // If time format has spaces then this solution would not work
        // then maybe it would be better to implement it like nextDateTime
        Supplier<LocalTime> reader = () -> {
            String input = cin.next();
            return dateUtil.parseTime(input, format);
        };

        Consumer<DateTimeException> handler = e ->
                cout.println(Colors.likeError("\nYou did not enter time in '" + format + "' format or time is invalid.\nTry again."));
        return nextValid(label, reader, validator, Throwable::printStackTrace, handler);
    }

    public LocalDateTime nextDateTime() {
        return nextDateTime("");
    }

    public LocalDateTime nextDateTime(String label) {
        return nextDateTime(label, DateTimeUtil.ISO_DATE_TIME);
    }

    public LocalDateTime nextDateTime(String label, String format) {
        return nextDateTime(label, format, getEmpty());
    }

    public LocalDateTime nextDateTime(Consumer<LocalDateTime> validator) {
        return nextDateTime("", validator);
    }

    public LocalDateTime nextDateTime(String label, Consumer<LocalDateTime> validator) {
        return nextDateTime(label, DateTimeUtil.ISO_DATE_TIME, validator);
    }

    public LocalDateTime nextDateTime(String label, String format, Consumer<LocalDateTime> validator) {
        LocalDateTime date = null;
        while (date == null) {
            cout.print(label);
            String input = cin.nextLine().strip();
            try {
                LocalDateTime tmp = dateUtil.parseDateTime(input, format);
                validator.accept(tmp);
                date = tmp;
            } catch (DateTimeException e) {
                cout.println(Colors.likeError(
                        "\nYou did not enter date and time in '" + format + "' format or date and time is invalid.\nTry again."));
            } catch (RuntimeException e) {
                handleFailedValidation(e);
            }
        }
        return date;
    }

    public void close() {
        cin.close();
    }

    @SuppressWarnings("unchecked")
    private <T> Consumer<T> getEmpty() {
        return (Consumer<T>) empty;
    }

    private <T> T nextValid(String label, Supplier<T> reader, Consumer<T> validator,  String type) {
        Consumer<InputMismatchException> handler = e ->
                cout.println(Colors.likeError("\nYou did not enter " + type + " or there was an overflow.\nTry again."));
        return nextValid(label, reader, validator, handler);
    }

    private <T> T nextValid(String label, Supplier<T> reader, Consumer<T> validator,  Consumer<InputMismatchException> handler) {
        return nextValid(label, reader, validator, handler, Throwable::printStackTrace);
    }

    private <T> T nextValid(
            String label,
            Supplier<T> reader,
            Consumer<T> validator,
            Consumer<InputMismatchException> mismatchHandler,
            Consumer<DateTimeException> parseHandler
    ) {
        T input = null;

        while (input == null) {
            T tmp = nextRead(label, reader, mismatchHandler, parseHandler);
            try {
                validator.accept(tmp);
            } catch (RuntimeException e) {
                handleFailedValidation(e);
                continue;
            }
            input = tmp;
        }

        return input;
    }

    private void handleFailedValidation(RuntimeException e) {
        cout.println();
        cout.println(Colors.likeError(e.getMessage()));

        boolean tryAgain = nextDecision("Would you like to try again (enter \"yes\" or \"no\"): ");
        if (!tryAgain) {
            throw new InputCanceledException();
        }
        cout.println();
    }

    private <T> T nextRead(String label, Supplier<T> reader, String type) {
        Consumer<InputMismatchException> handler = e ->
                cout.println(Colors.likeError("\nYou did not enter " + type + " or there was an overflow.\nTry again."));
        return nextRead(label, reader, handler);
    }

    private <T> T nextRead(String label, Supplier<T> reader, Consumer<InputMismatchException> handler) {
        return nextRead(label, reader, handler, Throwable::printStackTrace);
    }

    private <T> T nextRead(
            String label,
            Supplier<T> reader,
            Consumer<InputMismatchException> mismatchHandler,
            Consumer<DateTimeException> parseHandler
    ) {
        T input = null;

        while (input == null) {
            try {
                cout.print(label);
                input = reader.get();
            } catch (InputMismatchException e) {
                mismatchHandler.accept(e);
            } catch (DateTimeException e) {
                parseHandler.accept(e);
            } finally {
                cin.nextLine();
            }
        }

        return input;
    }
}
