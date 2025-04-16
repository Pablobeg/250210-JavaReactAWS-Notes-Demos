package com.revature.oop.abstraction;

// To Implement an interface we use the implements keyword
// Recall we'll need to provide implementations for all abstract methods from all implemented interfaces
public class Jeep implements Car{

    // All of these methods come DIRECTLY from the Car interface
    @Override
    public void drive() {
        System.out.println("The Jeep drives!");
    }

    @Override
    public void alarm() {
        System.out.println("BEEP BEEP BEEP");
    }

    @Override
    public void consumeFuel() {
        System.out.println("The jeep consumed some gasoline");
    }
}
