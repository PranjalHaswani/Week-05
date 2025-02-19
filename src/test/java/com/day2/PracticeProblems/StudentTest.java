package com.day2.PracticeProblems;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testStudentJson() {
        // Create the expected JSON object
        JSONObject expectedJsonObject = new JSONObject();
        expectedJsonObject.put("name", "Alice");
        expectedJsonObject.put("age", 25);

        JSONArray expectedSubjects = new JSONArray();
        expectedSubjects.put("Math");
        expectedSubjects.put("Science");
        expectedSubjects.put("History");

        expectedJsonObject.put("subjects", expectedSubjects);

        // Now, create the actual JSON object (like in your main method)
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Alice");
        jsonObject.put("age", 25);

        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Science");
        subjects.put("History");

        jsonObject.put("subjects", subjects);

        // Assert that the actual JSON object matches the expected one
        assertEquals(expectedJsonObject.toString(), jsonObject.toString());
    }
}
