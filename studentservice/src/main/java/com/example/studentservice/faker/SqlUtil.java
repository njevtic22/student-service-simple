package com.example.studentservice.faker;

import com.example.studentservice.model.Student;
import com.example.studentservice.model.User;

public class SqlUtil {
    public static String toSqlInsert(Student student) {
        return "insert into students (id, name, surname, index, birth_date, city, street, number, phone, email, year_of_studies) values (" +
                student.getId() + ", '" +
                student.getName() + "', '" +
                student.getSurname() + "', '" +
                student.getIndex() +  "', '" +
                student.getBirthDate() + "', '" +
                student.getAddress().getCity() + "', '" +
                student.getAddress().getStreet() + "', " +
                student.getAddress().getNumber() + ", '" +
                student.getPhone() + "', '" +
                student.getEmail() + "', " +
                student.getYearOfStudies().ordinal() + ");";
    }

    public static String toSqlInsert(User user) {
        return "insert into users (id, name, surname, username, password, role) values (" +
                user.getId() + ", '" +
                user.getName() + "', '" +
                user.getSurname() + "', '" +
                user.getUsername() + "', '" +
                user.getPassword() + "', '" +
                user.getRole().toString() + "');";
    }

    public static String toSqlAlterSequenceRestart(String sequenceName, long restartWith) {
        return "alter sequence " + sequenceName + " restart with " + restartWith + ";";
    }
}
