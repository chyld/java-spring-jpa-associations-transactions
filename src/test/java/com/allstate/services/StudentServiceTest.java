package com.allstate.services;

import com.allstate.entities.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateNewStudent() throws Exception {
        Student student = new Student("bob@aol.com");
        student = this.studentService.save(student);
        assertEquals(4, student.getId());
        assertEquals(0, student.getGrades().size());
    }

    @Test
    @Transactional
    public void shouldFindOneStudentById() throws Exception {
        Student student = new Student("bob@aol.com");
        student = this.studentService.findById(1);
        assertEquals(1, student.getId());
        assertEquals(0, student.getGrades().size());
    }
}
