package com.day2.PracticeProblems;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    public String OwnerName;
    public String NumberPlate;
    public String CarName;

    //Creating Constructor
    public Car(String OwnerName, String NumberPlate, String CarName) {
        this.OwnerName = OwnerName;
        this.NumberPlate = NumberPlate;
        this.CarName = CarName;
    }
}
public class ObjectToJsonFormat {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Car car = new Car("Sunny", "MP162025", "Creta");
            //Convert Java Object to JSON String
            String jsonString = objectMapper.writeValueAsString(car);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

