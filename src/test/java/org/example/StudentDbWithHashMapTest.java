package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentDbWithHashMapTest {


    @Test
    void checkIfAddedStudentIsInHashMap() {

        Map<Integer, Student> testStudentMap = new HashMap<>();
        StudentDbWithHashMap studentDbWithHashMap = new StudentDbWithHashMap(testStudentMap);
        Student max = new Student("Max", 1);
        studentDbWithHashMap.addStudent(max);

        Map<Integer, Student> studentMap = studentDbWithHashMap.getAllStudentsAsHashMap();

        assertTrue(studentMap.containsKey(max.getId()));
    }

    @Test
    void CheckIfRemovesStudentDoesNotExistInHashMapAfterDeleting() {
        Map<Integer, Student> testStudentMap = new HashMap<>();
        StudentDbWithHashMap studentDbWithHashMap = new StudentDbWithHashMap(testStudentMap);
        Student max = new Student("Max", 1);
        studentDbWithHashMap.addStudent(max);
        Student studentToDelete = new Student("Max", 1);

        studentDbWithHashMap.removeStudent(studentToDelete);
        Map<Integer, Student> studentMap = studentDbWithHashMap.getAllStudentsAsHashMap();

        assertFalse(studentMap.containsKey(studentToDelete.getId()));
    }

    @Test
    void findStudentById() throws StudentIdNotFoundException {
        Map<Integer, Student> testStudentMap = new HashMap<>();
        StudentDbWithHashMap studentDbWithHashMap = new StudentDbWithHashMap(testStudentMap);
        Student expectedStudent = new Student("ExpectedStudent", 1);
        studentDbWithHashMap.addStudent(expectedStudent);

        Student actualStudent = studentDbWithHashMap.findById(1);

        assertEquals(expectedStudent, actualStudent);
    }

    @Test
    void findStudentByIdThrowsException() {
        Map<Integer, Student> testStudentMap = new HashMap<>();
        StudentDbWithHashMap studentDbWithHashMap = new StudentDbWithHashMap(testStudentMap);

        Student max = new Student("Max", 1);
        studentDbWithHashMap.addStudent(max);

        assertThrows(StudentIdNotFoundException.class, () -> studentDbWithHashMap.findById(2));
    }

    @Test
    void findStudentByIdThrowsExceptionWithTryAndCatch() {
        StudentDbWithHashMap studentDbWithHashMap = new StudentDbWithHashMap(new HashMap<>());

        Student max = new Student("Max", 1);
        studentDbWithHashMap.addStudent(max);

        try {
            studentDbWithHashMap.findById(2);
        } catch (StudentIdNotFoundException e) {
            assertEquals("Student with id 2 not found", e.getMessage());
        }
    }
}