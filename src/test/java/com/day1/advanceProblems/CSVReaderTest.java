package com.day1.advanceProblems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {
    @Test
    void testReadCSV() {
        // Assuming your test CSV file is in the same directory as the project
        String filePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\Students.csv";
        List<Student> students = CSVReader.readCSV(filePath);

        // Assert that there are 4 students in the list
        assertEquals(4, students.size());

        // Assert that the first student has correct data
        Student firstStudent = students.get(0);
        assertEquals(1, firstStudent.getId());
        assertEquals("John Doe", firstStudent.getName());
        assertEquals(20, firstStudent.getAge());
        assertEquals("A", firstStudent.getGrade());
    }
}
