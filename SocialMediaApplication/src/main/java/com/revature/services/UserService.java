package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UsernameAlreadyTakenException;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // This is a Stereotype annotation and tell spring to make this class
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /*
    Recall that the above is DEPENDENCY INJECTION. This specifically is constructor injection and is the default
    injection pattern you should use with Spring.
    Other options:
    Setter Injection
        - This is different because the object must first be created and then fields are set. This is useful for
        circular dependencies (Class A depends on Class B and Class B depends on Class A)
    Field Injection:
        - Defining a field and using @Autowired above it. NOT RECOMMENDED. You can lose track of dependencies and things
        will start to get muddled if you use this
     */

    // TODO Login
    public User login(User user){
        // Let's attempt to look up the user by their username
        // Validate credentials match up

        Optional<User> potentialUser = userDAO.findUserByUsername(user.getUsername());

        if (potentialUser.isEmpty()){
            throw new InvalidCredentialsException("Username or password incorrect!");
        }
        User returnedUser = potentialUser.get();


        if (!returnedUser.getPassword().equals(user.getPassword())){
            throw new InvalidCredentialsException("Username or password incorrect!");
        }

        return returnedUser;
    }

    // Todo Register
    public User register(User user){
        // Things we need to validate when registering
        // Validate the username is not taken
        Optional<User> potentialUser = userDAO.findUserByUsername(user.getUsername());

        // What is an Optional?
        // Optionals are a special class that wraps around other objects and allows for better null checking
        if (potentialUser.isPresent()){
            // We only enter this block if a user has been returned from the db
            // That would mean the username is already taken
            throw new UsernameAlreadyTakenException("Username: " + user.getUsername() + " has already been taken!");
        }

        // At this point the username is available

        // If there are security protocols we should follow those too (username and password meet criteria)
        if (!(validateUsername(user.getUsername()) && validatePassword(user.getPassword()))){
            throw new InvalidCredentialsException("Username must be 8 characters and alphanumeric. Password must be "
            +"at least 8 characters and contain an uppercase, lowercase and a digit.");
            // Invalid username or password
        }

        return userDAO.save(user);

    }

    // Let's create methods for validating the username and password
    public boolean validateUsername(String username){
        // This will return true if the username is valid and false otherwise
        // Let's just make sure the username is alphanumeric (letters and numbers) and is at least 8 characters

        if (username.length() < 8){
            return false;
        }

        // Iterate through the list of characters and if any character is not a letter or a number then we return false
        for (char c: username.toCharArray()){
            if (!(Character.isAlphabetic(c) || Character.isDigit(c))){
                // This only happens if a character is not a letter or a digit
                return false;
            }
        }

        return true;
    }

    // Let's create a validate password method
    public boolean validatePassword(String password){
        // Make sure the length is at least 8
        if (password.length() < 8){
            return false;
        }

        // Make sure the password contains an uppercase, lowercase, digit and has no whitespace
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasWhiteSpace = false;

        for (char c: password.toCharArray()){
            if (Character.isUpperCase(c)){
                hasUppercase =  true;
            } else if (Character.isLowerCase(c)){
                hasLowercase = true;
            } else if (Character.isDigit(c)){
                hasDigit = true;
            } else if (Character.isWhitespace(c)){
                hasWhiteSpace = true;
            }
        }

        // If any one of the value is false (or true for whitespace) the entire thing returns false
        return hasUppercase && hasLowercase && hasDigit && !hasWhiteSpace;
    }

    public User updateUser(User user){
        // We need to validate the user already exists
        Optional<User> potentialUser = userDAO.findById(user.getUserId());

        if (potentialUser.isEmpty()){
            return null;
        }
        User returnedUser = potentialUser.get();

        // Check if the new username is different, if so make sure it's available
        if (!returnedUser.getUsername().equals(user.getUsername())){
            // This means somebody is trying to update their username
            boolean isUsernameAvailable = userDAO.findUserByUsername(user.getUsername()).isEmpty();

            if (!isUsernameAvailable){
                throw new UsernameAlreadyTakenException("Username has already been taken!");
            }
        }

        // Validate username and password
        if (!(validateUsername(user.getUsername()) && validatePassword(user.getPassword()))){
            throw new InvalidCredentialsException("Username must be 8 characters and alphanumeric. Password must be "
                    +"at least 8 characters and contain an uppercase, lowercase and a digit.");
            // Invalid username or password
        }

        return userDAO.save(user);
    }
}
