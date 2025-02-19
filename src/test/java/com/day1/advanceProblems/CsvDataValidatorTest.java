package com.day1.advanceProblems;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import java.util.*;

public class CsvDataValidatorTest {

    @Test
    public void testValidEmail() {
        assertTrue(CsvDataValidator.isValidEmail("test@example.com"));
        assertFalse(CsvDataValidator.isValidEmail("invalid-email"));
    }

    @Test
    public void testValidPhoneNumber() {
        assertTrue(CsvDataValidator.isValidPhoneNumber("1234567890"));
        assertFalse(CsvDataValidator.isValidPhoneNumber("12345"));
        assertFalse(CsvDataValidator.isValidPhoneNumber("12345678901"));
        assertFalse(CsvDataValidator.isValidPhoneNumber("123456789a"));
    }

    @Test
    public void testValidateCSV() {
        List<String[]> invalidRows = CsvDataValidator.validateCSV("D:\\Capgemini\\WEEK-05\\src\\main\\resources\\email.csv");

        // Assert that invalid rows are found
        assertFalse(invalidRows.isEmpty());

        // Check that a specific invalid row is present (for testing purposes)
        boolean foundInvalidRow = false;
        for (String[] row : invalidRows) {
            if (Arrays.toString(row).contains("invalid-email")) {
                foundInvalidRow = true;
                break;
            }
        }
        assertTrue(foundInvalidRow);

        // Check that no valid rows are marked invalid
        boolean foundValidRow = false;
        for (String[] row : invalidRows) {
            if (Arrays.toString(row).contains("john.doe@example.com")) {
                foundValidRow = true;
                break;
            }
        }
        assertFalse(foundValidRow);
    }
}
