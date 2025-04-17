package com.revature.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ListDriver {

    /*
    Building a list sucks

    Building your own data structures can be an interesting exploration of your time but it's not always what you
    want, so you can use the built in collections in the Java Collections Framework

    The Java Collections Framework (Collections API) is a series of interfaces and classes that represent common data
    structures that you might use while developing

    Interfaces:
    Iterable (top of hierarchy)
    Collection (Collection extends Iterable, so all collections can be iterated over)
    List, Set, Queue (These are our big three data structures in the Collections API)

    Classes:
    ArrayList (List)
    LinkedList (List, Queue)
    ArrayDeque (Queue)
    PriorityQueue (Queue)
    HashSet (Set)
    TreeSet (Set)


    Lists are your general catch-all collection in the Collections API
    Two major implementations:
        - ArrayList
        - LinkedList

    Collections are useful for a variety of things but they have several built-in methods we can use

    Properties:
        - Lists are ordered / indexable
        - Lists can contain duplicates
        - Lists are dynamic in size (all collections are but this varies from the built-in array which is fixed length)
     */

    public static void main(String[] args) {
        List<String> groceryItems = new ArrayList<>();

        // List is the INTERFACE
        // LinkedList is the IMPLEMENTING CLASS

        groceryItems.add("Milk");
        groceryItems.add("Eggs");
        groceryItems.add("Bread");
        groceryItems.add("Cheese");

        String item = groceryItems.remove(2);

        System.out.println(item);

        for(int i = 0; i < groceryItems.size(); i++){
            System.out.println(groceryItems.get(i));
        }

        // So since all collections are ITERABLE we can run enhanced for loops and the forEach method
        for (String food: groceryItems){
            System.out.println(food);
        }


    }


}
