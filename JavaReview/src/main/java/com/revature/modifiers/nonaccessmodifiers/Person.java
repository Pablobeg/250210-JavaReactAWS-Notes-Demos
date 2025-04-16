package com.revature.modifiers.nonaccessmodifiers;

public class Person {

    public String name;
    // This variable is accessible everywhere because its public

    static String lastName;
    // This variable belongs to the Person class but still has the default accessibility
    // Recall Default means it can be accessed within the same package
}
