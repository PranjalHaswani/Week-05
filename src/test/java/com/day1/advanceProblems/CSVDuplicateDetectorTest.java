package com.day1.advanceProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class CSVDuplicateDetectorTest {

    // Helper method to create a temporary CSV file for testing
    private File createTestCsvFile() throws IOException {
        File file = new File("D:\\Capgemini\\WEEK-05\\src\\main\\resources\\duplicate.csv");
        FileWriter writer = new FileWriter(file);
        writer.write("ID, Name, Age, City\n");
        writer.write("1, Alice, 25, New York\n");
        writer.write("2, Bob, 30, Los Angeles\n");
        writer.write("3, Charlie, 22, Chicago\n");
        writer.write("1, Alice, 25, New York\n");
        writer.write("4, David, 28, Boston\n");
        writer.write("2, Bob, 30, Los Angeles\n");
        writer.close();
        return file;
    }

    @Test
    public void testDetectDuplicates() throws IOException {
        // Create a temporary test CSV file
        File testFile = createTestCsvFile();

        // Set up to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Call the method to detect duplicates
        CSVDuplicateDetector.detectDuplicates(testFile.getPath());

        // Assert that the expected duplicates were printed
        String output = outputStream.toString();
        assertTrue(output.contains("Duplicate record: 1, Alice, 25, New York"));
        assertTrue(output.contains("Duplicate record: 2, Bob, 30, Los Angeles"));

    }
}
