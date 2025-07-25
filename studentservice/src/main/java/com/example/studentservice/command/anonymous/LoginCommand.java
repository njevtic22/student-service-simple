package com.example.studentservice.command.anonymous;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.model.User;
import com.example.studentservice.security.AuthenticationService;
import com.example.studentservice.util.Colors;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@CommandGroup("anonymous-menu")
public class LoginCommand implements Command {
    private final AuthenticationService service;
    private final Command authCommand;
    private final ConsoleReader console;

    public LoginCommand(
            AuthenticationService service,
            // Injected by name
            Command authenticatedCommand,
            ConsoleReader console
    ) {
        this.service = service;
        this.authCommand = authenticatedCommand;
        this.console = console;
    }

    @Override
    public void execute() {
        User authenticated = null;

        while (authenticated == null) {
            String username = console.nextLine("Enter username: ");
            String password = console.nextPassword("Enter password: ");

            try {
                authenticated = (User) service.authenticate(username, password);
            } catch (BadCredentialsException e) {
                System.out.println();
                System.out.println(Colors.likeError(e.getMessage()));

                boolean tryAgain = console.nextDecision("Would you like to try again (enter \"yes\" or \"no\"): ");
                if (!tryAgain) {
                    return;
                }
                System.out.println();
            }
        }

        authCommand.execute();
    }

    @Override
    public String getDescription() {
        return "Log in";
    }
}
