package com.revature.models;

public class Item {
    /*
    This class is a model class. It outlines the shape of the data that we plan to work with in our application
    This can be anything we want modeled but it should match pretty close to what we see in the DB

    Possible columns in database:
    item_id
    name
    quantity
    category (enum)

    Things we need in this class:
    fields (marked private for encapsulation)
    constructors (should be sure to have a no-args one (jackson databind will want this)
    getters/setters
    toString (optional)
     */

    private int itemId;

    private String name;

    private int quantity;

    private Category category; // This will be stored as a string (for now)

    // This is going to be used by Jackson Databind so please be sure to have it
    public Item() {
    }

    public Item(String name, int quantity, Category category) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", category=" + category +
                '}';
    }
}
