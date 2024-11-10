package com.example.studentservice.repository;

import com.example.studentservice.model.Role;
import com.example.studentservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("update User u set u.password = :newPassword where u.username = :username")
    int updatePasswordByUsername(String username, String newPassword);

    boolean existsByUsername(String username);

    boolean existsByUsernameAndRole(String username, Role role);

    int deleteByUsername(String username);
}
