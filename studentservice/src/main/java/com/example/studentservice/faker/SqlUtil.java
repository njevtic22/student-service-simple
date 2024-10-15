package com.example.studentservice.faker;

import com.example.studentservice.model.Student;

public class SqlUtil {
    public static String toSqlInsert(Student student) {
        return "insert into students (id, name, surname) values (" +
                student.getId() + ", '" +
                student.getName() + "', '" +
                student.getSurname() + "');";
    }

    public static String toSqlAlterSequenceRestart(String sequenceName, long restartWith) {
        return "alter sequence " + sequenceName + " restart with " + restartWith + ";";
    }
}
