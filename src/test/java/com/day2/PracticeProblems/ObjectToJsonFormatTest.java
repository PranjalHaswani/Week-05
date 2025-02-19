package com.day2.PracticeProblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObjectToJsonFormatTest {

    @Test
    public void testObjectToJsonConversion() {
        try {
            // Creating a new Car object
            Car car = new Car("Sunny", "MP162025", "Creta");

            // Using ObjectMapper to convert the object to JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(car);

            // The expected JSON string
            String expectedJson = "{\"OwnerName\":\"Sunny\",\"NumberPlate\":\"MP162025\",\"CarName\":\"Creta\"}";

            // Asserting that the conversion matches the expected JSON string
            assertEquals(expectedJson, jsonString);

        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during JSON conversion");
        }
    }
}
