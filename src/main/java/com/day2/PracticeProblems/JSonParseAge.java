package com.day2.PracticeProblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

class People {
    private String name;
    private int age;

    // Default constructor
    public People() {
    }

    // Constructor with parameters
    public People(String name, int age) {
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

public class JSonParseAge {
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
            List<People> people = objectMapper.readValue(jsonArray, new TypeReference<List<People>>() {});

            // Filter records where age > 25
            List<People> filteredPeople = people.stream()
                    .filter(People -> People.getAge() > 25)
                    .collect(Collectors.toList());

            // Print the filtered list
            System.out.println("Filtered People:");
            for (People person :filteredPeople) {
                System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
