package com.example.studentservice.core.error;

public class InputCanceledException extends RuntimeException {
    public InputCanceledException() {
        super("Input is canceled");
    }
}
