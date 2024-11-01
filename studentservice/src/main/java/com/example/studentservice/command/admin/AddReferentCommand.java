package com.example.studentservice.command.admin;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.core.error.InputCanceledException;
import com.example.studentservice.model.Role;
import com.example.studentservice.model.User;
import com.example.studentservice.service.UserService;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@CommandGroup("admin-menu")
public class AddReferentCommand implements Command {
    private final UserService service;
    private final ConsoleReader console;

    public AddReferentCommand(UserService service, ConsoleReader console) {
        this.service = service;
        this.console = console;
    }

    @Override
    public void execute() {
        User added = null;
        while (added == null) {

            try {
                User newReferent = readUser();
                added = service.add(newReferent);
                System.out.println("Referent added");

            } catch (InputCanceledException e) {
                return;
            }
        }
    }

    @Override
    public String getDescription() {
        return "Add referent";
    }

    private User readUser() {
        System.out.println("Adding referent");
        String name = console.nextLine("Enter name: ");
        String surname = console.nextLine("Enter surname: ");
        String username = console.nextValidLine("Enter username: ", service::validateUsername);
        String password = console.nextValidLine("Enter password: ", service::validatePassword);

        return new User(
                name,
                surname,
                username,
                password,
                Role.REFERENT
        );
    }
}
