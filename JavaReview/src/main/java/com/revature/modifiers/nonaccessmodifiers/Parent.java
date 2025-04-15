package com.revature.modifiers.nonaccessmodifiers;

public class Parent {

    /*
    Final is a non-access modifier designed to mark things as the end
    Final variables -> Must be initialized and cannot change after initialization (constants)
    Final methods -> Cannot be overridden in child classes
    Final classes -> Cannot be extended
     */

    final int age; // This variable MUST be initialized so it asks us to give a value or use a constructor

    public Parent(int age) {
        this.age = age;
    }

    // Final methods cannot be overridden in a child class
    public final void cannotOverride(){
        System.out.println("This method cannot be overridden");
    }
}
