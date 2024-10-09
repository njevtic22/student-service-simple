package com.example.studentservice;

import com.example.studentservice.command.Command;
import com.example.studentservice.menu.Menu;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainRunner implements ApplicationRunner {
    private final List<Command> commands;
    private final ConsoleReader reader;
    private final Menu menu;

    public MainRunner(List<Command> commands, ConsoleReader reader, Menu menu) {
        this.commands = commands;
        this.reader = reader;
        this.menu = menu;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while (true) {
            menu.printCommands(commands);
            String line = reader.nextLine("Enter number of desired command: ");
            int input = Integer.parseInt(line);

            if (input > 0 && input <= commands.size()) {
                commands.get(input - 1).execute();
            } else if (input == 0) {
                System.out.println("Shutdown");
                return;
            } else {
                System.out.println("Invalid option");
            }
            System.out.println();
        }
    }
}
