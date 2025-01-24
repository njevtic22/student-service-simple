package com.example.studentservice.command;

import com.example.studentservice.core.error.EntityNotFoundException;
import com.example.studentservice.core.error.InputCanceledException;
import com.example.studentservice.model.Address;
import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentService;
import com.example.studentservice.util.Colors;
import com.example.studentservice.util.ConsoleReader;
import com.example.studentservice.util.DateTimeUtil;
import com.example.studentservice.util.PagingUtil;
import com.example.studentservice.util.Pair;
import com.example.studentservice.util.TablePrinter;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

// Alternative to Command classes
@Component
public class StudentCommands {
    private final StudentService service;
    private final ConsoleReader console;
    private final PagingUtil pagingUtil;
    private final TablePrinter table;
    private final DateTimeUtil dateTime;

    public StudentCommands(StudentService service, ConsoleReader console, PagingUtil pagingUtil, TablePrinter table, DateTimeUtil dateTime) {
        this.service = service;
        this.console = console;
        this.pagingUtil = pagingUtil;
        this.table = table;
        this.dateTime = dateTime;
    }

    public void showStudents() {
        // How does repository behaves when sorting on same field with multiple directions?
        // It looks like it is sorting based on first input for that field and ignoring rest
        // getRequest secures same field does not appear multiple times

        List<Pair<String, String>> sortOptions = List.of(
                new Pair<>("Unsorted", "id,asc"),
                new Pair<>("Name ascending", "name,asc"),
                new Pair<>("Name descending", "name,desc"),
                new Pair<>("Surname ascending", "surname,asc"),
                new Pair<>("Surname descending", "surname,desc"),
                new Pair<>("Index ascending", "index,asc"),
                new Pair<>("Index descending", "index,desc"),
                new Pair<>("Year of studies ascending", "yearOfStudies,asc"),
                new Pair<>("Year of studies descending", "yearOfStudies,desc")
        );

        Pageable pageable = pagingUtil.getRequest(sortOptions);
        String keyword = console.nextLine("\nEnter filter keyword: ", line -> {}, true);
        List<Student> students = service.getAll(keyword, pageable).getContent();

        table.addLine();
        table.addRow("Row", "Name", "Surname", "Index", "Birth date", "Address", "Phone", "Email", "Year of studies");
        table.addLine();

        int index = 0;
        for (Student student : students) {
            Address address = student.getAddress();
            table.addRow(
                    String.valueOf(++index),
                    student.getName(),
                    student.getSurname(),
                    student.getIndex(),
                    dateTime.format(student.getBirthDate(), DateTimeUtil.RS_DATE),
                    address.getCity() + ", " + address.getStreet() + " " + address.getNumber(),
                    student.getPhone(),
                    student.getEmail(),
                    student.getYearOfStudies().toString()
            );
            table.addLine();
        }

        PrintWriter out = new PrintWriter(System.out);
        table.print(out);
        // not out.close() so it could be still printed to console
        table.clear();
    }

    public void updateStudent() {
        try {
            String existingIndex = readIndex();
            Student changes = readChanges(existingIndex);
            service.update(existingIndex, changes);
            System.out.println("Student updated");

        } catch (InputCanceledException ignored) {
        }
    }

    private String readIndex() {
        Consumer<String> validator = inputIndex -> {
            if (!service.existsByIndex(inputIndex)) {
                throw new EntityNotFoundException("Student", "index", inputIndex);
            }
        };
        return console.nextLine("Enter students index: ", validator);
    }

    private Student readChanges(String existingIndex) {
        Student existing = service.getByIndex(existingIndex);

        System.out.println("Changing students data");

        Consumer<String> indexValidator = newIndex -> {
            if (!existing.getIndex().equals(newIndex)) {
                service.validateIndex(newIndex);
            }
        };
        String index = console.nextLine("Enter students new index: ", indexValidator);

        Consumer<String> emailValidator = newEmail -> {
            if (!existing.getEmail().equals(newEmail)) {
                service.validateEmail(newEmail);
            }
        };
        String email = console.nextLine("Enter students new email: ", emailValidator);

        String phone = console.nextLine("Enter students new phone number: ", service::validatePhone);

        String name = console.nextLine("Enter students new name: ");
        String surname = console.nextLine("Enter students new surname: ");
        LocalDate birthDate = console.nextDate("Enter students new birthdate (format " + DateTimeUtil.RS_DATE + "): ", DateTimeUtil.RS_DATE);

        String city = console.nextLine("Enter students new city: ");
        String street = console.nextLine("Enter students new street: ");
        int number = console.nextInt("Enter students new street number: ");

        return new Student(
                name,
                surname,
                index,
                birthDate,
                new Address(
                        city,
                        street,
                        number
                ),
                phone,
                email,
                null
        );
    }

    public void enrollStudent() {
        try {
            Student newStudent = readStudent();
            service.add(newStudent);
            System.out.println("Student added");
        } catch (InputCanceledException ignored) {
        }
    }

    private Student readStudent() {
        System.out.println("Enrolling new student");

        String index = console.nextLine("Enter students index: ", service::validateIndex);
        String email = console.nextLine("Enter students email: ", service::validateEmail);
        String phone = console.nextLine("Enter students phone number: ", service::validatePhone);

        String name = console.nextLine("Enter students name: ");
        String surname = console.nextLine("Enter students surname: ");
        LocalDate birthDate = console.nextDate("Enter students birthdate (format " + DateTimeUtil.RS_DATE + "): ", DateTimeUtil.RS_DATE);

        String city = console.nextLine("Enter students city: ");
        String street = console.nextLine("Enter students street: ");
        int number = console.nextInt("Enter students street number: ");

        return new Student(
                name,
                surname,
                index,
                birthDate,
                new Address(
                        city,
                        street,
                        number
                ),
                phone,
                email,
                null
        );
    }

    public void advanceStudents() {
        boolean tryAgain = true;
        while (tryAgain) {
            try {
                String index = readIndex();
                service.advanceStudent(index);
                System.out.println("Student advanced\n");

                tryAgain = console.nextDecision("Would you like advance another student (enter \"yes\" or \"no\"): ");

            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println(Colors.likeError(e.getMessage()));

                tryAgain = console.nextDecision("Would you like to try again (enter \"yes\" or \"no\"): ");
                System.out.println();

            } catch (InputCanceledException ignored) {
            }
        }
    }

    public void deleteStudent() {
        try {
            String existingIndex = readIndex();
            service.delete(existingIndex);
            System.out.println("Student deleted");
        } catch (InputCanceledException ignored) {
        }
    }

    public List<Command> get() {
        List<Command> commands = new ArrayList<>(5);
        commands.add(
                new Command() {
                    @Override
                    public void execute() {
                        showStudents();
                    }

                    @Override
                    public String getDescription() {
                        return "Show students";
                    }
                });
        commands.add(
                new Command() {
                    @Override
                    public void execute() {
                        updateStudent();
                    }

                    @Override
                    public String getDescription() {
                        return "Update student";
                    }
                });
        commands.add(
                new Command() {
                    @Override
                    public void execute() {
                        enrollStudent();
                    }

                    @Override
                    public String getDescription() {
                        return "Enroll new student";
                    }
                });
        commands.add(
                new Command() {
                    @Override
                    public void execute() {
                        advanceStudents();
                    }

                    @Override
                    public String getDescription() {
                        return "Advance students";
                    }
                });
        commands.add(
                new Command() {
                    @Override
                    public void execute() {
                        deleteStudent();
                    }

                    @Override
                    public String getDescription() {
                        return "Delete student";
                    }
                });

        return commands;
    }
}
