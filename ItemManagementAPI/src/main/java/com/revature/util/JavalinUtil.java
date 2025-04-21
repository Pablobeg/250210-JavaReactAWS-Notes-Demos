package com.revature.util;

import com.revature.controllers.ItemController;
import com.revature.daos.ItemDAO;
import com.revature.daos.ItemDAOImpl;
import com.revature.services.ItemService;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinUtil {

    // This class is in charge of setting up my objects and preparing my API

    public static Javalin create(int port){
        // Let's set up our objects and do our dependency injection
        ItemDAO itemDAO = new ItemDAOImpl();
        ItemService itemService = new ItemService(itemDAO);
        ItemController itemController = new ItemController(itemService);

        return Javalin.create(config -> {
                    // The config object allows me more control over my Javalin server so I can define things like
                    // groups of routes
                    config.router.apiBuilder(() -> {
                       path("/items", () -> {
                           post(itemController::createItemHandler);
                           get(itemController::getAllHandler);
                           get("/{itemId}", itemController::getOneHandler);
                       });
                    });
                })
//                .get("/items", ctx -> itemController.getAllHandler(ctx))
//                .get("/items", itemController::getAllHandler)
//                .get("/items/{itemId}", itemController::getOneHandler)
//                .post("/items", itemController::createItemHandler)
                .start(port);
    }
}
