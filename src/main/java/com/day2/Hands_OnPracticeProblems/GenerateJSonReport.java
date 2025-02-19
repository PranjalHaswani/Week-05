package com.day2.Hands_OnPracticeProblems;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class GenerateJSonReport {

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
        List<Employee> employees = getEmployeeDataFromMockDatabase();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Convert list to JSON
            String jsonReport = objectMapper.writeValueAsString(employees);
            System.out.println("Generated JSON Report:");
            System.out.println(jsonReport);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Employee> getEmployeeDataFromMockDatabase() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee() {{
            setId(1);
            setName("John");
            setAge(30);
            setDepartment("HR");
        }});
        employees.add(new Employee() {{
            setId(2);
            setName("Alice");
            setAge(28);
            setDepartment("IT");
        }});
        employees.add(new Employee() {{
            setId(3);
            setName("Bob");
            setAge(35);
            setDepartment("Finance");
        }});
        return employees;
    }
}
