package com.day2.Hands_OnPracticeProblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;

public class JSONToXMLConverter {
    public static void main(String[] args) {
        // Sample JSON string
        String jsonString = "{ \"name\": \"John\", \"age\": 30, \"city\": \"New York\" }";

        // Create ObjectMapper and XmlMapper
        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            String xmlString = xmlMapper.writeValueAsString(jsonNode);
            System.out.println("XML Format: \n" + xmlString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
