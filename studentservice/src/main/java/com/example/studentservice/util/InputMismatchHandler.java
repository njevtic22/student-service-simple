package com.example.studentservice.util;

import java.util.InputMismatchException;

@FunctionalInterface
public interface InputMismatchHandler {
    void handle(InputMismatchException e);
}
