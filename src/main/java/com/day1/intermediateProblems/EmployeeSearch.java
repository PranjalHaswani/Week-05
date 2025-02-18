package com.day1.intermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeSearch {

    // Method to search for an employee by name and print their department and salary
    public String searchEmployee(String csvFilePath, String employeeName) {
        String line;
        String csvSplitBy = ",";
        String result = "Employee not found";

        // Try-with-resources to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            while ((line = br.readLine()) != null) {
                // Split the line by comma (CSV format)
                String[] employeeData = line.split(csvSplitBy);

                // Assuming the CSV columns are: Name, Department, Salary
                if (employeeData.length == 3 && employeeData[0].equalsIgnoreCase(employeeName)) {
                    result = "Department: " + employeeData[1] + ", Salary: " + employeeData[2];
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Path to your CSV file (update with actual path)
        String csvFilePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\employeeFile.csv";
        EmployeeSearch search = new EmployeeSearch();

        // Search for a specific employee
        String result = search.searchEmployee(csvFilePath, "John");
        System.out.println(result);
    }
}
