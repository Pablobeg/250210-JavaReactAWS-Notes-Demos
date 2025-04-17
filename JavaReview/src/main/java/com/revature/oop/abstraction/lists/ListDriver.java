package com.revature.oop.abstraction.lists;

public class ListDriver {
    /*
    To really hammer down the idea of interfaces abstracting implementation details away I wanted to create two
    data structures from scratch and see how they work

    List In Java -> Ordered, Contain Duplicates, Dynamic in Size
    List is an interface defining several methods for working with the list data structure
        - Get
        - Add
        - Remove
        - size

    The two major implementations of this List interface are ArrayList and LinkedList
    - ArrayLists store things in an Array (basic Java collection, fixed length, ordered, and can contain duplicates)
     under the hood
        - ArrayLists are typically faster at retrieval of information but slower at insertion/deletion
    - LinkedLists store things in a series of connected nodes with values and pointers to the next node
        - LinkedLists are typically slower at retrieval but faster at insertion/deletion
     */

    public static void main(String[] args) {
        // Use abstraction to define my list
        CustomList<String> groceryItems = new CustomArrayList<>();
        /*
        What are the <>? And what are they used for?
        Declaring Generic Types in Java
        Generics give us a way to create generalized classes for different types while still enforcing compile time
        type safety

        Generics only accept Classes so if you want to use a primitive (boolean, byte, short, int, long, float, double
        or char) you need to use the Wrapper Class. A Wrapper Class is a class that wraps around a primitive and
        allows it to be treated like an object (Boolean, Byte, Short, Integer, Long, Float, Double, Character).
        These also contain useful static methods for things like parsing or checking characteristics of primitives

        Ex: When working with a list you specify the type of items you're planning to store
         */

        // The idea is I'll be able to call the methods inside of the list and then swap implementations as I want
        groceryItems.add("Milk");
        groceryItems.add("Eggs");
        groceryItems.add("Bread");
        groceryItems.add("Cheese");

        System.out.println(groceryItems.size());

        String item = groceryItems.remove(2); // Should be bread

        System.out.println(item);

        for (int i = 0; i < groceryItems.size(); i++){
            System.out.println(groceryItems.get(i));
        }
    }
}
