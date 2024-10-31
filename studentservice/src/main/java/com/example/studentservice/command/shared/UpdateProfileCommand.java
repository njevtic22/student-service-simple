package com.example.studentservice.command.shared;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.service.UserService;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(3)
@CommandGroup("user-shared")
public class UpdateProfileCommand implements Command {
    private final UserService service;
    private final ConsoleReader console;

    public UpdateProfileCommand(UserService service, ConsoleReader console) {
        this.service = service;
        this.console = console;
    }

    @Override
    public void execute() {
        System.out.println("Executing update self");
    }

    @Override
    public String getDescription() {
        return "Update profile";
    }
}
