package com.example.studentservice.command;

import com.example.studentservice.menu.Menu;
import com.example.studentservice.model.Role;
import com.example.studentservice.model.User;
import com.example.studentservice.security.AuthenticationService;
import com.example.studentservice.util.Colors;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("authenticated-command")
public class AuthenticatedCommand implements Command {
    private final AuthenticationService service;
    private final List<Command> adminCommands;
    private final List<Command> referentCommands;
    private final ConsoleReader console;
    private final Menu menu;

    public AuthenticatedCommand(
            AuthenticationService service,
            @CommandGroup("admin-menu") List<Command> adminCommands,
            @CommandGroup("referent-menu") List<Command> referentCommands,
            ConsoleReader console,
            Menu menu
    ) {
        this.service = service;
        this.adminCommands = adminCommands;
        this.referentCommands = referentCommands;
        this.console = console;
        this.menu = menu;
    }

    @Override
    public void execute() {
        User authenticated = (User) service.getAuthenticated();
        System.out.println("\n" + authenticated.getName() + " " + authenticated.getSurname() + " successfully logged in");

        List<Command> chosenCommands = getChosenCommands(authenticated.getRole());
        while (true) {
            System.out.println("Following commands are available:");
            menu.printCommands(chosenCommands);
            System.out.println("0. Log out");

            int input = console.nextInt("Enter number of desired command: ");
            System.out.println();
            if (input > 0 && input <= chosenCommands.size()) {
                chosenCommands.get(input - 1).execute();
            } else if (input == 0) {
                service.invalidateAuthentication();
                System.out.println(Colors.likeWarning("Logged out"));
                return;
            } else {
                System.out.println(Colors.likeError("Invalid option"));
            }
            System.out.println();
        }
    }

    @Override
    public String getDescription() {
        return "";
    }

    private List<Command> getChosenCommands(Role role) {
//        Assumes there are only two roles and if more roles are added later than it will return referentCommands
//        as oppose the chosen solution which will throw error
//        return role == Role.ADMIN ? adminCommands : referentCommands;

        if (role == Role.ADMIN) {
            return adminCommands;
        } else if (role == Role.REFERENT) {
            return referentCommands;
        } else {
            throw new IllegalArgumentException("Role " + role.toString() + " is not supported");
        }
    }
}
