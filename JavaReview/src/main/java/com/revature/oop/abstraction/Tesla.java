package com.revature.oop.abstraction;

public class Tesla implements Car{

    // These methods must again be implemented
    // The implementation can change
    @Override
    public void drive() {
        System.out.println("The tesla drives and accelerates quickly");
    }

    @Override
    public void alarm() {
        System.out.println("BEEEEEEEEEEEEEEEEEEEEEEEEEEEP");
    }

    @Override
    public void consumeFuel() {
        System.out.println("The tesla drained the battery");
    }
}
