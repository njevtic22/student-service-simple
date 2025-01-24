package com.example.studentservice.repository.specification;

import com.example.studentservice.model.Role;
import com.example.studentservice.model.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class UserSpecification {
    public static Specification<User> getSpec(String keyword) {
        return Optional.ofNullable(nameLike(keyword))
                .map(spec -> spec.or(surnameLike(keyword)))
                .map(spec -> spec.or(usernameLike(keyword)))
                .map(spec -> spec.or(roleLike(keyword)))
                .orElse(null);
    }

    public static Specification<User> getSpec(Map<String, String> filter) {
        ArrayList<Specification<User>> specs = new ArrayList<>(filter.size());

        for (Map.Entry<String, String> entry : filter.entrySet()) {
            String filterValue = entry.getValue();

            Specification<User> spec = switch (entry.getKey()) {
                case "name"     -> nameLike(filterValue);
                case "surname"  -> surnameLike(filterValue);
                case "username" -> usernameLike(filterValue);
                case "role"     -> roleLike(filterValue);
                default -> null;
            };

            if (spec != null) {
                specs.add(spec);
            }
        }

        return specs
                .stream()
                .reduce(Specification::or)
                .orElse(null);
    }

    public static Specification<User> nameLike(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return null;
        }

        return (root, query, cb) -> cb.like(cb.upper(root.get("name")), "%" + keyword.toUpperCase() + "%");
    }

    public static Specification<User> surnameLike(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return null;
        }

        return (root, query, cb) -> cb.like(cb.upper(root.get("surname")), "%" + keyword.toUpperCase() + "%");
    }

    public static Specification<User> usernameLike(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return null;
        }

        return (root, query, cb) -> cb.like(cb.upper(root.get("username")), "%" + keyword.toUpperCase() + "%");
    }

    public static Specification<User> roleLike(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return null;
        }

        return (root, query, cb) -> {
            Set<Role> roles = Role.contains(keyword);
            return root.get("role").in(roles);
        };
    }
}
