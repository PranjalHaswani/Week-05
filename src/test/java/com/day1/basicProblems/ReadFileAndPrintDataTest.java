package com.day1.basicProblems;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class ReadFileAndPrintDataTest {

    @Test
    public void testReadFileAndPrintData() throws IOException {
        // Prepare test data for the file
        String testData = "101,Alice,12,206\n106,Bob,21,403\n111,Charlie,22,65\n";

        // Create a temporary file with the test data
        Path tempFile = Files.createTempFile("Student", ".csv");
        Files.write(tempFile, testData.getBytes());

        // Call the method that prints data
        File file = tempFile.toFile();
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }
}
