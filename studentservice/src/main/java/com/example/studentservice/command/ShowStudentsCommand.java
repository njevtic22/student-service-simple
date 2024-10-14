package com.example.studentservice.command;

import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentService;
import com.example.studentservice.util.TablePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.util.List;

@Component
public class ShowStudentsCommand implements Command {
    private StudentService service;
    private TablePrinter table;

    public ShowStudentsCommand() { }

    @Override
    public void execute() {
        PageRequest request = PageRequest.of(0, Integer.MAX_VALUE);
        List<Student> students = service.getAll(request).getContent();

        table.addLine();
        for (Student student : students) {
            table.addRow(student.getId().toString(), student.getName(), student.getSurname());
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
        return "Show students";
    }

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }

    @Autowired
    public void setTable(TablePrinter table) {
        this.table = table;
    }
}
