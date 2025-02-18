package com.day1.intermediateProblems;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeSearchTest {

    private static final String TEST_CSV_FILE = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\employeeFile.csv";

    @Before
    public void setUp() throws IOException {
        // Create a sample CSV file for testing
        try (FileWriter writer = new FileWriter(TEST_CSV_FILE)) {
            writer.append("John,Engineering,75000\n");
            writer.append("Alice,HR,55000\n");
            writer.append("Bob,Marketing,60000\n");
            writer.append("Charlie,Engineering,70000\n");
            writer.append("David,Sales,65000\n");
        }
    }

    @Test
    public void testSearchEmployee() {
        EmployeeSearch search = new EmployeeSearch();

        // Search for a valid employee
        String result = search.searchEmployee(TEST_CSV_FILE, "John");
        assertEquals("Department: Engineering, Salary: 75000", result);

        // Search for a non-existing employee
        result = search.searchEmployee(TEST_CSV_FILE, "Michael");
        assertEquals("Employee not found", result);
    }
}

