package com.revature.controllers;

import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UnauthenticatedException;
import com.revature.exceptions.UsernameAlreadyTakenException;
import com.revature.models.User;
import com.revature.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@Controller // Stereotype annotation that tells spring this is a Spring Bean and it is a controller class
@RequestMapping("users") // This is a parent level mapping which controls how each endpoint is defined in this class
// Everything in this class will be under http://localhost:8080/users
// Since we plan to return the regular object as the HttpResponse for all of these methods let's actually mark the
// class with @ResponseBody
//@ResponseBody
// We can abstract this further by using @RestController
@RestController // This combines both @Controller and @ResponseBody
public class UserController {

    /*
    This class is in charge of handling web traffic -> Taking in HTTP Requests and sending out responses
     */

    // Dependency Injection
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // Register
    // To register a User we should be sending a POST request since I'm trying to update the list of user resources
    @PostMapping("register") // This method will handle POST requests to http://localhost:8080/users/register
    // The user we want to register will pass their information in the form of the HTTP Body
    // Since we want to return the plain object from the method as the response body we mark this with that annotation
//    @ResponseBody
    // Instead of returning a plain user object, let's return a ResponseEntity which allows us to have more control
    // of the returned response
    public ResponseEntity<User> registerUser(@RequestBody User user){

        // From this point we can pass the information to the userService class and go from there
        User savedUser = userService.register(user);

        // If something goes wrong that means the user would not be registered so let's check for that
        if (savedUser == null){
            // We need to have some sort of message saying the user was not saved and something went wrong
            // This should return a server error in the event something goes wrong
            return ResponseEntity.internalServerError().build();
        }

        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }

    // What happens when a username is already taken?
    // We run into an issue since we can't save it and the server throws an exception
    // Let's handle that exception and pass the info onto the end user
    @ExceptionHandler(UsernameAlreadyTakenException.class)
    // We should modify the response status to not return a 200 (OK)
    @ResponseStatus(code = HttpStatus.CONFLICT) // 409
    public Map<String, String> usernameAlreadyTakenExceptionHandler(UsernameAlreadyTakenException e){
        return Map.of(
                "error", e.getMessage()
        );
    }


    // Login
    // To login we need to add in the username and password from the body of the request
    @PostMapping("login") // http://localhost:8080/users/login
//    @ResponseBody // The returned object will be our Response
    // Whenever we log in as a user we'll store some info about who is logged in inside of the session
    public ResponseEntity<User> loginHandler(@RequestBody User user, HttpSession session){
        // Attempt to login the user
        User returnedUser = userService.login(user);

        // If this is null there is some issue
        if (returnedUser == null){
            return ResponseEntity.internalServerError().build();
        }

        // If we've successfully logged in, we should store some info about the user in the server in the case they're
        // sending info to an authenticated endpoint
        session.setAttribute("userId", returnedUser.getUserId()); // Storing the userId on the backend to be used
        // for further requests

        return new ResponseEntity<>(returnedUser, HttpStatus.OK);
    }


    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> invalidCredentialsExceptionHandler(InvalidCredentialsException e){
        return Map.of(
                "error", e.getMessage()
        );
    }

    // Let's create a simple authenticated endpoint
    @PutMapping // We could add on an Id but each user should only be able to update themselves so we'll handle with
    // sessions
    public User updateUserHandler(@RequestBody User user, HttpSession session){
        // First thing we should do is make sure the user is actually authenticated (logged in)
        if (session.getAttribute("userId") == null){
            throw new UnauthenticatedException("You must be logged in to access this method!");
        }

        // Next we'll update the userId on the user object to make sure a user is only ever updating themselves
        int userId = (int) session.getAttribute("userId");

        user.setUserId(userId);

        return userService.updateUser(user);
    }

    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public Map<String, String> unauthenticatedExceptionHandler(UnauthenticatedException e){
        return Map.of(
                "error", e.getMessage()
        );
    }


}
