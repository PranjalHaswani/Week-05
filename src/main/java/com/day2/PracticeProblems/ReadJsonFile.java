package com.day2.PracticeProblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

class User {
    public String name;
    public String email;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

public class ReadJsonFile {

    public static User extractFieldsFromJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read the JSON file into a JsonNode
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // Extract name and email
            String name = rootNode.path("name").asText();
            String email = rootNode.path("email").asText();

            // Create User object with extracted values
            User user = new User();
            user.name = name;
            user.email = email;

            return user;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Provide the path to the JSON file
        String filePath = "D:\\Capgemini\\WEEK-05-New\\src\\main\\resources\\user.json";

        // Extract fields from the JSON file
        User user = extractFieldsFromJson(filePath);

        // Print the extracted fields
        if (user != null) {
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
        } else {
            System.out.println("Error reading JSON file or extracting data.");
        }
    }
}
