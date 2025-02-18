package com.day1.intermediateProblems;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.*;

public class SortTest {

    private static final String TEST_CSV_FILE = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\HighPay.csv";

    @Before
    public void setUp() throws IOException {
        // Create a sample CSV file for testing
        try (FileWriter writer = new FileWriter(TEST_CSV_FILE)) {
            writer.append("John,IT,75000\n");
            writer.append("Alice,HR,55000\n");
            writer.append("Bob,IT,90000\n");
            writer.append("Charlie,Engineering,95000\n");
            writer.append("David,Sales,65000\n");
            writer.append("Eva,IT,80000\n");
            writer.append("Frank,Engineering,105000\n");
            writer.append("Grace,Marketing,60000\n");
            writer.append("Holly,HR,70000\n");
            writer.append("Ivy,Sales,85000\n");
        }
    }

    @Test
    public void testPrintTop5HighestPaidEmployees() {
        Sort salarySort = new Sort();

        // Capture the output of the printTop5HighestPaidEmployees method
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Run the method
        salarySort.printTop5HighestPaidEmployees(TEST_CSV_FILE);

        // Get the printed output
        String output = outputStream.toString();

        // Verify the expected output
        assertTrue(output.contains("Frank,Engineering,105000.0"));
        assertTrue(output.contains("Charlie,Engineering,95000.0"));
        assertTrue(output.contains("Bob,IT,90000.0"));
        assertTrue(output.contains("Ivy,Sales,85000.0"));
        assertTrue(output.contains("Eva,IT,80000.0"));
    }
}
