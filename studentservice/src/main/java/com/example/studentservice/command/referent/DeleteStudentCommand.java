package com.example.studentservice.command.referent;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.core.error.EntityNotFoundException;
import com.example.studentservice.core.error.InputCanceledException;
import com.example.studentservice.service.StudentService;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Order(5)
@CommandGroup("referent-menu")
public class DeleteStudentCommand implements Command {
    private final StudentService service;
    private final ConsoleReader console;

    public DeleteStudentCommand(StudentService service, ConsoleReader console) {
        this.service = service;
        this.console = console;
    }

    @Override
    public void execute() {
        try {
            String existingIndex = readIndex();
            service.delete(existingIndex);
            System.out.println("Student deleted");
        } catch (InputCanceledException ignored) {
        }
    }

    @Override
    public String getDescription() {
        return "Delete student";
    }

    private String readIndex() {
        Consumer<String> validator = inputIndex -> {
            if (!service.existsByIndex(inputIndex)) {
                throw new EntityNotFoundException("Student", "index", inputIndex);
            }
        };
        return console.nextLine("Enter students index: ", validator);
    }
}
