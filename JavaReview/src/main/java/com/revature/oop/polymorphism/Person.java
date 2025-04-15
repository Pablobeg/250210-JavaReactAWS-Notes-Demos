package com.revature.oop.polymorphism;

import java.util.Objects;

public class Person{

    String name;

    int age;

    char firstInitial;

    // Constructors
    // These methods are used to create an object and initialize properties
    public Person(){
        // No-args
    }

    public Person(String name, int age, char firstInitial){
        // All-args
        this.name = name;
        this.age = age;
        this.firstInitial = firstInitial;
    }

    public Person(String name, int age){
        // Some-args
        this.name = name;
        this.age = age;
        // Derive the first initial from the name itself
        this.firstInitial = name.charAt(0);
    }

    // Since we extend the object class implicitly we can override methods from it
    @Override
    public String toString(){
        return "Person {" +
                " name: " + this.name +
                ", age: " + this.age +
                ", firstInitial: " + this.firstInitial + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && firstInitial == person.firstInitial && Objects.equals(name, person.name);
    }
}
