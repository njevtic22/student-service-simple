package com.example.studentservice.command.admin;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.core.error.InputCanceledException;
import com.example.studentservice.model.Role;
import com.example.studentservice.service.UserService;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Order(3)
@CommandGroup("admin-menu")
public class DeleteReferentCommand implements Command {
    private final UserService service;
    private final ConsoleReader console;

    public DeleteReferentCommand(UserService service, ConsoleReader console) {
        this.service = service;
        this.console = console;
    }

    @Override
    public void execute() {
        try {
            String deleteUsername = readUsername();
            service.delete(deleteUsername);
            System.out.println("Referent deleted");
        } catch (InputCanceledException ignored) {
        }
    }

    @Override
    public String getDescription() {
        return "Delete referent";
    }

    private String readUsername() {
        Consumer<String> validator = inputUsername -> {
            if (!service.existsByUsernameAndRole(inputUsername, Role.REFERENT)) {
                throw new IllegalArgumentException("User with username \"" + inputUsername + "\" is not referent");
            }
        };
        return console.nextValidLine("Enter referents username: ", validator);
    }
}
