package com.revature.services;

import com.revature.daos.ItemDAO;
import com.revature.daos.ItemDAOImpl;
import com.revature.models.Category;
import com.revature.models.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemService {

    /*
     Our item service class is in charge of communicating between the Controller Layer and the DAO layer
     It performs any necessary logic that is separate from what those classes handle, you'll have a lot of validation
     logic or business logic inside of here
     */

    // Inject in an ItemDAO
    private final ItemDAO itemDAO;

    // This is using dependency injection to inject in our itemDAO, this helps makes the code more loosely coupled
    // and we can inject in Mocks for testing if needed
    public ItemService(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    // Let's create a couple of methods we might want to use
    // TODO Get all
    public List<Item> getAll(){
        return itemDAO.getAllItems();
    }

    // TODO Get one
    public Item getById(int itemId){
        // This should get the item by its id, if the id is negative we don't even need to look because we know it's not
        // there
        if (itemId < 0){
            return null;
        }
        return itemDAO.getItemByItemId(itemId);
    }

    // TODO Save item
    public Item saveItem(Item item){
        // If the quantity is 0 or less we should not add in the item
        // If the item is missing a category we'll set it as misc

        if (item.getQuantity() <= 0 || item.getName() ==  null){
            return null;
        }
        if (item.getCategory() == null){
            item.setCategory(Category.MISC);
        }

        return itemDAO.save(item);
    }

    // TODO get all by category
    public List<Item> getAllByCategory(Category category){
        // Basically in this method I want a subset of all the items
        // I could create a DAO method for this (would probably more optimal)
        // We'll stream the data

        // Streaming is a process given to us by the Stream API which is a built-in API designed to allow us to do
        // different data operations in one pass

        return itemDAO.getAllItems().stream()
                // This filter takes in a Predicate Object. Predicate is a functional interface with a method called
                // test which returns true or false
                // Notice we're using a lambda to pass the value
                .filter(item -> item.getCategory() == category) // Intermediate Operation
                .collect(Collectors.toList()); // Terminal Operation
    }
}
