package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Student;
import com.allstate.enums.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LearningManagementService {
    private GradeService gradeService;
    private KlassService klassService;
    private StudentService studentService;

    @Autowired
    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @Autowired
    public void setKlassService(KlassService klassService) {
        this.klassService = klassService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public Klass enroll(List<String> emails, String name, Date semester, int credits, Department department, double fee){
        List<Student> students = emails.stream().map(e -> new Student(e)).collect(Collectors.toList());
        Klass klass = new Klass(name, semester, credits, department, fee);
        klass.setStudents(students);
        this.studentService.saveAll(students);
        return this.klassService.save(klass);
    }
}
