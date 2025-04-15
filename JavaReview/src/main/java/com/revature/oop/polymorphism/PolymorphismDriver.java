package com.revature.oop.polymorphism;

public class PolymorphismDriver {
    /*
    Polymorphism

    What is Polymorphism?
    Polymorphism -> Many Forms. The idea is that we have many methods with the same name but can be used in different
    contexts based off how we call them or the arguments we pass.

    How do we do polymorphism in Java?
    - Overriding
        - Method in Parent Class with different implementation in a child class
    - Overloading
        - Methods with the same name with different types/amounts of parameters
        - EX: Constructors

    Why do we do polymorphism?
        - If we have different contexts which affect how we call the methods (different parameters available) or
        different classes available, the process of polymorphism gives us the flexibility to create methods that will
        work in all of these different scenarios


    From what class do ALL classes inherit? What methods exist in that class
        - All classes in Java inherit from the Object class. The object class contains
            - equals (comparison)
            - toString (printing attributes)
            - clone
            - hashcode
     */

    public static void main(String[] args) {

        Child1 c1 = new Child1();
        c1.overrideMe();

        Child2 c2 = new Child2();
        c2.overrideMe();

        // We can call the overloaded constructor methods here to showcase how they work
        Person p1 = new Person();
        // This person has no fields set
        Person p2 = new Person("John Doe", 35, 'H');
        // We set every field individually
        Person p3 = new Person("Jane Doe", 32);

        // Notice we call all the methods the exact same way but provide different number/ types of parameters
        System.out.println(p1.firstInitial);
        System.out.println(p2.firstInitial);
        System.out.println(p3.firstInitial);

        // Object class methods
        Person p4 = new Person("John Doe", 35, 'H');

        // Let's print p4
        System.out.println(p4); // Printing this without overriding the toString is not the most helpful
        // Now we have updated the toString so let's check it out

        // Let's check equality
        // == vs .equals()
        // What is the difference between these two?
        // == checks the memory address of the two objects, so if they're pointing to different objects in memory
        // (even if they contain the same values) they are NOT EQUAL
        // .equals is typically used to check the equality based off values
        // in this case they need to have the same values to be equal
        System.out.println(p2 == p4); // False because they're different objects
        System.out.println(p2.equals(p4)); // True because they have the same values even if different objects
    }
}
