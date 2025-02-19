package com.day2.Hands_OnPracticeProblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import java.util.List;

class UserPerson {
    private String name;
    private int age;

    // Constructor
    public UserPerson(String name, int age) {
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

public class ObjectIntoJSonArray {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<UserPerson> people = new ArrayList<>();
        people.add(new UserPerson("John", 30));
        people.add(new UserPerson("Alice", 25));
        people.add(new UserPerson("Bob", 28));

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
