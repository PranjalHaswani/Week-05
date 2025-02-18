package com.day1.advanceProblems;
import java.io.*;
import java.util.*;

class Student1 {
    private int id;
    private String name;
    private int age;

    // Constructor
    public Student1(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
class Student2 {
    private int id;
    private int marks;
    private String grade;

    // Constructor
    public Student2(int id, int marks, String grade) {
        this.id = id;
        this.marks = marks;
        this.grade = grade;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public int getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }
}
class MergedStudent {
    private int id;
    private String name;
    private int age;
    private int marks;
    private String grade;

    // Constructor
    public MergedStudent(int id, String name, int age, int marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}

public class CSVMerger {
    public static void main(String[] args) {
        String filePath1 = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\students1.csv";
        String filePath2 = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\students2.csv";
        String outputFilePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\merged.csv";

        Map<Integer, Student1> students1Map = readStudents1CSV(filePath1);
        Map<Integer, Student2> students2Map = readStudents2CSV(filePath2);
        List<MergedStudent> mergedStudents = mergeData(students1Map, students2Map);
        writeMergedCSV(mergedStudents, outputFilePath);
    }

    public static Map<Integer, Student1> readStudents1CSV(String filePath) {
        Map<Integer, Student1> students1Map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header row
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                students1Map.put(id, new Student1(id, name, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students1Map;
    }

    public static Map<Integer, Student2> readStudents2CSV(String filePath) {
        Map<Integer, Student2> students2Map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header row
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                int marks = Integer.parseInt(data[1].trim());
                String grade = data[2].trim();
                students2Map.put(id, new Student2(id, marks, grade));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students2Map;
    }

    public static List<MergedStudent> mergeData(Map<Integer, Student1> students1Map, Map<Integer, Student2> students2Map) {
        List<MergedStudent> mergedStudents = new ArrayList<>();
        for (Integer id : students1Map.keySet()) {
            if (students2Map.containsKey(id)) {
                Student1 student1 = students1Map.get(id);
                Student2 student2 = students2Map.get(id);
                MergedStudent mergedStudent = new MergedStudent(id, student1.getName(), student1.getAge(), student2.getMarks(), student2.getGrade());
                mergedStudents.add(mergedStudent);
            }
        }
        return mergedStudents;
    }

    public static void writeMergedCSV(List<MergedStudent> mergedStudents, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Write header
            bw.write("ID,Name,Age,Marks,Grade\n");
            // Write student data
            for (MergedStudent student : mergedStudents) {
                bw.write(student.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




