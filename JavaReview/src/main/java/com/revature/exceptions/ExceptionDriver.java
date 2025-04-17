package com.revature.exceptions;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionDriver {
    /*
    Exceptions?
    Exceptions are what occurs when you don't follow the rules that you're supposed to when programming
    These are unexpected events that Java cannot be asked to handle because it doesn't know how

    Types:
    Checked Exceptions (Compile Time Exceptions)
        - These are looked for by the compiler and are expected to be handled before the code can compile
        - Examples
            - IOException
            - FileNotFoundException
            - SQLException
    Unchecked Exceptions (Runtime Exceptions)
        - These are exceptions that can occur when running the program after it compiles successfully
        - Examples
            - ArrayIndexOutOfBoundsException
            - ArithmeticException
            - NullPointerException

    How do we handle the exception?
        - Try-Catch block
        - Throws declaration

    Common Questions about Exceptions:
    throw vs throws vs Throwable
        - `throw` is a keyword used to actually throw a new exception
        - `throws` is a keyword that gets added to a method signature to duck an exception and pass off responsibility
            to whoever calls the method to handle it
        - `Throwable` is an interface from which all throwable objects (errors and exceptions) descend from

    Can you have multiple catch blocks
        - Yes you can but they need to be in order from MOST SPECIFIC to LEAST SPECIFIC

    Is a catch block necessary
        - Not technically, we can skip it with a try-finally block but again this is kinda dangerous

    Errors Vs Exceptions
        - Errors are typically more disastrous than Exceptions:
            - StackOverflowError
            - OutOfMemoryError
        - Usually denotes that something is fundamentally wrong with how you're writing your code or you don't
        have enough resources to perform your operation
        - The major difference is that a program can be expected to recover from an exception but typically not
        an error
     */

    public static void main(String[] args) throws CustomException {
        int[] nums = {1,2,3,4,5};

        int sum = 0;
        // ArrayIndexOutOfBoundsException because I tried to access an index that doesn't exist
        // Basically this means you tried to access something that could not be accessed
        // Unchecked
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        // Checked
        try{
            // Dangerous code inside of here
            FileReader reader = new FileReader("test.txt");
            System.out.println("Everything happened fine it was able to find the file!");
        } catch (FileNotFoundException e){
            System.out.println("An issue occurred trying to find the file!");
//            e.printStackTrace();
        }

        // A try catch block is a standard way of handling dangerous code but another way to handle it is by "ducking"
        // the exception

        try{
            throwsSQLException();
        } catch(SQLException e){
            System.out.println("Caught our thrown exception");
        }

        // Dangerous code with no try-catch (DON'T DO THIS)
//        throwsCustomException();

        try{
            FileReader reader = new FileReader("test.txt");
            // Imagine I had 3 pieces of code that threw 3 different exceptions but all of them are a type of
            // io exception
            throw new CustomIOException();
        } catch (FileNotFoundException e){
            System.out.println("Do something specific for the file not found exception");
        } catch (IOException e){
            System.out.println("General exception handler for all other IO exceptions");
        } catch (Exception e){
            System.out.println("General Exception");
        }

        try{
            int x = 10;
        } finally {
            // This is technically legal but it's really strange
        }

    }

    // This method is ducking the exception by claiming the method throws the exception
    // We are passing off the responsibility of handling this to whatever method calls this function
    public static void throwsSQLException() throws SQLException{
        // All this method is going to do is throw a checked exception
        // The `throw` keyword is used to throw a new exception
        throw new SQLException("SQL Exception");
    }

    public static void throwsCustomException() throws CustomException{
        throw new CustomException("Custom Exception thrown!");
    }
}
