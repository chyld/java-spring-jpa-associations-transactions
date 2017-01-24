package com.allstate.services;

import com.allstate.repositories.IGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {
    private IGradeRepository gradeRepository;

    @Autowired
    public void setGradeRepository(IGradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }
}
