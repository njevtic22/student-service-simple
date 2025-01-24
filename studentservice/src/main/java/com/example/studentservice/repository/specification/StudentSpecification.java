package com.example.studentservice.repository.specification;

import com.example.studentservice.model.Student;
import com.example.studentservice.model.YearOfStudies;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class StudentSpecification {
    public static Specification<Student> getSpec(String keyword) {
        // not optimal when filtering by different fields every time (HTTP request with different query parameters)
        // not optimal because it always creates SpecificationComposition with 7 layers deep
        // even if most of those layers return null (filtering not required for specified field)
        return Optional.ofNullable(nameLike(keyword))
                .map(spec -> spec.or(surnameLike(keyword)))
                .map(spec -> spec.or(indexLike(keyword)))
                .map(spec -> spec.or(addressLike(keyword)))
                .map(spec -> spec.or(phoneLike(keyword)))
                .map(spec -> spec.or(emailLike(keyword)))
                .map(spec -> spec.or(studiesLike(keyword)))
                .orElse(null);
    }

    public static Specification<Student> getSpec(Map<String, String> filter) {
        ArrayList<Specification<Student>> specs = new ArrayList<>(filter.size());

        for (Map.Entry<String, String> entry : filter.entrySet()) {
            String filterValue = entry.getValue();

            Specification<Student> spec = switch (entry.getKey()) {
                case "name"    -> nameLike(filterValue);
                case "surname" -> surnameLike(filterValue);
                case "index"   -> indexLike(filterValue);
                case "address" -> addressLike(filterValue);
                case "phone"   -> phoneLike(filterValue);
                case "email"   -> emailLike(filterValue);
                case "studies" -> studiesLike(filterValue);
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

    public static Specification<Student> nameLike(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return null;
        }

        return (root, query, cb) -> cb.like(cb.upper(root.get("name")), "%" + keyword.toUpperCase() + "%");
    }

    public static Specification<Student> surnameLike(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return null;
        }

        return (root, query, cb) -> cb.like(cb.upper(root.get("surname")), "%" + keyword.toUpperCase() + "%");
    }

    public static Specification<Student> indexLike(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return null;
        }

        return (root, query, cb) -> cb.like(cb.upper(root.get("index")), "%" + keyword.toUpperCase() + "%");
    }

    public static Specification<Student> addressLike(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return null;
        }

        return (root, query, cb) -> {
            String pattern = "%" + keyword.toUpperCase() + "%";
            Path<Object> address = root.get("address");
            Expression<String> city = cb.upper(address.get("city"));
            Expression<String> street = cb.upper(address.get("street"));
            Expression<String> number = address.get("number");

            Predicate p = cb.or(cb.like(city, pattern), cb.like(street, pattern));
            if (keyword.matches("[0-9]+")) {
                p = cb.or(p, cb.equal(number, keyword));
            }

            return p;
        };
    }

    public static Specification<Student> phoneLike(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return null;
        }

        return (root, query, cb) -> cb.like(cb.upper(root.get("phone")), "%" + keyword.toUpperCase() + "%");
    }

    public static Specification<Student> emailLike(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return null;
        }

        return (root, query, cb) -> cb.like(cb.upper(root.get("email")), "%" + keyword.toUpperCase() + "%");
    }

    public static Specification<Student> studiesLike(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return null;
        }

        return (root, query, cb) -> {
            Set<YearOfStudies> years = YearOfStudies.contains(keyword);
            return root.get("yearOfStudies").in(years);
        };
    }
}
