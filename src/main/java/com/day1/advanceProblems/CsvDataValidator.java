package com.day1.advanceProblems;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class CsvDataValidator {

    // Regex pattern for validating email
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    // Regex pattern for validating phone number (exactly 10 digits)
    private static final String PHONE_REGEX = "^\\d{10}$";

    public static void main(String[] args) {
        String csvFile = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\email.csv";
        List<String[]> invalidRows = validateCSV(csvFile);

        if (invalidRows.isEmpty()) {
            System.out.println("All rows are valid.");
        } else {
            System.out.println("Invalid rows found:");
            for (String[] row : invalidRows) {
                System.out.println("Invalid row: " + Arrays.toString(row));
            }
        }
    }

    public static List<String[]> validateCSV(String csvFile) {
        List<String[]> invalidRows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            // Skip header line if there is one
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                String email = row[0].trim();
                String phoneNumber = row[1].trim();

                // Validate email and phone number
                if (!isValidEmail(email) || !isValidPhoneNumber(phoneNumber)) {
                    invalidRows.add(row);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return invalidRows;
    }

    // Validate email format using regex
    static boolean isValidEmail(String email) {
        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    // Validate phone number (must be exactly 10 digits)
    static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern phonePattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = phonePattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
