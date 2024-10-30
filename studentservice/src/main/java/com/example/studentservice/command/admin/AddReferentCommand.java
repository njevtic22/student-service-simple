package com.example.studentservice.command.admin;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.core.error.InputCanceledException;
import com.example.studentservice.core.error.UniquePropertyException;
import com.example.studentservice.model.Role;
import com.example.studentservice.model.User;
import com.example.studentservice.service.UserService;
import com.example.studentservice.util.Colors;
import com.example.studentservice.util.ConsoleReader;
import com.example.studentservice.util.InputValidator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
@Order(1)
@CommandGroup("admin-menu")
public class AddReferentCommand implements Command {
    private final UserService service;
    private final ConsoleReader console;
    private final InputValidator input;

    public AddReferentCommand(UserService service, ConsoleReader console, InputValidator input) {
        this.service = service;
        this.console = console;
        this.input = input;
    }

    @Override
    public void execute() {
        User added = null;
        while (added == null) {

            try {
                User newReferent = readUser();
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
        String username = readValidUsername();
        String password = readValidPassword();

        return new User(
                name,
                surname,
                username,
                password,
                Role.REFERENT
        );
    }

    private String readValidUsername() {
        Supplier<String> username = () -> console.nextLine("Enter username: ");
        Consumer<String> validator = service::validateUsername;
        Consumer<RuntimeException> handler = e -> {
            System.out.println();
            System.out.println(Colors.likeError(e.getMessage()));

            boolean tryAgain = console.nextDecision("Would you like to try again (enter \"yes\" or \"no\"): ");
            if (!tryAgain) {
                throw new InputCanceledException();
            }
            System.out.println();
        };
        return input.getValid(username, validator, handler);
    }

    private String readValidPassword() {
        Supplier<String> password = () -> console.nextLine("Enter password: ");
        Consumer<String> validator = service::validatePassword;
        Consumer<RuntimeException> handler = e -> {
            System.out.println();
            System.out.println(Colors.likeError(e.getMessage()));

            boolean tryAgain = console.nextDecision("Would you like to try again (enter \"yes\" or \"no\"): ");
            if (!tryAgain) {
                throw new InputCanceledException();
            }
            System.out.println();
        };
        return input.getValid(password, validator, handler);
    }
}
