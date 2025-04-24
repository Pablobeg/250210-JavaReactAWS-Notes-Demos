package com.revature.controllers;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.exceptions.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /*
    The purpose of this class is to centralize how our exceptions get handled, we can override this in each class but
    we want to generalize here

    This using AOP (Aspect Orient Programming) -> This is a programming paradigm that focuses on cross-cutting concerns
    Think things like security or logging

    Advice
    Pointcuts
    Before/After/Around
     */

    // This should now work for an unauthenticated exception being thrown anywhere
    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public Map<String, String> unauthenticatedExceptionHandler(UnauthenticatedException e){
        return Map.of(
                "error", e.getMessage()
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> resourceNotFoundExceptionHandler(ResourceNotFoundException e){
        return Map.of(
                "error", e.getMessage()
        );
    }
}
