package com.example.studentservice.faker;

import com.example.studentservice.model.Referent;
import com.example.studentservice.model.Student;

public class SqlUtil {
    public static String toSqlInsert(Student student) {
        return "insert into students (id, name, surname, parents_name, index, birth_date, city, street, number, phone, email, year_of_studies) values (" +
                student.getId() + ", '" +
                student.getName() + "', '" +
                student.getSurname() + "', '" +
                student.getParentsName() + "', '" +
                student.getIndex() +  "', '" +
                student.getBirthDate() + "', '" +
                student.getAddress().getCity() + "', '" +
                student.getAddress().getStreet() + "', " +
                student.getAddress().getNumber() + ", '" +
                student.getPhone() + "', '" +
                student.getEmail() + "', " +
                student.getYearOfStudies().ordinal() + ");";
    }

    public static String toSqlInsert(Referent referent) {
        return "insert into referents (id, name, surname, username, password) values (" +
                referent.getId() + ", '" +
                referent.getName() + "', '" +
                referent.getSurname() + "', '" +
                referent.getUsername() + "', '" +
                referent.getPassword() + "');";
    }

    public static String toSqlAlterSequenceRestart(String sequenceName, long restartWith) {
        return "alter sequence " + sequenceName + " restart with " + restartWith + ";";
    }
}
