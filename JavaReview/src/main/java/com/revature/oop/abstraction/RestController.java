package com.revature.oop.abstraction;

public abstract class RestController {
    // Inside of this class we have a general controller class that will have some methods inside of it
    // We can use both abstract and concrete methods in here

    public abstract void getHandler();
    // This method is marked abstract and cannot be used until an implementation is provided

    // Every method below is concrete and this will be the DEFAULT implementation
    public void postHandler(){
        System.out.println("Method not yet implemented");
    }

    public void putHandler(){
        System.out.println("Method not yet implemented");
    }

    public void deleteHandler(){
        System.out.println("Method not yet implemented");
    }
}
