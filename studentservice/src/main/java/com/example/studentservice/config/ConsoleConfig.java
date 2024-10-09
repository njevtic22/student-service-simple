package com.example.studentservice.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.PrintStream;
import java.util.Scanner;

@Configuration
public class ConsoleConfig {
    @Bean
    @Qualifier("scanner.system.in")
    public Scanner getScannerSystemIn() {
        return new Scanner(System.in);
    }

    @Bean
    @Qualifier("system.out")
    public PrintStream getSystemOut() {
        return System.out;
    }
}
