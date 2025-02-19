package com.day1.advanceProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVProcessor {

    public static void main(String[] args) {
        String filePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\largeStudents.csv";
        int linesPerChunk = 100;
        int totalLinesProcessed = 0;

        try {
            totalLinesProcessed = processCsvFile(filePath, linesPerChunk);
            System.out.println("Total records processed: " + totalLinesProcessed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to process the CSV file in chunks
    public static int processCsvFile(String filePath, int linesPerChunk) throws IOException {
        int totalLinesProcessed = 0;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            totalLinesProcessed++;
            // Process the line here (for example, print it or store it)

            if (totalLinesProcessed % linesPerChunk == 0) {
                System.out.println("Processed " + totalLinesProcessed + " records.");
            }
        }

        reader.close();
        return totalLinesProcessed;
    }
}
