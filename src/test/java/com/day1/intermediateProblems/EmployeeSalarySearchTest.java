package com.day1.intermediateProblems;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class EmployeeSalarySearchTest {

    private static final String INPUT_CSV_FILE = "src/test/resources/employees.csv";
    private static final String OUTPUT_CSV_FILE = "src/test/resources/employees_updated.csv";

    @Before
    public void setUp() throws IOException {
        // Create a sample CSV file for testing
        try (FileWriter writer = new FileWriter(INPUT_CSV_FILE)) {
            writer.append("John,IT,75000\n");
            writer.append("Alice,HR,55000\n");
            writer.append("Bob,IT,60000\n");
            writer.append("Charlie,Engineering,70000\n");
            writer.append("David,IT,65000\n");
        }
    }

    @Test
    public void testUpdateSalary() {
        // Run the salary update method
        EmployeeSalarySearch salaryUpdate = new EmployeeSalarySearch();
        salaryUpdate.updateSalary(INPUT_CSV_FILE, OUTPUT_CSV_FILE);

        // Verify that the output file exists
        File outputFile = new File(OUTPUT_CSV_FILE);
        assertTrue("The output file should exist", outputFile.exists());

        // Read the updated CSV file and verify the changes
        try (BufferedReader br = new BufferedReader(new FileReader(OUTPUT_CSV_FILE))) {
            String line;
            boolean johnUpdated = false, bobUpdated = false, davidUpdated = false;

            while ((line = br.readLine()) != null) {
                String[] employeeData = line.split(",");
                if (employeeData.length == 3) {
                    if (employeeData[0].equals("John")) {
                        assertEquals("82500.00", employeeData[2]);
                        johnUpdated = true;
                    }
                    if (employeeData[0].equals("Bob")) {
                        assertEquals("66000.00", employeeData[2]);
                        bobUpdated = true;
                    }
                    if (employeeData[0].equals("David")) {
                        assertEquals("71500.00", employeeData[2]);
                        davidUpdated = true;
                    }
                }
            }

            // Check if the necessary updates were made
            assertTrue("John's salary should have been updated", johnUpdated);
            assertTrue("Bob's salary should have been updated", bobUpdated);
            assertTrue("David's salary should have been updated", davidUpdated);
        } catch (IOException e) {
            e.printStackTrace();
            fail("An error occurred while reading the updated CSV file.");
        }
    }
}
