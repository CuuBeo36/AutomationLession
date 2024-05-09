package com.javaLearning;

public class Car2 extends Vehicle {
    private String modelName = "Kia Morning";

    public static void main(String[] args) {
        Car2 car2 = new Car2();
        System.out.println(car2.modelName);
        System.out.println(car2.brand);
        car2.honk();
    }

    public void honk() {
        System.out.println("Test, Test!"); // Vehicle method
    }
}
