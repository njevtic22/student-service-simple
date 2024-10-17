package com.example.studentservice.faker;

import com.example.studentservice.model.Address;
import com.example.studentservice.model.Student;
import com.example.studentservice.model.YearOfStudies;
import com.example.studentservice.util.CycleIterator;
import com.example.studentservice.util.LongGenerator;
import com.github.javafaker.Faker;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.example.studentservice.faker.FakerUtil.generateIndex;
import static com.example.studentservice.faker.FakerUtil.generatePastLocalDate;
import static com.example.studentservice.faker.FakerUtil.generatePhoneNumber;
import static com.example.studentservice.faker.FakerUtil.getAddressIterator;
import static com.example.studentservice.faker.SqlUtil.toSqlAlterSequenceRestart;

public class FakeDatabaseGenerator {
    private final Faker faker = new Faker();

    private final String LINE = "-";
    private final String LINES = LINE.repeat(200);

    private final int STUDENTS = 50;

    private final PrintWriter out = new PrintWriter(new FileWriter("./src/main/resources/data-generated.sql"));

    private final CycleIterator<Address> addresses = getAddressIterator();

    public FakeDatabaseGenerator() throws IOException {
    }

    private void generateHeader(PrintWriter out) {

        out.println("-- Script generates database for student-service");
        out.println("-- It generates:");
        out.println("--\t- "   + STUDENTS + " students");
        out.println("--");

        out.flush();
    }

    public void generate() {
        generateHeader(out);

        // generating students
        LongGenerator studentId = new LongGenerator();
        Map<Long, Student> students = generateStudents(studentId);

        //////////

        // inserting students
        printToSqlInsert(students.values(), "Inserting students", out, SqlUtil::toSqlInsert);
        // altering student_id_seq
        printSequenceRestart(STUDENTS, studentId, "student_id_seq", out);

        out.close();
    }

    private Map<Long, Student> generateStudents(LongGenerator studentId) {
        HashMap<Long, Student> students = new HashMap<>(STUDENTS);
        LocalDate referenceDate = LocalDate.of(2000, 12, 28);
        for (int i = 0; i < STUDENTS; i++) {
            Student student = new Student(
                    studentId.next(),
                    faker.name().firstName(),
                    FakerUtil.escapeApostrophe(faker.name().lastName()),
                    faker.name().firstName(),
                    generateIndex(faker, studentId.current()),
                    generatePastLocalDate(faker, referenceDate),
                    addresses.next(),
                    generatePhoneNumber(faker),
                    "student" + studentId.current() + "@gmail.com",
                    faker.options().option(YearOfStudies.class)
            );
            students.put(studentId.current(), student);
        }

        return students;
    }

    private <T> void printToSqlInsert(Collection<T> values, String linesDescription, PrintWriter out, Function<T, String> fun) {
        printStartLines(linesDescription, out);

        for (T value : values) {
            out.println(fun.apply(value));
        }

        printEndLines(out);
    }

    private void printSequenceRestart(final long OBJECT_NUM, LongGenerator objectId, String sequenceName, PrintWriter out) {
        if (OBJECT_NUM != objectId.current()) {
            throw new AssertionError("OBJECT_NUM != objectId.current() for: " + sequenceName);
        }

        printStartLines("Altering " + sequenceName, out);
        out.println(toSqlAlterSequenceRestart(sequenceName, OBJECT_NUM + 1));
        printEndLines(out);
    }

    private void printStartLines(String description, PrintWriter out) {
        int descLength = description.length() + 2;
        int remainingLength = LINES.length() - descLength;

        int firstHalf = remainingLength / 2;
        int secondHalf = remainingLength - firstHalf;   // if length is odd

        String line = LINE.repeat(firstHalf) + " " + description + " " + LINE.repeat(secondHalf);

        out.println(LINES);
        out.println(line);
    }

    private void printEndLines(PrintWriter out) {
        out.println(LINES);
        out.println(LINES);
        out.println();
    }

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        new FakeDatabaseGenerator().generate();
    }
}
