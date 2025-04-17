package com.revature.exceptions;

public class CustomException extends Exception{
    /*
    Extending Exception creates a Checked Exception
    Extending RuntimeException create an unchecked exception
     */

    public CustomException(String message) {
        super(message);
    }
}
