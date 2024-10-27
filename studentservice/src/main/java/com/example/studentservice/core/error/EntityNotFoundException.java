package com.example.studentservice.core.error;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityName, Long entityId) {
        super(entityName + " with id: '" + entityId + "' not found.");
    }

    public EntityNotFoundException(String entityName, String propertyName, String propertyValue) {
        super(entityName + " with " + propertyName + "='" + propertyValue + "' not found.");
    }
}
