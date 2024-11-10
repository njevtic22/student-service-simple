package com.example.studentservice.command.referent;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import com.example.studentservice.core.error.EntityNotFoundException;
import com.example.studentservice.core.error.InputCanceledException;
import com.example.studentservice.service.StudentService;
import com.example.studentservice.util.Colors;
import com.example.studentservice.util.ConsoleReader;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Order(4)
@CommandGroup("referent-menu")
public class AdvanceStudentsCommand implements Command {
    private final StudentService service;
    private final ConsoleReader console;

    public AdvanceStudentsCommand(StudentService service, ConsoleReader console) {
        this.service = service;
        this.console = console;
    }

    @Override
    public void execute() {
        boolean tryAgain = true;
        while (tryAgain) {
            try {
                String index = readIndex();
                service.advanceStudent(index);
                System.out.println("Student advanced\n");

                tryAgain = console.nextDecision("Would you like advance another student (enter \"yes\" or \"no\"): ");

            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println(Colors.likeError(e.getMessage()));

                tryAgain = console.nextDecision("Would you like to try again (enter \"yes\" or \"no\"): ");
                System.out.println();

            } catch (InputCanceledException ignored) {
            }
        }
    }

    @Override
    public String getDescription() {
        return "Advance students";
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
