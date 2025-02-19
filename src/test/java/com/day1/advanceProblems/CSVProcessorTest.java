package com.day1.advanceProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVProcessorTest {

    // Helper method to create a dummy CSV file for testing
    private void createTestCsvFile(String filePath, int numberOfLines) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        for (int i = 1; i <= numberOfLines; i++) {
            writer.write("Record " + i + "\n");
        }
        writer.close();
    }

    @Test
    public void testProcessCsvFile() throws IOException {
        // Test file path
        String testFilePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\largeStudents.csv";
        int linesPerChunk = 100;
        int totalLines = 500;  // Total lines in the CSV for testing

        // Create a test file with 500 lines
        createTestCsvFile(testFilePath, totalLines);

        // Test processing the file
        int totalRecordsProcessed = CSVProcessor.processCsvFile(testFilePath, linesPerChunk);

        // Assert that the total number of records processed is as expected
        assertEquals(totalLines, totalRecordsProcessed);
    }
}
