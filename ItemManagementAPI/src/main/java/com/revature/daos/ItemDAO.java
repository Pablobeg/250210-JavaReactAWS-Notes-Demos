package com.revature.daos;

import com.revature.models.Item;

import java.util.List;

public interface ItemDAO {
    /*
    The ItemDAO is an interface which outlines all of the options I want to have for interacting with the DB

    We can add on more if we want but this is a good starting point

    CRUD:
    Insert a New Item
    Get All Items
    Get a Specific Item
    Update an Item
    Delete an Item

    Why is this an interface?
    Following the DAO design pattern we typically construct an interface and provide implementation since there may be
    different ways or different types of DBs we're trying to connect to
    While I may want to be able to insert a record to both a CSV file or my SQL database the steps to do it are different
    ALSO, it makes it WAY easier when we switch to Spring
     */

    Item save(Item item);

    List<Item> getAllItems();

    Item getItemByItemId(int itemId);

    Item updateItem(Item item);

    boolean deleteItem(int itemId);
}
