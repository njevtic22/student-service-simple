package com.example.studentservice.core.error;

import java.util.List;

public class InvalidPasswordException extends RuntimeException {
    private final List<String> messages;

    public InvalidPasswordException(List<String> messages) {
        super("Invalid password");
        this.messages = messages;
    }

    @Override
    public String getMessage() {
        return String.join("\n", messages);
    }
}
