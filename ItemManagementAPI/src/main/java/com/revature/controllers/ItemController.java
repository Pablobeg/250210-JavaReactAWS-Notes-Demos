package com.revature.controllers;

import com.revature.models.Category;
import com.revature.models.Item;
import com.revature.services.ItemService;
import io.javalin.http.Context;

public class ItemController {

    /*
    This class is in charge of receiving HTTP requests, parsing them, calling the service layer and packaging the
    response. It handles web traffic

    This class calls upon the service layer so let's add that in here
     */

    private final ItemService itemService;


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    // TODO GET ALL
    // In Javalin all of these controller methods return void and take in the Context object which is a special object
    // that represents the request and response as Javalin sees it
    // http://localhost:7070/items
    // TODO Add on functionality for filtering by category
    // http://localhost:7070/items?category=OUTDOORS
    public void getAllHandler(Context ctx){
        // Here in the Get All method there's not much we need to get from the request (for now) but we'll
        // return the items as a JSON object

        // This sets the response body of our HTTP response to the inputted object
//        ctx.json(itemService.getAll());

        // Here let's determine if the query param was filled out
        String categoryString = ctx.queryParam("category");
        if (categoryString != null){
            // We attempt to get the category value and return the result
            Category category = Category.valueOf(categoryString.toUpperCase());
            ctx.json(itemService.getAllByCategory(category));
            return;
        }

        ctx.json(itemService.getAll());
    }

    // TODO GET ONE
    // http://localhost:7070/items/{itemId}
    // This convention for naming resources comes from REST which is a series of guidelines designed to outline and
    // give guidance on how to create uniform, easy-to-use APIs
    public void getOneHandler(Context ctx){
        // We need to determine what Id they're trying to access
        // When we define this route later we'll make sure to take in a path variable

        int itemId = Integer.parseInt(ctx.pathParam("itemId"));

        Item returnedItem = itemService.getById(itemId);
        if (returnedItem == null){
            ctx.status(404);
            return;
        }

        ctx.json(returnedItem);
    }


    // TODO CREATE
    // This should go to http://localhost:7070/items but with a POST request
    public void createItemHandler(Context ctx){
        // Let's retrieve the item from the request body

        Item itemToBeAdded = ctx.bodyAsClass(Item.class);
        // This attempts to turn the JSON string in the Http Body into the Item class

        // Attempt to save
        Item savedItem = itemService.saveItem(itemToBeAdded);

        // Set the response status code and the body
        ctx.status(201); // CREATED
        ctx.json(savedItem);
    }
}
