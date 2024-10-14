package com.example.studentservice.config;

import com.example.studentservice.command.Command;
import com.example.studentservice.command.SecondCommand;
import com.example.studentservice.command.ShowStudentsCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CommandConfig {
    @Bean
    public List<Command> getCommands() {
        return List.of(new ShowStudentsCommand(), new SecondCommand());
    }
}
