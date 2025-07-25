package com.example.studentservice.command.admin;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.model.User;
import com.example.studentservice.service.UserService;
import com.example.studentservice.util.ConsoleReader;
import com.example.studentservice.util.PagingUtil;
import com.example.studentservice.util.Pair;
import com.example.studentservice.util.TablePrinter;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.util.List;

@Component
@Order(1)
@CommandGroup("admin-menu")
public class ShowUsersCommand implements Command {
    private final UserService service;
    private final ConsoleReader console;
    private final PagingUtil pagingUtil;
    private final TablePrinter table;

    public ShowUsersCommand(UserService service, ConsoleReader console, PagingUtil pagingUtil, TablePrinter table) {
        this.service = service;
        this.console = console;
        this.pagingUtil = pagingUtil;
        this.table = table;
    }


    @Override
    public void execute() {
        List<Pair<String, String>> sortOptions = List.of(
                new Pair<>("Unsorted", "id,asc"),
                new Pair<>("Name ascending", "name,asc"),
                new Pair<>("Name descending", "name,desc"),
                new Pair<>("Surname ascending", "surname,asc"),
                new Pair<>("Surname descending", "surname,desc"),
                new Pair<>("Username ascending", "username,asc"),
                new Pair<>("Username descending", "username,desc")
        );

        Pageable pageable = pagingUtil.getRequest(sortOptions);
        String keyword = console.nextLine("\nEnter filter keyword: ", line -> {}, true);
        List<User> users = service.getAll(keyword, pageable).getContent();

        table.addLine();
        table.addRow("Row", "Name", "Surname", "Username", "Role");
        table.addLine();

        int index = 0;
        for (User user : users) {
            table.addRow(String.valueOf(++index), user.getName(), user.getSurname(), user.getUsername(), user.getRole().toString());
            table.addLine();
        }

        PrintWriter out = new PrintWriter(System.out);
        table.print(out);
        // not out.close() so it could be still printed to console
        table.clear();
    }

    @Override
    public String getDescription() {
        return "Show users";
    }
}
