package com.revature.collections;

import java.util.HashSet;
import java.util.Set;

public class SetDriver {
    /*
    Set are another one of the main collections from the Collections API. It's a representation of a mathematical
    set with the following properties

    Set are (generally)
        - Unordered
        - Cannot contain duplicates
        - Dynamic in Size

    Implementing Classes:
        - HashSet (most common)
        - TreeSet
     */

    public static void main(String[] args) {
        // Let's have a list of usernames
        // We should not have the same user twice so we'll use a set

        Set<String> usersLoggedIn = new HashSet<>();

        // As users log in we'll add them to the set
        usersLoggedIn.add("jSmith"); // 3
        usersLoggedIn.add("lebronJames"); // 1
        usersLoggedIn.add("mikeJordan"); // 2

        // We can print out the items inside this list like so
        for (String username: usersLoggedIn){
            System.out.println(username);
        }

        // Why does the data print out in a different order than I put it in?
        // Sets (generally) do not preserve order so you cannot expect it to have the same order you entered in
        // How is this order determined? Hashing!
        // We take the hashcode of each object and use that as a key to sort and store the value
        // The hashing process is a one-way process that takes whatever you put in and returns a set length integer
        // The integer is then used for ordering and lookups to speed the process up immensely

        /*
        Notes about Hashing
        - Hashing is one-way meaning if I have an object and I hash it, I should not be able to get the original object
        back from the hash itself
        - Hashing should be consistent -> If I hash the same object twice I should get the same result
        - Hashing is not necessarily unique -> Two different objects might have the exact same hash but two equal
        objects should definitely have the same hash (see point 2)
         */

        // What can I use a hashset for?
        // I can check very quickly if a specific user is logged in
        System.out.println("Is mikeJordan logged in? " + usersLoggedIn.contains("mikeJordan"));

        // Also If I want to remove an object it's very quick
        usersLoggedIn.remove("jSmith");

        // Notice there is no `get` method since the set is unordered we cannot retrieve something by its index
        // What happens if I try to add a duplicate
        usersLoggedIn.add("lebronJames"); // This operation is skipped because it already container lebronJames
        // No duplicates allowed!

        // Let's print out our users again
        System.out.println("Our Users");

        // ForLoop
        for(String user: usersLoggedIn){
            System.out.println(user);
        }
    }
}
