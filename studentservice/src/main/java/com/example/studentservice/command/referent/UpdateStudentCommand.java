package com.example.studentservice.command.referent;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.core.error.EntityNotFoundException;
import com.example.studentservice.core.error.InputCanceledException;
import com.example.studentservice.model.Address;
import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentService;
import com.example.studentservice.util.ConsoleReader;
import com.example.studentservice.util.DateTimeUtil;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.function.Consumer;


@Component
@Order(2)
@CommandGroup("referent-menu")
public class UpdateStudentCommand implements Command {
    private final StudentService service;
    private final ConsoleReader console;

    public UpdateStudentCommand(StudentService service, ConsoleReader console) {
        this.service = service;
        this.console = console;
    }

    @Override
    public void execute() {
        try {
            String existingIndex = readIndex();
            Student changes = readChanges(existingIndex);
            service.update(existingIndex, changes);
            System.out.println("Student updated");

        } catch (InputCanceledException ignored) {
        }
    }

    @Override
    public String getDescription() {
        return "Update student";
    }

    private String readIndex() {
        Consumer<String> validator = inputIndex -> {
            if (!service.existsByIndex(inputIndex)) {
                throw new EntityNotFoundException("Student", "index", inputIndex);
            }
        };
        return console.nextLine("Enter students index: ", validator);
    }

    private Student readChanges(String existingIndex) {
        Student existing = service.getByIndex(existingIndex);

        System.out.println("Changing students data");

        Consumer<String> indexValidator = newIndex -> {
            if (!existing.getIndex().equals(newIndex)) {
                service.validateIndex(newIndex);
            }
        };
        String index = console.nextLine("Enter students new index: ", indexValidator);

        Consumer<String> emailValidator = newEmail -> {
            if (!existing.getEmail().equals(newEmail)) {
                service.validateEmail(newEmail);
            }
        };
        String email = console.nextLine("Enter students new email: ", emailValidator);

        String phone = console.nextLine("Enter students new phone number: ", service::validatePhone);

        String name = console.nextLine("Enter students new name: ");
        String surname = console.nextLine("Enter students new surname: ");
        LocalDate birthDate = console.nextDate("Enter students new birthdate (format " + DateTimeUtil.RS_DATE + "): ", DateTimeUtil.RS_DATE);

        String city = console.nextLine("Enter students new city: ");
        String street = console.nextLine("Enter students new street: ");
        int number = console.nextInt("Enter students new street number: ");

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
