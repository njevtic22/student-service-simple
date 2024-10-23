package com.example.studentservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    @SequenceGenerator(name = "student_generator", sequenceName = "student_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String parentsName;

    @Column(nullable = false, unique = true)
    private String index;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Embedded
    private Address address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private YearOfStudies yearOfStudies;

    public Student() {}

    public Student(String name, String surname, String parentsName, String index, LocalDate birthDate, Address address, String phone, String email, YearOfStudies yearOfStudies) {
        this(null, name, surname, parentsName, index, birthDate, address, phone, email, yearOfStudies);
    }

    public Student(Long id, String name, String surname, String parentsName, String index, LocalDate birthDate, Address address, String phone, String email, YearOfStudies yearOfStudies) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.parentsName = parentsName;
        this.index = index;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.yearOfStudies = yearOfStudies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getParentsName() {
        return parentsName;
    }

    public String getIndex() {
        return index;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public YearOfStudies getYearOfStudies() {
        return yearOfStudies;
    }
}
