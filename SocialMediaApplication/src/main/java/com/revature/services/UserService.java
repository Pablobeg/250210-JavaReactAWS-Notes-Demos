package com.revature.services;

import com.revature.daos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // Todo Register
}
