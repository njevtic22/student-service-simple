package com.example.studentservice.faker;

public class FakerUtil {
    public static String escapeApostrophe(String str) {
        return str.replaceAll("'", "''");
    }
}
