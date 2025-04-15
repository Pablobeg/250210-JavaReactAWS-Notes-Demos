package com.revature.oop.inheritance;

public class InheritanceDriver {

    /*
    Inheritance:
    What is Inheritance?
         - Inheritance is where a class inherits the properties, methods and behaviors from some parent class /
         super class.
    How do we do inheritance in Java?
        - Extends
            - Extends is a keyword that can be used in a class and an interface. Like extends like meaning classes
            can only extend classes and interfaces can only extend interfaces
        - Implements
            - Implements is a keyword that allows you to implement an interface inside of a class. This means we need
            to provide implementations for all of our abstract methods
    Why do we want to do inheritance?
        - Share implementations between classes

    Is multiple inheritance supported in Java?
    - Not supported for classes, but you can somewhat do it using interfaces.
        - Why is this supported for interfaces but not classes?
        - Imagine we have a parent class A and a parent class B that both contain a method called C that a child class
        will have access to. If we extend both class A and B in the child class which implementation would we choose?
        Since we can't reliably decide between them every time it is not possible.
        If parent classes A and B were interfaces instead it would work because they both an abstract method C. This
        method would only require 1 implementation to satisfy both interfaces
     */

    public static void main(String[] args) {

    }
}
