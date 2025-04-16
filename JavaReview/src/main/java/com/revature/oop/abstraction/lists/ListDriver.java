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
    - ArrayLists store things in an Array under the hood
    - LinkedLists store things in a series of connected nodes with values and pointers to the next node
     */

    public static void main(String[] args) {
        // Use abstraction to define my list
        CustomList<String> groceryItems = new CustomArrayList<>();

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
