package com.example.studentservice.util;

import com.example.studentservice.core.error.InputCanceledException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

// Add nextPassword and nextValidPassword
// Add nextValidXxx for each method
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

    public void close() {
        cin.close();
    }

    @SuppressWarnings("unchecked")
    private <T> Consumer<T> getEmpty() {
        return (Consumer<T>) empty;
    }

    private <T> T nextValid(String label, Supplier<T> reader, Consumer<T> validator, String type) {
        T input = null;

        while (input == null) {
            T tmp = nextRead(label, reader, type);
            try {
                validator.accept(tmp);
            } catch (RuntimeException e) {
                cout.println();
                cout.println(Colors.likeError(e.getMessage()));

                boolean tryAgain = nextDecision("Would you like to try again (enter \"yes\" or \"no\"): ");
                if (!tryAgain) {
                    throw new InputCanceledException();
                }
                cout.println();
                continue;
            }
            input = tmp;
        }

        return input;
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
