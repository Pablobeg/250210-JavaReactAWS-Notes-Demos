package com.revature;

public class Person {

    /*
    What is a Class and What is an object?
    A Class is a blueprint for an Object and objects are actual instances of the classes stored in Heap Memory

    What does a class contain?
    A class contains members known as attributes/fields, constructors, methods/behaviors
     */

    // Fields / Attributes
    // Describe the characteristics of the object being made
    String name;

    // What are all of these datatypes below? Are they classes? Any other examples?
    /*
    Primitives -> The most basic units we can use to hold data, classes are built upon these
    int, double, boolean, char, float, long, short, byte

    True/False
        - Boolean - default

    Whole Number Primitives
        - Byte
        - Short
        - Int - default
        - Long

    Decimal Primitives
        - float
        - double - default

    Character Primitive
        - char - default


    Is a String a primitive?
    No, Strings are a collection of characters and they have various methods associated with them
        - toLowerCase
        - toUpperCase
        - concat
        - length
     */
    int age;

    double height;

    double weight;

    boolean isMarried;


    // Constructors
    // These are special methods designed to instantiate an object and set various instance fields
    // By default there is the no-args constructor which creates a blank object
    // But we can override this and create our own

    // No-args constructor
    public Person() {
    }

    // All-Args constructor -> Used to initialize each value
    public Person(String name, int age, double height, double weight, boolean isMarried) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.isMarried = isMarried;
    }


    // Methods / Behaviors
    // Describe the different actions Objects of this class can perform
    public void introduce(){
        System.out.println("Hello my name is " + this.name);
    }

    public void printOut(){
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.height);
        System.out.println(this.weight);
        System.out.println(this.isMarried);
    }
}
