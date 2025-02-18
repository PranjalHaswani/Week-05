package com.day1.basicProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileAndPrintData {
    public static void main(String[] args) {
        //Student File
        String filepath="D:\\Capgemini\\WEEK-05\\src\\main\\resources\\Student.csv";
        //Uses BufferedReader to read each line
        try(BufferedReader br= new BufferedReader(new FileReader(filepath))){
            String line;
            while((line= br.readLine())!= null){
                String[] columns= line.split(",");
                System.out.println("ID: " + columns[0]+ ", Name: " + columns[1]+ ", Age: "+ columns[2]+ ", Marks: "+ columns[3]);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

