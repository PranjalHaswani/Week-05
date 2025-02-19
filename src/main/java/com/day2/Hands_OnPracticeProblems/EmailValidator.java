package com.day2.Hands_OnPracticeProblems;

import org.everit.json.schema.*;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class EmailValidator {
    public static void main(String[] args) {
        // Sample JSON to validate
        String json = "{ \"email\": \"test@example.com\" }";

        // Load the JSON schema from the file
        try (InputStream schemaStream = EmailValidator.class.getResourceAsStream("/SchemaEmail.json")) {
            if (schemaStream == null) {
                System.out.println("Schema file not found.");
                return;
            }

            // Load schema and create the validator
            JSONObject jsonSchema = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(jsonSchema);

            // Parse the JSON data to validate
            JSONObject jsonData = new JSONObject(json);

            // Validate the data
            schema.validate(jsonData);

            // If validation passes, print success
            System.out.println("Valid email!");

        } catch (ValidationException e) {
            // If invalid, print the validation error
            System.out.println("Validation error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
