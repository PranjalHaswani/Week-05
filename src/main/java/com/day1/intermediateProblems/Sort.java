package com.day1.intermediateProblems;

import java.io.*;
import java.util.*;

public class Sort {

    // Class to represent an employee
    static class Employee {
        String name;
        String department;
        double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return name + "," + department + "," + salary;
        }
    }

    // Method to read the CSV file, sort by salary in descending order, and print top 5 highest-paid employees
    public void printTop5HighestPaidEmployees(String csvFilePath) {
        List<Employee> employees = new ArrayList<>();
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            while ((line = br.readLine()) != null) {
                String[] employeeData = line.split(csvSplitBy);

                // Assuming the CSV columns are: Name, Department, Salary
                if (employeeData.length == 3) {
                    String name = employeeData[0];
                    String department = employeeData[1];
                    double salary = Double.parseDouble(employeeData[2]);
                    employees.add(new Employee(name, department, salary));
                }
            }

            // Sort the employees by salary in descending order
            employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

            // Print the top 5 highest-paid employees
            System.out.println("Top 5 Highest Paid Employees:");
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                System.out.println(employees.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        String csvFilePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\HighPay.csv";
        Sort salarySort = new Sort();
        salarySort.printTop5HighestPaidEmployees(csvFilePath);
    }
}
