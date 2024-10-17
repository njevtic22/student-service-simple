package com.example.studentservice.command;

import com.example.studentservice.model.Address;
import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentService;
import com.example.studentservice.util.TablePrinter;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.util.List;

@Component
@Order(1)
@CommandGroup("anonymous")
public class ShowStudentsCommand implements Command {
    private final StudentService service;
    private final TablePrinter table;

    public ShowStudentsCommand(StudentService service, TablePrinter table) {
        this.service = service;
        this.table = table;
    }

    @Override
    public void execute() {
        PageRequest request = PageRequest.of(0, Integer.MAX_VALUE);
        List<Student> students = service.getAll(request).getContent();

        table.addLine();
        table.addRow("Name", "Surname", "Parents name", "Index", "Birth date", "Address", "Phone", "email", "Year of studies");
        table.addLine();

        for (Student student : students) {
            Address address = student.getAddress();
            table.addRow(
                    student.getName(),
                    student.getSurname(),
                    student.getParentsName(),
                    student.getIndex(),
                    student.getBirthDate().toString(),
                    address.getCity() + ", " + address.getStreet() + " " + address.getNumber(),
                    student.getPhone(),
                    student.getEmail(),
                    student.getYearOfStudies().toString()
            );
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
}
