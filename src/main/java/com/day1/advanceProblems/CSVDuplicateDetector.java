package com.day1.advanceProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVDuplicateDetector {

    // Method to read the CSV file and detect duplicates based on the "ID" column
    public static void detectDuplicates(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        Map<String, String> records = new HashMap<>();
        boolean isFirstLine = true;

        // Reading each line from the file
        while ((line = reader.readLine()) != null) {
            // Skip the header line
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }

            // Split the line by comma
            String[] columns = line.split(",");

            // Assuming the first column is "ID"
            String id = columns[0];
            String record = line;

            // Check for duplicates based on the ID column
            if (records.containsKey(id)) {
                System.out.println("Duplicate record: " + record);
            } else {
                records.put(id, record);
            }
        }

        reader.close();
    }

    public static void main(String[] args) {
        String filePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\duplicate.csv";

        try {
            detectDuplicates(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
