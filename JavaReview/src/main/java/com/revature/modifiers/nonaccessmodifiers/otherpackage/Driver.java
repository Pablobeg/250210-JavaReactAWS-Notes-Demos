package com.revature.modifiers.nonaccessmodifiers.otherpackage;

import com.revature.modifiers.nonaccessmodifiers.Person;

public class Driver {
    public static void main(String[] args) {
        // In this class we can access the name variable from a Person since it is public but
        // the static variable lastName should not be accessible here
        Person p1 = new Person();

        p1.name = "John";
//        Person.lastName = "Smith";
    }
}
