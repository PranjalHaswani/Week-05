package com.day1.intermediateProblems;

import java.io.*;
import java.util.*;

public class EmployeeSalarySearch {

    // Method to update the salary of IT employees by 10%
    public void updateSalary(String inputFilePath, String outputFilePath) {
        List<String[]> updatedEmployees = new ArrayList<>();
        String line;
        String csvSplitBy = ",";

        // Try-with-resources to read the input file and write to the output file
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             FileWriter writer = new FileWriter(outputFilePath)) {

            // Read each line from the CSV file
            while ((line = br.readLine()) != null) {
                String[] employeeData = line.split(csvSplitBy);

                // Check if the employee is from the "IT" department
                if (employeeData.length == 3 && employeeData[1].equalsIgnoreCase("IT")) {
                    // Increase the salary by 10%
                    double currentSalary = Double.parseDouble(employeeData[2]);
                    double updatedSalary = currentSalary * 1.10;
                    employeeData[2] = String.format("%.2f", updatedSalary);
                }

                // Add the updated record to the list
                updatedEmployees.add(employeeData);
            }

            // Write the updated records back to a new CSV file
            for (String[] employee : updatedEmployees) {
                writer.append(String.join(",", employee));
                writer.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        String inputFilePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\updateEmployee.csv";
        String outputFilePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\NewEmployee.csv";

        EmployeeSalarySearch salaryUpdate = new EmployeeSalarySearch();
        salaryUpdate.updateSalary(inputFilePath, outputFilePath);

        System.out.println("Salary update completed. Updated records are saved in: " + outputFilePath);
    }
}
