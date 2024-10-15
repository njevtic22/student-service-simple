package com.example.studentservice.menu;

import com.example.studentservice.command.Command;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Menu {
    public void printCommands(List<Command> commands) {
        int i = 0;
        for (Command command : commands) {
            System.out.println(++i + ". " + command.getDescription());
        }
    }

    public void printReturnOption(int index, String returnText) {
        System.out.println(index + ". " + returnText);
    }
}
