package com.day2.PracticeProblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSonValidator {
    // Method to validate the JSON structure
    public static boolean validateJsonStructure(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Parse the JSON string into a JsonNode
            JsonNode rootNode = objectMapper.readTree(json);
            // Check if essential fields are present
            if (rootNode.has("name") && rootNode.has("email") && rootNode.has("age")) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) {
        // Example valid JSON string
        String validJson = "{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\", \"age\": 30}";

        // Example invalid JSON string
        String invalidJson = "{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\"}";

        // Validate JSON structures
        System.out.println("Valid JSON Structure: " + validateJsonStructure(validJson));
        System.out.println("Invalid JSON Structure: " + validateJsonStructure(invalidJson));
    }
}
