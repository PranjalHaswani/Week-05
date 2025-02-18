package com.day1.basicProblems;

import org.junit.Test;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class WriteDataToCsvFileTest {

    private static final String filePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\Employees.csv";

    @Test
    public void testWriteToCsvFile() throws IOException {
        // Run the method that writes to the CSV file
        WriteDataToCsvFile.main(new String[]{});

        // Check if the file exists
        File file = new File(filePath);
        assertTrue(file.exists(), "CSV file should exist");

        // Check if the content of the file is correct
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            assertNotNull(line, "First line should not be null");
            assertEquals("ID,Name,Department,Salary", line);

            line = reader.readLine();
            assertEquals("1,Alice,Engineering,11200", line);

            line = reader.readLine();
            assertEquals("2,Bob,Manager,512030", line);

            line = reader.readLine();
            assertEquals("3,Charlie,Sales,32100", line);
        }
    }
}
