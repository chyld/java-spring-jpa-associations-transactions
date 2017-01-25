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
        assertEquals(5, student.getId());
        assertEquals(0, student.getGrades().size());
    }

    @Test
    @Transactional
    public void shouldFindOneStudentById() throws Exception {
        Student student = new Student("bob@aol.com");
        student = this.studentService.findById(1);
        assertEquals(1, student.getId());
        assertEquals(3, student.getGrades().size());
        assertEquals(3, student.getKlasses().size());
    }

    @Test
    public void shouldGetStudentAverageScore() throws Exception {
        double average = this.studentService.average(1);
        assertEquals(51, average, 1);
    }

    @Test
    public void shouldNotGetStudentAverageScoreMissingStudent() throws Exception {
        double average = this.studentService.average(99);
        assertEquals(0, average, 1);
    }

    @Test
    public void shouldNotGetStudentAverageScoreNoGrades() throws Exception {
        double average = this.studentService.average(4);
        assertEquals(0, average, 1);
    }
}
