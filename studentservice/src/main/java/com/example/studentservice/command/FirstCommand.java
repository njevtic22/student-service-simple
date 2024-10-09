package com.example.studentservice.command;

import com.example.studentservice.service.StudentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class FirstCommand implements Command {
    private final StudentService service;

    public FirstCommand(StudentService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        PageRequest request = PageRequest.of(0, Integer.MAX_VALUE);
        System.out.println(service.getAll(request).getContent());
    }

    @Override
    public String getDescription() {
        return "Description of first command";
    }
}
