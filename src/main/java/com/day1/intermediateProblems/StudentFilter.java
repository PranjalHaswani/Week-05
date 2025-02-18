package com.day1.intermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentFilter {

    // Method to filter students who scored more than 80 marks
    public List<String> filterStudents(String csvFilePath) {
        List<String> qualifyingStudents = new ArrayList<>();
        String line;
        String csvSplitBy = ",";

        // Try-with-resources to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            while ((line = br.readLine()) != null) {
                // Split the line by comma (CSV format)
                String[] studentData = line.split(csvSplitBy);

                // Check if the student data has the expected number of columns
                if (studentData.length == 2) {
                    try {
                        // Assuming the second column is the score
                        int score = Integer.parseInt(studentData[1].trim());
                        if (score > 80) {
                            qualifyingStudents.add(line); // Add qualifying student to the list
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid score format for student: " + studentData[0]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return qualifyingStudents;
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Path to your CSV file (update with actual path)
        String csvFilePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\StudentsRecord.csv";

        // Create an instance of StudentFilter
        StudentFilter filter = new StudentFilter();

        // Get the list of students who scored more than 80
        List<String> qualifyingStudents = filter.filterStudents(csvFilePath);

        // Print the qualifying students
        System.out.println("Students who scored more than 80 marks:");
        if (qualifyingStudents.isEmpty()) {
            System.out.println("No students scored more than 80 marks.");
        } else {
            for (String student : qualifyingStudents) {
                System.out.println(student);
            }
        }
    }
}

