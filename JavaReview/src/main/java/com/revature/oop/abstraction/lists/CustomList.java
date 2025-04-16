package com.revature.oop.abstraction.lists;

public interface CustomList<T> {
    // Inside of here I want to define all of the methods my list can do

    void add(T obj); // This adds elements to the list

    T remove(int index); // This removes the element at specific index and returns it

    int size(); // This returns the size of the list

    T get(int index); // This gets a value from the list itself
}
