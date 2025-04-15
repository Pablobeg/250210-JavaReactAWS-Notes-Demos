package com.revature.oop.polymorphism;

public class Child2 extends Parent{

    // Here we're providing a new implementation in the child class, this method has been OVERRIDDEN
    @Override
    public void overrideMe() {
        System.out.println("New implementation in a child class!");
    }
}
