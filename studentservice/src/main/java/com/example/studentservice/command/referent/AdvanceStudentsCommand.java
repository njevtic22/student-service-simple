package com.example.studentservice.command.referent;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.CommandGroup;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
@CommandGroup("referent-menu")
public class AdvanceStudentsCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Executing advancing");
    }

    @Override
    public String getDescription() {
        return "Advance students";
    }
}
