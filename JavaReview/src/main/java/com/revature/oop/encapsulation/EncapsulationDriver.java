package com.revature.oop.encapsulation;

public class EncapsulationDriver {

    /*
    Encapsulation
    What is encapsulation?
        Pillar of OOP that helps us control access for updating our instance variables
        Bundling of data and methods into one unit to be worked with together
        Protecting your data from bad updates

    How do we do encapsulation?
        - Mark our instance fields private
        - Adding in getters and setters

    Why do we do encapsulation?
        - Protects our data from invalid or nonsensical updates
     */

    public static void main(String[] args) {
        // Let's make a sample User
        User user = new User("example@example.com", "Password123", 18);

        // Right now the fields are being created appropriately but what happens if we receive a bad update?
        // Email should be an email (contains @)
        // Password should have sufficient complexity (min 8 characters, include uppercase and lowercase)
        // Age should be greater than 0

        // RIGHT NOW what is stopping me from doing the following
//        user.email = "not-an-email";
//        user.password = "pass";
//        user.age = -37;
        // By marking these as private we have now foiled the attempts to create bad updates
        // PROBLEM: We can read the values though or update them at all

        // Solution: Add getters to retrieve the values and setters to control updates to the values

        // Retrieve them
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getAge());

        // Let's add in our setters to allow us to update the values
        user.setEmail("test@test.com");
        user.setPassword("GoodPassword");
        user.setAge(21);

        System.out.println("------------------");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getAge());

        // Let's do some bad updates
        user.setEmail("not-an-email");
        user.setPassword("pass");
        user.setAge(-37);

        System.out.println("------------------");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getAge());
    }
}
