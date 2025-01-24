package com.example.studentservice.command.shared;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.model.User;
import com.example.studentservice.security.AuthenticationService;
import com.example.studentservice.util.TablePrinter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

@Component
@Order(1)
@CommandGroup("user-shared")
public class ViewProfileCommand implements Command {
    private final AuthenticationService authService;
    private final TablePrinter table;

    public ViewProfileCommand(AuthenticationService authService, TablePrinter table) {
        this.authService = authService;
        this.table = table;
    }

    @Override
    public void execute() {
        User authenticated = (User) authService.getAuthenticated();

        table.addLine();
        table.addRow("Name", "Surname", "Username", "Role");
        table.addLine();
        table.addRow(authenticated.getName(), authenticated.getSurname(), authenticated.getUsername(), authenticated.getRole().toString());
        table.addLine();

        PrintWriter out = new PrintWriter(System.out);
        table.print(out);
        table.clear();
    }

    @Override
    public String getDescription() {
        return "View profile";
    }
}
