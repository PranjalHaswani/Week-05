package com.day1.advanceProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CSVMergerTest {
    @Test
    void testMergeCSV() {
        String filePath1 = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\students1.csv";
        String filePath2 = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\students2.csv";
        String outputFilePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\merged.csv";

        CSVMerger.main(new String[]{});

        // Read the merged CSV file and check if data matches
        try (BufferedReader br = new BufferedReader(new FileReader(outputFilePath))) {
            String line = br.readLine(); // Read the header
            assertEquals("ID,Name,Age,Marks,Grade", line);

            // Check first student data
            line = br.readLine();
            assertNotNull(line);
            String[] data = line.split(",");
            assertEquals("1", data[0].trim());
            assertEquals("John Doe", data[1].trim());
            assertEquals("20", data[2].trim());
            assertEquals("85", data[3].trim());
            assertEquals("A", data[4].trim());

        } catch (IOException e) {
            e.printStackTrace();
            fail("Error reading the merged file.");
        }

        // Check if output file exists
        File outputFile = new File(outputFilePath);
        assertTrue(outputFile.exists());
    }
}
