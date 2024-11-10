package com.example.studentservice.model;

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
}
