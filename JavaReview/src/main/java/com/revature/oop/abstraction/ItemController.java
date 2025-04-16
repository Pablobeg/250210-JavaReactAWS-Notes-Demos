package com.revature.oop.abstraction;

public class ItemController extends RestController{
    @Override
    public void getHandler() {
        System.out.println("Got all items!");
    }
}
