package com.day2.PracticeProblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
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
}

public class JSonArray {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 30));
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 28));

        // Convert list to JSON array using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Convert list of objects to JSON array string
            String jsonArray = objectMapper.writeValueAsString(people);
            System.out.println("JSON Array: " + jsonArray);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
