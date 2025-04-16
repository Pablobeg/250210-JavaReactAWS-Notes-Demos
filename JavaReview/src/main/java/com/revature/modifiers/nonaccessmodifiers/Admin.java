package com.revature.modifiers.nonaccessmodifiers;

public class Admin extends Employee{
    public Admin(String name) {
        super(name);
    }
    // What is Super?
    /*
    Super is a keyword that calls different methods/constructors from the parent class

    It is implicitly ALWAYS the first line of you constructor
    Why? Because to create an Admin we really need to start with an Employee and add on anything from the Admin class

    In our constructor the `super(name)` is taking the passed in name variable and using the parent class's constructor

    We can also use super in our methods if we want to make a call to a parent class method
     */

    @Override
    public String toString() {
        String original = super.toString(); // This calls Employee's toString method
        return "Admin " + original.substring(8);
    }
}
