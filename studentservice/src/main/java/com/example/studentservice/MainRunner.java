package com.example.studentservice;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.menu.Menu;
import com.example.studentservice.util.Colors;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainRunner implements ApplicationRunner {
    private final List<Command> commands;
    private final ConsoleReader console;
    private final Menu menu;

    public MainRunner(@CommandGroup("anonymous") List<Command> commands, ConsoleReader console, Menu menu) {
        this.commands = commands;
        this.console = console;
        this.menu = menu;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while (true) {
            System.out.println("Following commands are available:");
            menu.printCommands(commands);
            System.out.println("0. Exit");

            int input = console.nextInt("Enter number of desired command: ");
            System.out.println();
            if (input > 0 && input <= commands.size()) {
                commands.get(input - 1).execute();
            } else if (input == 0) {
                System.out.println(Colors.likeWarning("Shutdown"));
                console.close();
                return;
            } else {
                System.out.println(Colors.likeError("Invalid option"));
            }
            System.out.println();
        }
    }
}
