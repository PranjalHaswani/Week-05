package com.day2.Hands_OnPracticeProblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

class Human {
    private String name;
    private int age;

    // Default constructor
    public Human() {
    }

    // Constructor with parameters
    public Human(String name, int age) {
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

public class UsersOlder {
    public static void main(String[] args) {
        String jsonArray = "["
                + "{\"name\":\"John\",\"age\":30},"
                + "{\"name\":\"Alice\",\"age\":25},"
                + "{\"name\":\"Bob\",\"age\":28},"
                + "{\"name\":\"Eve\",\"age\":23}"
                + "]";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Parse the JSON string into a list of Person
            List<Human> people = objectMapper.readValue(jsonArray, new TypeReference<List<Human>>() {});

            // Filter records where age > 25
            List<Human> filteredPeople = people.stream()
                    .filter(People -> People.getAge() > 25)
                    .collect(Collectors.toList());

            // Print the filtered list
            System.out.println("Filtered People:");
            for (Human person :filteredPeople) {
                System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}