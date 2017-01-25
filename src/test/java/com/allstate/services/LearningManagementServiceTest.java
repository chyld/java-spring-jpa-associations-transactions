package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Student;
import com.allstate.enums.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class LearningManagementServiceTest {
    @Autowired
    private LearningManagementService learningManagementService;

    @Autowired
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shoudEnrollStudents() throws Exception {
        List<String> emails = Arrays.asList("bob", "sara", "joe", "sam");
        Date date = Date.valueOf("2015-11-03");
        Klass klass = this.learningManagementService.enroll(emails, "Calc 3", date, 4, Department.SCIENCE, 430.5);
        assertEquals(4, klass.getId());
        assertEquals(4, klass.getStudents().size());
        assertEquals(0, klass.getGrades().size());
    }

    @Test
    public void shouldRollbackChangesDueToDatabaseError() throws Exception {
        KlassService fakeKlassService = mock(KlassService.class);
        when(fakeKlassService.save(any())).thenThrow(new javax.persistence.PersistenceException());

        this.learningManagementService.setKlassService(fakeKlassService);

        List<String> emails = Arrays.asList("bob", "sara", "joe", "sam");
        Date date = Date.valueOf("2015-11-03");
        try{
            Klass klass = this.learningManagementService.enroll(emails, "Calc 3", date, 4, Department.SCIENCE, 430.5);
        }catch (PersistenceException e){}

        Student student1 = this.studentService.findByEmail("bob@aol.com");
        Student student2 = this.studentService.findByEmail("sam");
        assertNotNull(student1);
        assertNull(student2);
    }
}
