package com.example.studentservice.util;

import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
public class InputValidator {
    public String getValid(Supplier<String> input, Consumer<String> validator, Consumer<RuntimeException> errorHandler) {
        String finalInput = null;

        while (finalInput == null) {
            String tmp = input.get();
            try {
                validator.accept(tmp);
            } catch (RuntimeException e) {
                errorHandler.accept(e);
                continue;
            }

            finalInput = tmp;
        }
        return finalInput;
    }
}
