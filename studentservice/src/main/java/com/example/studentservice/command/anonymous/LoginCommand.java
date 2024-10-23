package com.example.studentservice.command.anonymous;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.menu.Menu;
import com.example.studentservice.model.Referent;
import com.example.studentservice.security.AuthenticationService;
import com.example.studentservice.util.Colors;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
@CommandGroup("anonymous")
public class LoginCommand implements Command {
    private final AuthenticationService service;
    private final List<Command> commands;
    private final ConsoleReader console;
    private final Menu menu;

    public LoginCommand(AuthenticationService service, @CommandGroup("referent-menu") List<Command> commands, ConsoleReader console, Menu menu) {
        this.service = service;
        this.commands = commands;
        this.console = console;
        this.menu = menu;
    }

    @Override
    public void execute() {
//        String username = console.nextLine("Enter username: ");
//        String password = console.nextLine("Enter password: ");

        // Handle exception when user not found by username
        Referent authenticated = service.authenticate("", "");


        System.out.println(authenticated.getName() + " " + authenticated.getSurname() + " successfully logged in");
        while (true) {
            System.out.println("Following commands are available:");
            menu.printCommands(commands);
            System.out.println("0. Log out");

            int input = console.nextInt("Enter number of desired command: ");
            System.out.println();
            if (input > 0 && input <= commands.size()) {
                commands.get(input - 1).execute();
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
        return "Log in";
    }
}
