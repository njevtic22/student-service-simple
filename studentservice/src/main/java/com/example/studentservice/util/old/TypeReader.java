package com.example.studentservice.util.old;

// You already have Supplier<T>
@FunctionalInterface
public interface TypeReader<T> {
    T nextType();
}
