package com.day2.Hands_OnPracticeProblems;

import com.opencsv.CSVReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToJSonConverter {

    // Define a simple POJO to represent an Employee
    public static class Employee {
        private int id;
        private String name;
        private int age;
        private String department;

        // Getters and Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }
    }

    public static void main(String[] args) {
        String csvFilePath = "D:\\Capgemini\\WEEK-05-New\\src\\main\\resources\\employees.csv";
        List<Employee> employees = new ArrayList<>();

        // Read the CSV file
        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            String[] header = csvReader.readNext();
            String[] record;

            while ((record = csvReader.readNext()) != null) {
                // Parse each record and map it to Employee object
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(record[0]));
                employee.setName(record[1]);
                employee.setAge(Integer.parseInt(record[2]));
                employee.setDepartment(record[3]);

                employees.add(employee);
            }

            // Convert the list of employees to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(employees);

            // Output the JSON to console
            System.out.println("Generated JSON Report:");
            System.out.println(json);

            // Optionally, write the JSON to a file
            try (FileWriter fileWriter = new FileWriter("D:\\Capgemini\\WEEK-05-New\\src\\main\\resources\\employees_Report.json")) {
                objectMapper.writeValue(fileWriter, employees);
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
