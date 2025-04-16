package com.revature.oop.abstraction;

public class AbstractionDriver {
    /*
    Abstraction

    What is Abstraction?
    Hiding implementation details by using a simplified interface
    Ex: Driving a car -> You don't need to know how the engine works you know need to know that you turn the key
    and press the gas and the car drives. It doesn't matter what the underlying "implementation" of the car is (i.e
    gas powered car, diesel powered car, or electric powered car), you can drive it using the same information

    How do we do abstraction?
    - Interfaces
        - These are like contracts in Java. An interface outlines method signatures for an Implementing class. All
        methods inside of an interface are implicitly PUBLIC AND ABSTRACT.
        Abstract? This means a method body/ implementation is not currently required*
    - Abstract Classes
        - This is a class with the keyword abstract on it. It's important to note that abstract classes can contain
        both abstract and concrete methods (regular methods). Like interfaces we cannot instantiate an abstract class
        directly, we'd need an extending class to go from there. Why would I use this over an interface? If you have
        multiple classes that share an implementation you can use the abstract class to share it and still get
        the abstract functionality of an interface. When to use an interface instead? When we have multiple abstract
        constructs that we're trying to implement (can only extend one class, but can implement as many interfaces as
        we want)

    Why would we want to do abstraction?
    We want to simplify how we interact with different things. Ex: When working with a list I don't need to know all of
    the details of HOW the list is storing info I just need to know what methods are available
     */

    public static void main(String[] args) {

        // So it's important to note that we cannot instantiate an interface directly
        // We need an implementing class
//        Car car = new Car();
        // Use either tesla or jeep
        Car car = new Tesla();
        // Notice this is an interface = implementing class.
        // Why?
        // Liskov Substitution Principle
        // We can swap the implementation of a Car without affecting the method calls
        // The Car interface is using the implementation outlined in the Jeep class

        car.drive();
        car.alarm();
        car.consumeFuel();

//        UserDAO userDAO = new CSVUserDAO();
//
//        userDAO.save(u);
//        userDAO.getAll();
//        userDAO.findUserByUsername(username);

        UserController userController = new UserController();
        // Why didn't we use the interface here?
        // We definitely could but there may be additional implementation inside the UserController that
        // aren't outlined by the RestController, so we can do this if we have extra methods we want to use
        RestController restController = new UserController();

        userController.patchHandler();
//        restController.patchHandler(); because patchHandler belongs ONLY to UserController

        RestController itemController = new ItemController();

        // We can pretend HTTP requests are coming in here
        userController.getHandler();
        userController.postHandler();
        userController.deleteHandler();

        itemController.getHandler();
        itemController.postHandler();
        itemController.deleteHandler();
    }










}
