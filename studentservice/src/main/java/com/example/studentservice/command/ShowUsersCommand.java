package com.example.studentservice.command;

import com.example.studentservice.model.User;
import com.example.studentservice.service.UserService;
import com.example.studentservice.util.PagingUtil;
import com.example.studentservice.util.Pair;
import com.example.studentservice.util.TablePrinter;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.util.List;

@Component
@Order(2)
@CommandGroup("user-menu")
public class ShowUsersCommand implements Command {
    private final UserService service;
    private final PagingUtil pagingUtil;
    private final TablePrinter table;

    public ShowUsersCommand(UserService service, PagingUtil pagingUtil, TablePrinter table) {
        this.service = service;
        this.pagingUtil = pagingUtil;
        this.table = table;
    }


    @Override
    public void execute() {
        List<Pair<String, String>> sortOptions = List.of(
                new Pair<>("Name ascending", "name,asc"),
                new Pair<>("Name descending", "name,desc"),
                new Pair<>("Surname ascending", "surname,asc"),
                new Pair<>("Surname descending", "surname,desc"),
                new Pair<>("Username ascending", "username,asc"),
                new Pair<>("Username descending", "username,desc")
        );

        Pageable pageable = pagingUtil.getRequest(sortOptions);
        List<User> users = service.getAll(pageable).getContent();

        table.addLine();
        table.addRow("Name", "Surname", "Username");
        table.addLine();

        for (User user : users) {
            table.addRow(user.getName(), user.getSurname(), user.getUsername());
            table.addLine();
        }

        PrintWriter out = new PrintWriter(System.out);
        table.print(out);
        // not close() so it could be still printed to console
        out.flush();
        table.clear();
    }

    @Override
    public String getDescription() {
        return "Show users";
    }
}
