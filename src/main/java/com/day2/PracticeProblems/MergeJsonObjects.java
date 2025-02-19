package com.day2.PracticeProblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class MergeJsonObjects {

    public static JsonNode mergeJsonObjects(String json1, String json2) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Parse both JSON strings into JsonNode objects
            JsonNode jsonNode1 = objectMapper.readTree(json1);
            JsonNode jsonNode2 = objectMapper.readTree(json2);

            // Merge the second JSON object into the first one
            ((ObjectNode) jsonNode1).setAll((ObjectNode) jsonNode2);

            return jsonNode1;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Example JSON strings
        String json1 = "{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\"}";
        String json2 = "{\"age\": 30, \"address\": \"1234 Elm Street\"}";

        // Merging the JSON objects
        JsonNode mergedJson = mergeJsonObjects(json1, json2);

        // Print the merged JSON object
        if (mergedJson != null) {
            System.out.println("Merged JSON: " + mergedJson.toString());
        } else {
            System.out.println("Error while merging JSON objects");
        }
    }
}

