package com.example.studentservice.util;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleReader {
    private Scanner in = new Scanner(System.in);

    public String nextLine() {
        return nextLine("");
    }

    public String nextLine(String label) {
        String input = "";
        boolean read = false;

        do {
            System.out.print(label);
            input = in.nextLine();

            if (input.isBlank()) {
                System.out.println("\nYou did not enter anything.\nTry again.\n");
            } else {
                read = true;
            }
        } while (!read);

        return input;
    }
}
