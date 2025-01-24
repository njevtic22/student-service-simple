package com.example.studentservice.model;

import java.util.HashSet;
import java.util.Set;

public enum YearOfStudies {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FINISHED;

    public YearOfStudies getNextYear() {
        return switch (this) {
            case FIRST -> SECOND;
            case SECOND -> THIRD;
            case THIRD -> FOURTH;
            case FOURTH -> FINISHED;
            case FINISHED -> throw new IllegalArgumentException("There is no next year after finished studies");
        };
    }

    public static Set<YearOfStudies> contains(String keyword) {
        HashSet<YearOfStudies> years = new HashSet<>();

        for (YearOfStudies value : YearOfStudies.values()) {
            if (value.toString().contains(keyword.toUpperCase())) {
                years.add(value);
            }
        }

        return years;
    }
}
