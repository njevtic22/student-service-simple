package com.example.studentservice.command;

import com.example.studentservice.service.StudentService;
import org.springframework.stereotype.Component;

@Component
public class FirstCommand implements Command {
    private final StudentService service;

    public FirstCommand(StudentService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("Executing first command");
        System.out.println(service.getAll());
    }

    @Override
    public String getDescription() {
        return "Description of first command";
    }
}
