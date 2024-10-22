package com.example.studentservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "referents")
public class Referent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referent_generator")
    @SequenceGenerator(name = "referent_generator", sequenceName = "referent_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public Referent() { }

    public Referent(String name, String surname, String username, String password) {
        this(null, name, surname, username, password);
    }

    public Referent(Long id, String name, String surname, String username, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Referent referent)) return false;
        return Objects.equals(id, referent.id) && Objects.equals(username, referent.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
