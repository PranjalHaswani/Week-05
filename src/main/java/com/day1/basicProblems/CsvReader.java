package com.day1.basicProblems;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CsvReader {

    public static void main(String[] args) {
        String filepath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\CsvRead.csv";
        int rowCount = 0;

        try (CSVReader csvReader = new CSVReader(new FileReader(filepath))) {
            String[] record;
            // Skip the header row
            csvReader.readNext();

            // Count the records
            while ((record = csvReader.readNext()) != null) {
                rowCount++;
            }

            System.out.println("Number of records (excluding header): " + rowCount);

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
