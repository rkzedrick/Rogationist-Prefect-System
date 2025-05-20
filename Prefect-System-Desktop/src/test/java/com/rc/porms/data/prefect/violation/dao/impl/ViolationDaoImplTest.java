package com.rc.porms.data.prefect.violation.dao.impl;

import com.rc.porms.appl.model.student.Student;
import com.rc.porms.appl.model.violation.Violation;
import com.rc.porms.data.prefect.violation.ViolationDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ViolationDaoImplTest {

    @Mock
    private ViolationDao violationDaoMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllViolation() {
        Violation violation1 = new Violation();
        violation1.setId(1);

        Violation violation2 = new Violation();
        violation2.setId(2);
        when(violationDaoMock.getAllViolation()).thenReturn(Arrays.asList(violation1, violation2));

        List<Violation> violations = violationDaoMock.getAllViolation();

        assertNotNull(violations);
        assertEquals(2, violations.size());
        assertEquals(1, violations.get(0).getId());
        assertEquals(2, violations.get(1).getId());

        verify(violationDaoMock, times(1)).getAllViolation();
    }

    @Test
    void testGetAllViolationByClusterName() {
        Violation violation1 = new Violation();
        violation1.setId(1);

        Violation violation2 = new Violation();
        violation2.setId(2);
        when(violationDaoMock.getAllViolationByClusterName("CETE")).thenReturn(Arrays.asList(violation1, violation2));

        List<Violation> violations = violationDaoMock.getAllViolationByClusterName("CETE");

        assertNotNull(violations);
        assertEquals(2, violations.size());
        assertEquals(1, violations.get(0).getId());
        assertEquals(2, violations.get(1).getId());

        verify(violationDaoMock, times(1)).getAllViolationByClusterName("CETE");
    }

    @Test
    void testGetViolationByID() {
        Violation violation1 = new Violation();
        violation1.setId(1);

        when(violationDaoMock.getViolationByID(1)).thenReturn(violation1);

        Violation violation = violationDaoMock.getViolationByID(1);

        assertNotNull(violation);
        assertEquals(1, violation.getId());

        verify(violationDaoMock, times(1)).getViolationByID(1);
    }

    @Test
    void testGetAllViolationByStudent() {
        Student student = new Student();
        student.setId(1);

        Violation violation1 = new Violation();
        violation1.setId(1);
        violation1.setStudent(student);

        Violation violation2 = new Violation();
        violation2.setId(2);
        violation2.setStudent(student);

        when(violationDaoMock.getAllViolationByStudent(student)).thenReturn(Arrays.asList(violation1, violation2));

        List<Violation> violations = violationDaoMock.getAllViolationByStudent(student);

        assertNotNull(violations);
        assertEquals(2, violations.size());
        assertEquals(1, violations.get(0).getId());
        assertEquals(2, violations.get(1).getId());

        verify(violationDaoMock, times(1)).getAllViolationByStudent(student);
    }

    @Test
    void testFindByStudentName() {
        String lastName = "Amulong";
        String firstName = "Kate Ann";

        Violation violation1 = new Violation();
        violation1.setId(1);

        Violation violation2 = new Violation();
        violation2.setId(2);
        when(violationDaoMock.findByStudentName(lastName, firstName)).thenReturn(Arrays.asList(violation1, violation2));

        List<Violation> violations = violationDaoMock.findByStudentName(lastName, firstName);

        assertNotNull(violations);
        assertEquals(2, violations.size());

        verify(violationDaoMock, times(1)).findByStudentName(lastName, firstName);
    }

    @Test
    void testAddViolation() {
        Violation violation = new Violation();
        violation.setId(1);

        when(violationDaoMock.addViolation(violation)).thenReturn(true);

        boolean result = violationDaoMock.addViolation(violation);
        assertTrue(result);
        verify(violationDaoMock, times(1)).addViolation(violation);
    }

    @Test
    void testUpdateViolation() {
        Violation violation = new Violation();
        violation.setId(1);

        when(violationDaoMock.updateViolation(violation)).thenReturn(true);

        boolean result = violationDaoMock.updateViolation(violation);
        assertTrue(result);
        verify(violationDaoMock, times(1)).updateViolation(violation);
    }
}
