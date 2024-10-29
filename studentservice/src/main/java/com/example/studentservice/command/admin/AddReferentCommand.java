package com.example.studentservice.command.admin;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.core.error.UniquePropertyException;
import com.example.studentservice.model.Role;
import com.example.studentservice.model.User;
import com.example.studentservice.service.UserService;
import com.example.studentservice.util.Colors;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
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

            // TODO: validate input immediately
            System.out.println("Adding referent");
            String name = console.nextLine("Enter name: ");
            String surname = console.nextLine("Enter surname: ");
            String username = console.nextLine("Enter username: ");
            String password = console.nextLine("Enter password: ");

            User newReferent = new User(
                    name,
                    surname,
                    username,
                    password,
                    Role.REFERENT
            );

            try {
                added = service.add(newReferent);
                System.out.println("Referent added");
            } catch (UniquePropertyException e) {
                System.out.println();
                System.out.println(Colors.likeError(e.getMessage()));

                boolean tryAgain = console.nextDecision("Would you like to try again (enter \"yes\" or \"no\"): ");
                if (!tryAgain) {
                    break;
                }
                System.out.println();
            }
        }
    }

    @Override
    public String getDescription() {
        return "Add referent";
    }
}
