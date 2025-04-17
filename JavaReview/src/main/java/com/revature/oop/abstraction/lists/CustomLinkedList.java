package com.revature.oop.abstraction.lists;

public class CustomLinkedList<T> implements CustomList<T> {

    private Node<T> head;

    private Node<T> tail;

    @Override
    public void add(T obj) {
        // If the head doesn't exist, create it
        if (head == null){
            head = new Node<>(obj);
            tail = head;
        } else{
            // Otherwise add a new node to the end of the list
            // Create a new node
            Node<T> newTail = new Node<>(obj);
            tail.setNextNode(newTail);
            tail=newTail;
        }
    }

    @Override
    public T remove(int index) {
        int size = size();
        if (index >= size){
            // If the size is too large we throw a new IndexOutOfBoundsException
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for list of length " + size());
        }

        Node<T> removedNode;

        // If we're removing the first node we need to set the next node as the head
        if (index == 0){
            removedNode = head;
            head = removedNode.getNextNode();
            return removedNode.getValue();
        }

        Node<T> currentNode = head;
        Node<T> previousNode = head;

        for (int i = 0; i < index; i++){
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        // If we're removing the last node we set the previous node as the tail
        if (!currentNode.hasNext()){
            // This means we've reached the end of the list
            tail = previousNode;
            tail.setNextNode(null);
            return currentNode.getValue();
        }

        // If the node is in the middle we need the previous and following nodes
        // 1 -> 2 -> 3 ===> 1 -> 3
        previousNode.setNextNode(currentNode.getNextNode());


        return currentNode.getValue();
    }

    @Override
    public int size() {

        int counter = 1;
        Node<T> currentNode = head;

        while(currentNode.hasNext()){
            counter++;
            currentNode = currentNode.getNextNode();
        }

        return counter;
    }

    @Override
    public T get(int index) {
        if (index >= size()){
            // If the size is too large we throw a new IndexOutOfBoundsException
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for list of length " + size());
        }

        // We need to walk along the list till we get to the right index
        Node<T> currentNode = head;

        for (int i = 0; i < index; i++){
            currentNode = currentNode.getNextNode();
        }

        return currentNode.getValue();
    }
}
