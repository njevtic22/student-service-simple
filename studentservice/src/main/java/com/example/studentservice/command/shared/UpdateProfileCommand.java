package com.example.studentservice.command.shared;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.core.error.InputCanceledException;
import com.example.studentservice.model.User;
import com.example.studentservice.security.AuthenticationService;
import com.example.studentservice.service.UserService;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;


@Component
@Order(2)
@CommandGroup("user-shared")
public class UpdateProfileCommand implements Command {
    private final UserService service;
    private final AuthenticationService authService;
    private final ConsoleReader console;

    public UpdateProfileCommand(UserService service, AuthenticationService authService, ConsoleReader console) {
        this.service = service;
        this.authService = authService;
        this.console = console;
    }

    @Override
    public void execute() {
        String authUsername = authService.getAuthenticated().getUsername();

        try {
            User changes = readChanges();
            User updated = service.update(authUsername, changes);
            authService.reauthenticate(updated);
            System.out.println("Profile updated");

        } catch (InputCanceledException ignored) {
        }
    }

    @Override
    public String getDescription() {
        return "Update profile";
    }

    private User readChanges() {
        System.out.println("Updating profile");
        String name = console.nextLine("Enter name: ");
        String surname = console.nextLine("Enter surname: ");

        String authUsername = authService.getAuthenticated().getUsername();
        Consumer<String> validator = changedUsername -> {
            if (!authUsername.equals(changedUsername)) {
                service.validateUsername(changedUsername);
            }
        };
        String username = console.nextValidLine("Enter username: ", validator);

        return new User(
                name,
                surname,
                username,
                null,
                null
        );
    }
}
