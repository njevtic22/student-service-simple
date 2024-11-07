package com.example.studentservice.util.old;

// You already have Consumer<T>
@FunctionalInterface
public interface ExceptionHandler<T> {
    void handle(T e);
}
