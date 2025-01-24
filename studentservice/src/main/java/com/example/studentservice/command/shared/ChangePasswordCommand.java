package com.example.studentservice.command.shared;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.core.error.InputCanceledException;
import com.example.studentservice.security.AuthenticationService;
import com.example.studentservice.service.UserService;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Order(3)
@CommandGroup("user-shared")
public class ChangePasswordCommand implements Command {
    private final UserService service;
    private final AuthenticationService authService;
    private final ConsoleReader console;

    public ChangePasswordCommand(UserService service, AuthenticationService authService, ConsoleReader console) {
        this.service = service;
        this.authService = authService;
        this.console = console;
    }

    @Override
    public void execute() {
        try {
            String authUsername = authService.getAuthenticated().getUsername();
            String newPassword = readPassword();
            service.changePassword(authUsername, newPassword);
            System.out.println("Password changed");

        } catch (InputCanceledException ignored) {
        }
    }

    @Override
    public String getDescription() {
        return "Change password";
    }

    private String readPassword() {
        String currentEncodedPassword = authService.getAuthenticated().getPassword();

        Consumer<String> oldPasswordValidator = oldPassword -> {
            service.validatePasswordMatch(currentEncodedPassword, oldPassword, "", "");
        };
        String oldPassword = console.nextPassword("Enter current password: ", oldPasswordValidator);

        String newPassword = console.nextPassword("Enter new password: ", service::validatePassword);

        Consumer<String> passwordMatchValidator = repeatedPassword -> {
            service.validatePasswordMatch(currentEncodedPassword, oldPassword, newPassword, repeatedPassword);
        };
        console.nextPassword("Confirm new password: ", passwordMatchValidator);

        return newPassword;
    }
}
