package com.example.studentservice.util;

@FunctionalInterface
public interface ExceptionHandler<T> {
    void handle(T e);
}
