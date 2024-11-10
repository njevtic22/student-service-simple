package com.example.studentservice.core.error;

import java.util.List;

public class InvalidPasswordException extends RuntimeException {
    private final List<String> messages;

    public InvalidPasswordException(List<String> messages) {
        super("Invalid password");
        this.messages = messages;
    }

    public InvalidPasswordException(String message) {
        super("Invalid password");
        this.messages = List.of(message);
    }

    @Override
    public String getMessage() {
        return String.join("\n", messages);
    }
}
