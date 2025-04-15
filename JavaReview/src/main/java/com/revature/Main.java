package com.revature;

public class Main {

    /*
    What is Java and why do we want to use it?

    Java is a high-leveled language that focuses on OOP (Object-Oriented Programming) and has a variety that make
    us what to use it
    - Strongly and Statically typed
        - Strong / Weak typing
        - Static / Dynamic typing
        - Define the data type at compile time (Statically typed language) and we don't expect that datatype to change
        automatically (strong language)
    - OOP
        - OOP (Object-Oriented Programming) is a programming paradigm focused around creating classes and objects to
        represent real world things
    - Automatic memory management
        - This is another benefit of using Java, some languages you have to allocate and deallocate memory as you use
        it, Java you do not have to do this and it deallocates memory automatically through garbage collection
    - Very popular
        - Java has been released for the past 30 years, this means there are a wide variety of tutorials, libraries,
        frameworks, and support all relating to Java meaning it's a good language to get into
    - WORA (Write-Once-Run-Anywhere)
        - Any machine that can run Java will be able to run your code. This is the result of using the JVM (Java
        Virtual Machine) and the JRE (Java Runtime Environment). We can develop Java code by using the JDK (Java
        Development Kit)

     */

    public static void main(String[] args) {
        // Leverage the no-args constructor to make a blank object
        Person p1 = new Person();

        p1.printOut();
    }
}