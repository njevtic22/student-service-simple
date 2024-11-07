package com.example.studentservice.command.referent;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.model.Address;
import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentService;
import com.example.studentservice.util.DateTimeUtil;
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
@CommandGroup("referent-menu")
public class ShowStudentsCommand implements Command {
    private final StudentService service;
    private final PagingUtil pagingUtil;
    private final TablePrinter table;
    private final DateTimeUtil dateTime;

    public ShowStudentsCommand(StudentService service, PagingUtil pagingUtil, TablePrinter table, DateTimeUtil dateTime) {
        this.service = service;
        this.pagingUtil = pagingUtil;
        this.table = table;
        this.dateTime = dateTime;
    }

    @Override
    public void execute() {
        // How does repository behaves when sorting on same field with multiple directions?
        // It looks like it is sorting based on first input for that field and ignoring rest
        // getRequest secures same field does not appear multiple times

        List<Pair<String, String>> sortOptions = List.of(
                new Pair<>("Unsorted", "id,asc"),
                new Pair<>("Name ascending", "name,asc"),
                new Pair<>("Name descending", "name,desc"),
                new Pair<>("Surname ascending", "surname,asc"),
                new Pair<>("Surname descending", "surname,desc"),
                new Pair<>("Index ascending", "index,asc"),
                new Pair<>("Index descending", "index,desc"),
                new Pair<>("Year of studies ascending", "yearOfStudies,asc"),
                new Pair<>("Year of studies descending", "yearOfStudies,desc")
        );

        Pageable pageable = pagingUtil.getRequest(sortOptions);
        List<Student> students = service.getAll(pageable).getContent();

        table.addLine();
        table.addRow("Row", "Name", "Surname", "Index", "Birth date", "Address", "Phone", "Email", "Year of studies");
        table.addLine();

        int index = 0;
        for (Student student : students) {
            Address address = student.getAddress();
            table.addRow(
                    String.valueOf(++index),
                    student.getName(),
                    student.getSurname(),
                    student.getIndex(),
                    dateTime.format(student.getBirthDate(), DateTimeUtil.RS_DATE),
                    address.getCity() + ", " + address.getStreet() + " " + address.getNumber(),
                    student.getPhone(),
                    student.getEmail(),
                    student.getYearOfStudies().toString()
            );
            table.addLine();
        }

        PrintWriter out = new PrintWriter(System.out);
        table.print(out);
        // not out.close() so it could be still printed to console
        table.clear();
    }

    @Override
    public String getDescription() {
        return "Show students";
    }
}
