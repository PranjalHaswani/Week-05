package com.day1.advanceProblems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.*;

public class CSVReportFromDatabaseTest {

    // Mock in-memory database setup (H2 for testing)
    private String dbUrl = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private String dbUsername = "sa";
    private String dbPassword = "";
    private String csvFilePath = "test_employee_report.csv";

    @BeforeEach
    public void setup() throws Exception {
        // Set up in-memory database and create table for testing
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE TABLE employees (" +
                    "employee_id INT PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "department VARCHAR(100), " +
                    "salary DECIMAL(10, 2))");

            // Insert test data into the employees table
            stmt.execute("INSERT INTO employees (employee_id, name, department, salary) VALUES (1, 'Alice', 'Engineering', 75000.00)");
            stmt.execute("INSERT INTO employees (employee_id, name, department, salary) VALUES (2, 'Bob', 'Sales', 55000.00)");
            stmt.execute("INSERT INTO employees (employee_id, name, department, salary) VALUES (3, 'Charlie', 'HR', 60000.00)");
        }
    }

    @Test
    public void testGenerateCsvReport() throws Exception {
        // Generate the CSV report
        CSVReportFromDatabase.generateCsvReport(dbUrl, dbUsername, dbPassword, csvFilePath);

        // Check if the file was created
        File csvFile = new File(csvFilePath);
        assertTrue(csvFile.exists(), "CSV file should exist");

        // Check if the CSV file contains the expected header and data
        String content = new String(Files.readAllBytes(Paths.get(csvFilePath)));
        assertTrue(content.contains("Employee ID, Name, Department, Salary"), "CSV should contain header");
        assertTrue(content.contains("1, Alice, Engineering, 75000.00"), "CSV should contain Alice's record");
        assertTrue(content.contains("2, Bob, Sales, 55000.00"), "CSV should contain Bob's record");
        assertTrue(content.contains("3, Charlie, HR, 60000.00"), "CSV should contain Charlie's record");

        // Clean up by deleting the test CSV file
        Files.delete(Paths.get(csvFilePath));
    }
}
