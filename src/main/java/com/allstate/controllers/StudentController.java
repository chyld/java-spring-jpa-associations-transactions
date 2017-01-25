package com.allstate.controllers;

import com.allstate.entities.Student;
import com.allstate.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public Student create(@RequestBody Student student){
        return this.studentService.save(student);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Student> create(){
        return this.studentService.findAll();
    }
}
