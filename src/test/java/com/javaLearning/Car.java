package com.javaLearning;

public class Car extends Vehicle {
    private String modelName = "Mustang"; // Car attribute

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.brand);
        System.out.println(car.modelName);
        car.honk();
    }
}
