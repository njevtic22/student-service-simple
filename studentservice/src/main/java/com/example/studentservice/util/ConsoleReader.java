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
    private final Consumer<?> emptyValidator = o -> {};

    public ConsoleReader(
            @Qualifier("scanner.system.in") Scanner cin,
            @Qualifier("system.out") PrintStream cout,
            DateTimeUtil dateUtil
    ) {
        this.cin = cin;
        this.cout = cout;
        this.dateUtil = dateUtil;
    }

    public int nextInt() {
        return nextInt("");
    }

    public int nextInt(String label) {
        return nextInt(label, castConsumer(emptyValidator));
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
    private <T> Consumer<T> castConsumer(Consumer<?> consumer) {
        return (Consumer<T>) consumer;
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
