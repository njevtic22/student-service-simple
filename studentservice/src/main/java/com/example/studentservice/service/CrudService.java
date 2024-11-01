package com.example.studentservice.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface CrudService<T> {
    T add(T newT);

    Slice<T> getAll(Pageable pageable);

    T getById(Long id);

    T update(String identification, T changes);

    void delete(String identification);
}
