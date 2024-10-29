package com.example.studentservice.command.anonymous;

import com.example.studentservice.command.AuthenticatedCommand;
import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.model.User;
import com.example.studentservice.security.AuthenticationService;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@CommandGroup("anonymous-menu")
public class LoginCommand implements Command {
    private final AuthenticationService service;
    private final AuthenticatedCommand authCommand;
    private final ConsoleReader console;

    public LoginCommand(
            AuthenticationService service,
            @Qualifier("authenticated-command") AuthenticatedCommand authCommand,
            ConsoleReader console
    ) {
        this.service = service;
        this.authCommand = authCommand;
        this.console = console;
    }

    @Override
    public void execute() {
        String username = console.nextLine("Enter username: ");
        String password = console.nextLine("Enter password: ");
        // TODO: add try again
        User authenticated = (User) service.authenticate(username, password);

        authCommand.execute();
    }

    @Override
    public String getDescription() {
        return "Log in";
    }
}
