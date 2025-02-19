package com.day2.Hands_OnPracticeProblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

public class PrintKeysAndValues {
    public static void main(String[] args) {
        // Specify the path to the JSON file
        String filePath = "D:\\Capgemini\\WEEK-05-New\\src\\main\\resources\\KeyValue.json";

        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file into a JsonNode object
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // If the root node is an object, we can iterate over its fields (keys and values)
            if (rootNode.isObject()) {
                Iterator<Entry<String, JsonNode>> fields = rootNode.fields();
                while (fields.hasNext()) {
                    Entry<String, JsonNode> field = fields.next();
                    String key = field.getKey();
                    JsonNode value = field.getValue();

                    // Print the key and value
                    System.out.println("Key: " + key + ", Value: " + value);
                }
            } else {
                System.out.println("Root node is not a JSON object.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
