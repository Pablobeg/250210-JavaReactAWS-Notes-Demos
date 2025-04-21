package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    /*
    The ConnectionUtil is a utility class designed to be used to get the connection to the Database.

    Things we need to connect to the database using JDBC (Java Database connectivity):
    - JDBC Driver Class (pom.xml)
    - JDBC Url for locating the db
    - Username
    - Password

    Now it should be noted that connecting to a database itself is relatively costly in terms of operations so in the
    case of handling one DAO method we'd want to only have a single connection at a time

    In this case we're going to make this class a SINGLETON.
    SINGLETON: Design pattern where there is only ever ONE single instance in existence and we want to reuse it for
    any potential needs
     */

    // Private static instance of the connection
    private static Connection conn = null;

    // Private constructor
    private ConnectionUtil(){
        // Making this private means NOBODY can make an instance of this class they have to use the getInstance method
    }

    // Public static getInstance method
    public static Connection getConnection(){
        // This method will return the existing connection if it's not null and is open
        try{
            if (conn != null && !conn.isClosed()){
                return conn;
            }
        } catch (SQLException e){
            System.out.println("Could not connect to the DB");
            return null;
        }

        // Otherwise we create a new connection
        // URL SHOULD BE A JDBC URL
//        String url = "jdbc:postgresql://localhost:5432/postgres";
        String url;
        String username;
        String password;

        Properties props = new Properties();

        try {

            props.load(new FileReader("src/main/resources/application.properties"));

            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");

            conn = DriverManager.getConnection(url, username, password);
//            System.out.println("Connection Established!");
        } catch (SQLException e) {
            System.out.println("Could not connect to database!");
        } catch (FileNotFoundException e) {
            System.out.println("Could not connect to database!");
        } catch (IOException e) {
            System.out.println("Could not connect to database!");
        }

        return conn;
    }

}
