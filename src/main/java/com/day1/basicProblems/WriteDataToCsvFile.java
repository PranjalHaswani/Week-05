package com.day1.basicProblems;

import java.io.*;

public class WriteDataToCsvFile {
    public static void main(String[] args) {
        String filePath = "D:\\Capgemini\\WEEK-05\\src\\main\\resources\\Employees.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("1,Alice,Engineering,11200\n");
            writer.write("2,Bob,Manager,512030\n");
            writer.write("3,Charlie,Sales,32100\n");
            System.out.println("CSV file written successfully");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

