package com.example.studentservice.core.error;

public class UniquePropertyException extends RuntimeException {
    public UniquePropertyException(String message) {
        super(message);
    }

    public UniquePropertyException(String entityName, String propertyName, String propertyValue) {
        super(entityName + " with " + propertyName + "='" + propertyValue + "' already exist.");
    }
}

