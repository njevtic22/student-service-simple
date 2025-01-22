package com.example.studentservice.repository.criteria;

import com.example.studentservice.model.Student;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StudentSpecification {
    public Specification<Student> getSpec(Map<String, String> filter) {
        return nameLike(filter.get("name"));
    }

    public Specification<Student> nameLike(String filterName) {
        if (filterName == null || filterName.isBlank()) {
            return null;
        }

        return (root, query, cb) -> cb.like(cb.upper(root.get("name")), "%" + filterName.toUpperCase() + "%");
    }
}
