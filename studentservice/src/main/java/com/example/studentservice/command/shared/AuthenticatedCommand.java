package com.example.studentservice.command.shared;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.menu.Menu;
import com.example.studentservice.model.Role;
import com.example.studentservice.model.User;
import com.example.studentservice.security.AuthenticationService;
import com.example.studentservice.util.Colors;
import com.example.studentservice.util.ConsoleReader;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthenticatedCommand implements Command {
    private final AuthenticationService service;
    private final List<Command> adminCommands;
    private final List<Command> referentCommands;
    private final List<Command> sharedCommands;
    private final ConsoleReader console;
    private final Menu menu;

    public AuthenticatedCommand(
            AuthenticationService service,
            @CommandGroup("admin-menu") List<Command> adminCommands,
            @CommandGroup("referent-menu") List<Command> referentCommands,
            @CommandGroup("user-shared") List<Command> sharedCommands,
            ConsoleReader console,
            Menu menu
    ) {
        this.service = service;
        this.adminCommands = adminCommands;
        this.referentCommands = referentCommands;
        this.sharedCommands = sharedCommands;
        this.console = console;
        this.menu = menu;
    }

    @PostConstruct
    public void init() {
        adminCommands.addAll(sharedCommands);
        referentCommands.addAll(sharedCommands);
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
