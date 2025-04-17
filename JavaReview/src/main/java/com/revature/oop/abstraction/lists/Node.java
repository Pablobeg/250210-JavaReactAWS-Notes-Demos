package com.revature.oop.abstraction.lists;

public class Node<T> {

    // Actual value being stored
    private T value;

    // Pointer to next node
    private Node<T> nextNode;

    public Node(T obj){
        this.value = obj;
    }

    // We'll add in a simple method to see if a node has a next value
    public boolean hasNext(){
        return nextNode != null;
    }


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}
