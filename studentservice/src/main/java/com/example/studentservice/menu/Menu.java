package com.example.studentservice.menu;

import com.example.studentservice.command.Command;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Menu {
    public void printCommands(List<Command> commands) {
        System.out.println("Following commands are available:");
        int i = 0;
        for (Command command : commands) {
            System.out.println(++i + ". " + command.getDescription());
        }
        printExitOption(0);
    }

    public void printExitOption(int index) {
        System.out.println(index + ": Exit");
    }
}
