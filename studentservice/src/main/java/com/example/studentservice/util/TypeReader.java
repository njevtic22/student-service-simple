package com.example.studentservice.util;

@FunctionalInterface
public interface TypeReader<T> {
    T nextType();
}
