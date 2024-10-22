package com.example.studentservice.command;

import com.example.studentservice.model.Referent;
import com.example.studentservice.service.ReferentService;
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
@CommandGroup("anonymous")
public class ShowReferentsCommand implements Command {
    private final ReferentService service;
    private final PagingUtil pagingUtil;
    private final TablePrinter table;

    public ShowReferentsCommand(ReferentService service, PagingUtil pagingUtil, TablePrinter table) {
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
        List<Referent> referents = service.getAll(pageable).getContent();

        table.addLine();
        table.addRow("Name", "Surname", "Username");
        table.addLine();

        for (Referent referent : referents) {
            table.addRow(referent.getName(), referent.getSurname(), referent.getUsername());
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
        return "Show referents";
    }
}
