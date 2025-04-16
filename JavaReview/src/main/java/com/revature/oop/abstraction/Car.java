package com.revature.oop.abstraction;

public interface Car {
    /*
    This is an interface, we can define many things inside of here but we mainly define methods that are public and
    abstract

    Since the methods are abstract there is no method body right now. BUT if we ever want to call one of these abstract
    methods we'll need to define an implementation
     */

    void drive();

    public abstract void alarm();

    void consumeFuel();

    // INTERFACES CAN CONTAIN VARIABLES/ATTRIBUTES
    // Variables inside of an interface are implicitly public static and final
    public static final String example = "example";
    // TODO Review the why later
}
