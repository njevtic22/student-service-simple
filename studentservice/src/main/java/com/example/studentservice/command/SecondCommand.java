package com.example.studentservice.command;

import com.example.studentservice.service.StudentService;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@CommandGroup("anonymous")
public class SecondCommand implements Command {
    private final StudentService service;

    public SecondCommand(StudentService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        PageRequest request = PageRequest.of(0, 5);
        System.out.println(service.getAll(request).getContent());
    }

    @Override
    public String getDescription() {
        return "Description of second command";
    }
}
