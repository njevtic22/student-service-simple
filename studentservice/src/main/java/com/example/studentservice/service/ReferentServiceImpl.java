package com.example.studentservice.service;

import com.example.studentservice.model.Referent;
import com.example.studentservice.repository.ReferentRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class ReferentServiceImpl implements ReferentService {
    private final ReferentRepository repository;

    public ReferentServiceImpl(ReferentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Referent add(Referent newT) {
        return null;
    }

    @Override
    public Slice<Referent> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Referent getById(Long id) {
        return null;
    }

    @Override
    public Referent update(Long id, Referent changes) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
