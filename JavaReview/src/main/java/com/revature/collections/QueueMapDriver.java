package com.revature.collections;

import java.util.HashMap;
import java.util.Map;

public class QueueMapDriver {
    /*
    Because of time we're going to mostly skip Queues
    A Queue is an ordered list of objects that represents a line in real-life
    FIFO (First In First Out) Data structure

    Behaves similar to a list but the order is important, so as you remove items from the queue you remove them from
    the front as opposed to the back
    Properties:
        - Ordered
        - Can contain duplicates
        - Dynamic in Size
        - FIFO

    A similar data structure is the Deque (Double-Ended Queue, pronounced "deck") which allows you to add or remove
    from both sides and it is one of the current ways to implement a Stack data structure (LIFO, Last In First Out)


    MAPS
    Maps are not technically part of the Collections API because they do not inherit from iterable or collection but
    they're typically thrown in with the Collections because it's a popular data structure.

    Maps are key value pairs used to represent different things. They're very useful for solving coding challenges
    as well as defining anything with a key-value pair

    Common Implementing Classes:
    HashMap
        - Uses a hash-set for the keys under the hood and is not thread safe
    HashTable
        - Older implementation of the hashmap and is thread safe
     */

    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();

        // To add items to the list we update it using the put method
        phoneBook.put("Bryan Serfozo", "1234567890");
        phoneBook.put("Ethan McGill", "0987654321");
        phoneBook.put("Valerie Frizzle", "2345678901");

        // I cannot iterate over the list directly but we'll see how things work in a minute
        System.out.println(phoneBook.get("Bryan Serfozo"));
        phoneBook.remove("Valerie Frizzle");

        // While you cannot directly iterate over a map you can get the key set, entry set or value set and iterate
        // over those
        for (Map.Entry<String, String> entry: phoneBook.entrySet()){
            // The entry object represents each combo of key and value
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }

        // Caesar cipher is a shuffling of letters in the alphabet

        Map<Character, Character> cipher = new HashMap<>();

        cipher.put('A', 'D');
        cipher.put('B', 'E');
        cipher.put('C', 'F');
        cipher.put('D', 'G');
        cipher.put('E', 'H');
        cipher.put('F', 'I');
        cipher.put('G', 'J');
        cipher.put('H', 'K');
        cipher.put('I', 'L');
        cipher.put('J', 'M');
        cipher.put('K', 'N');
        cipher.put('L', 'O');
        cipher.put('M', 'P');
        cipher.put('N', 'Q');
        cipher.put('O', 'R');
        cipher.put('P', 'S');
        cipher.put('Q', 'T');
        cipher.put('R', 'U');
        cipher.put('S', 'V');
        cipher.put('T', 'W');
        cipher.put('U', 'X');
        cipher.put('V', 'Y');
        cipher.put('W', 'Z');
        cipher.put('X', 'A');
        cipher.put('Y', 'B');
        cipher.put('Z', 'C');

        String toBeEncrypted = "The quick brown fox jumps over the lazy dog";
        String encrypted = "";

        for (Character c: toBeEncrypted.toUpperCase().toCharArray()){
            if (cipher.containsKey(c)){
                encrypted += cipher.get(c);
            } else {
                encrypted += c;
            }
        }

        System.out.println(toBeEncrypted);
        System.out.println(encrypted);

    }
}
