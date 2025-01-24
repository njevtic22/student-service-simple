package com.example.studentservice.model;

import java.util.HashSet;
import java.util.Set;

public enum Role {
    ADMIN,
    REFERENT;

    public static Set<Role> contains(String keyword) {
        HashSet<Role> roles = new HashSet<>();

        for (Role value : Role.values()) {
            if (value.toString().contains(keyword.toUpperCase())) {
                roles.add(value);
            }
        }

        return roles;
    }
}
