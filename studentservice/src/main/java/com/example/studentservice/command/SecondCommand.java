package com.example.studentservice.command;

import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondCommand implements Command {
    private StudentService service;

    @Override
    public void execute() {
        System.out.println("Executing second command");
        System.out.println(service.getAll());
    }

    @Override
    public String getDescription() {
        return "Description of second command";
    }

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }
}
