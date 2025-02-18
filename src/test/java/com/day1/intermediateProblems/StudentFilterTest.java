package com.day1.intermediateProblems;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentFilterTest {

    private static final String TEST_CSV_FILE = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\StudentsRecord.csv";

    @Before
    public void setUp() throws IOException {
        // Create a sample CSV file for testing
        try (FileWriter writer = new FileWriter(TEST_CSV_FILE)) {
            writer.append("John,85\n");
            writer.append("Hency,55\n");
            writer.append("Gagan,32\n");
            writer.append("Hanry,65\n");
            writer.append("Poplu,89\n");
        }
    }

    @Test
    public void testFilterStudents() {
        StudentFilter filter = new StudentFilter();
        List<String> qualifyingStudents = filter.filterStudents(TEST_CSV_FILE);

        // Assert that the correct students are selected
        assertEquals(2, qualifyingStudents.size());
        assertTrue(qualifyingStudents.contains("John,85"));
        assertTrue(qualifyingStudents.contains("Poplu,89"));
    }
}
