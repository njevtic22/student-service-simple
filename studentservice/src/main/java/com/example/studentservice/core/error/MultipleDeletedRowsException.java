package com.example.studentservice.core.error;

public class MultipleDeletedRowsException extends RuntimeException {
    public MultipleDeletedRowsException(String tableName, String byWhat) {
        super("Zero or more than one rows in " + tableName + " table is affected by delete (by " + byWhat + ") operation.");
    }
}

