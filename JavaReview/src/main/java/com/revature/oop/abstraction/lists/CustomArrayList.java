package com.revature.oop.abstraction.lists;

public class CustomArrayList<T> implements CustomList<T>{

    private T[] values;

    @Override
    public void add(T obj) {
        // Let's first check if values is null
        if (values == null){
            values = (T[]) new Object[1];
            // We're gonna try to play nice here and hopefully not do anything wrong with this warning
            values[0] = obj;
        } else{
            // Create a new array
            T[] temp = (T[]) new Object[values.length + 1];
            // Copy the items over
            for (int i = 0; i< values.length; i++){
                temp[i] = values[i];
            }

            // Add on the new item
            temp[temp.length - 1] = obj;

            // Set this value
            values = temp;
        }
    }

    @Override
    public T remove(int index) {
        // We need to get the item
        T item = get(index);

        // We'll create a smaller array to store the remaining items
        T[] temp = (T[]) new Object[values.length-1];

        // Copy everything over
        for (int i = 0; i < values.length; i++){
            if (i == index){
                continue;
            } else if (i < index){
                temp[i] = values[i];
            } else {
                // This is for items AFTER the removed item
                temp[i-1] = values[i];
            }
        }

        // Store it in the values variable
        values = temp;

        return item;
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public T get(int index) {
        // We need to make sure the index that is to be received is less than the length of the array

        if (index >= size()){
            // If the size is too large we throw a new IndexOutOfBoundsException
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for list of length " + size());
        }

        return values[index];
    }
}
