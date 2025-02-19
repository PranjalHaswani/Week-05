package com.day2.PracticeProblems;

import org.json.JSONObject;


import org.json.JSONArray;

public class Student {
    public static void main(String[] args) {
        // Create the JSONObject
        JSONObject jsonObject = new JSONObject();

        // Add basic fields to the JSON object
        jsonObject.put("name", "Alice");
        jsonObject.put("age", 25);

        // Create a JSONArray for subjects and add it to the JSON object
        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Science");
        subjects.put("History");

        jsonObject.put("subjects", subjects);

        // Print the JSON object
        System.out.println(jsonObject.toString());
    }
}
