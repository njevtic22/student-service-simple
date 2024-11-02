package com.example.studentservice.command.referent;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.core.error.EntityNotFoundException;
import com.example.studentservice.core.error.InputCanceledException;
import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentService;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
//            Student changes = readChanges();
//            service.update(existingIndex, changes);
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
        return console.nextValidLine("Enter students index: ", validator);
    }

    private Student readChanges() {
        return null;
    }
}
