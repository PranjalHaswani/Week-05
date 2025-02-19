package com.day1.advanceProblems;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class CSVReportFromDatabase {

    // Method to generate CSV report from database
    public static void generateCsvReport(String dbUrl, String dbUsername, String dbPassword, String filePath) throws Exception {
        // Establish connection to the database
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            // Create a statement to fetch employee data
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employee_id, name, department, salary FROM employees");

            // Create a FileWriter to write the CSV file
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                // Write CSV headers
                fileWriter.append("Employee ID, Name, Department, Salary\n");

                // Write records from the ResultSet to the CSV file
                while (resultSet.next()) {
                    int employeeId = resultSet.getInt("employee_id");
                    String name = resultSet.getString("name");
                    String department = resultSet.getString("department");
                    double salary = resultSet.getDouble("salary");

                    // Write each record as a new line in the CSV
                    fileWriter.append(employeeId + ", " + name + ", " + department + ", " + salary + "\n");
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            throw new Exception("Error generating CSV report", e);
        }
    }

    public static void main(String[] args) {
        // Example usage: Provide your DB credentials and the file path to save the CSV
        String dbUrl = "jdbc:mysql://localhost:3306/your_database_name";
        String dbUsername = "pranjal_haswani";
        String dbPassword = "@1234@9876";
        String filePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\ReportFile.csv";

        try {
            generateCsvReport(dbUrl, dbUsername, dbPassword, filePath);
            System.out.println("CSV report generated successfully.");
        } catch (Exception e) {
            System.err.println("Error generating CSV report: " + e.getMessage());
        }
    }
}

