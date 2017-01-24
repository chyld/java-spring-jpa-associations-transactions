package com.allstate.services;

import com.allstate.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private IStudentRepository repository;

    @Autowired
    public void setRepository(IStudentRepository repository) {
        this.repository = repository;
    }
}
