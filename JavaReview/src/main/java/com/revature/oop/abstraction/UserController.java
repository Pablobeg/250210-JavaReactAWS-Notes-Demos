package com.revature.oop.abstraction;

public class UserController extends RestController{

    // The only method(s) I HAVE TO implement are the abstract ones
    @Override
    public void getHandler() {
        System.out.println("User{name=Bryan}");
    }

    // I can still override the other methods if desired
    @Override
    public void postHandler() {
        System.out.println("New user created!");
    }

    // We'll add in a patch handler for PATCH requests
    public void patchHandler(){
        System.out.println("Method not yet implemented");
    }
}
