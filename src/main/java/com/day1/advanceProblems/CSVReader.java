package com.day1.advanceProblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    // Constructor
    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // toString method for displaying the object
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + ", grade='" + grade + "'}";
    }
}
public class CSVReader {
    public static void main(String[] args) {
        String filePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\Students.csv";
        List<Student> students = readCSV(filePath);

        // Print out the list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> readCSV(String filePath) {
        List<Student> studentList = new ArrayList<>();
        String line;
        String splitBy = ","; // Assuming CSV uses comma as delimiter

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip header row if necessary
            br.readLine();

            // Read each line of the CSV file
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);

                // Create Student object and add it to the list
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                String grade = data[3].trim();

                Student student = new Student(id, name, age, grade);
                studentList.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}

