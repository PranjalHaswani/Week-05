package com.day1.basicProblems;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvReadTest {

    @Test
    public void testCountRows() throws IOException, CsvValidationException {
        String filepath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\CsvRead.csv";
        int rowCount = 0;

        try (CSVReader csvReader = new CSVReader(new FileReader(filepath))) {
            // Skip the header row
            csvReader.readNext();

            // Count the records (excluding the header)
            String[] record;
            while ((record = csvReader.readNext()) != null) {
                rowCount++;
            }
        }
        assertEquals(2, rowCount);
    }
}
