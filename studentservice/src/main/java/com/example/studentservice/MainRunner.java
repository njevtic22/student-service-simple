package com.example.studentservice;

import com.example.studentservice.command.Command;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainRunner implements ApplicationRunner {
    private final List<Command> commands;

    public MainRunner(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Arguments passed when bootstraping the app: " + args.getOptionValues("customArgument"));

        for (Command command : commands) {
            System.out.println(command.getDescription());
            command.execute();
            System.out.println();
        }
    }
}
