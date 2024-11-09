package com.example.studentservice.command.referent;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.core.error.InputCanceledException;
import com.example.studentservice.model.Address;
import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentService;
import com.example.studentservice.util.ConsoleReader;
import com.example.studentservice.util.DateTimeUtil;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Order(3)
@CommandGroup("referent-menu")
public class EnrollStudentCommand implements Command {
    private final StudentService service;
    private final ConsoleReader console;

    public EnrollStudentCommand(StudentService service, ConsoleReader console) {
        this.service = service;
        this.console = console;
    }

    @Override
    public void execute() {
        try {
            Student newStudent = readStudent();
            service.add(newStudent);
            System.out.println("Student added");
        } catch (InputCanceledException ignored) {
        }
    }

    @Override
    public String getDescription() {
        return "Enroll new student";
    }

    private Student readStudent() {
        System.out.println("Enrolling new student");

        String index = console.nextLine("Enter students index: ", service::validateIndex);
        String email = console.nextLine("Enter students email: ", service::validateEmail);
        String phone = console.nextLine("Enter students phone number: ", service::validatePhone);

        String name = console.nextLine("Enter students name: ");
        String surname = console.nextLine("Enter students surname: ");
        LocalDate birthDate = console.nextDate("Enter students birthdate (format " + DateTimeUtil.RS_DATE + "): ", DateTimeUtil.RS_DATE);

        String city = console.nextLine("Enter students city: ");
        String street = console.nextLine("Enter students street: ");
        int number = console.nextInt("Enter students street number: ");

        return new Student(
                name,
                surname,
                index,
                birthDate,
                new Address(
                        city,
                        street,
                        number
                ),
                phone,
                email,
                null
        );
    }
}
