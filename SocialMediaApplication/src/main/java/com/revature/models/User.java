package com.revature.models;

/*
Next step in our Model Classes. We want these classes to be persisted in our SQL database so we'll leverage the JPA
annotations.
JPA?
    - Java Persistence API -> It's a list of different annotations and specifications that are used by various ORMs to
    map Java objects to SQL tables and rows.
ORM?
    - Object-Relational Mapper -> Think of this as a translator between Java Objects and Relational Database Rows
    - The default ORM for Spring Data JPA is Hibernate
    - Hibernate IMPLEMENTS the specifications from the JPA
 */

import jakarta.persistence.*;

@Entity // This marks this class as an Entity that needs to be persisted to the db (basically we need a table)
@Table(name = "users") // This provides different config information for the table being created
public class User {

    // This will be my model class
    // it is NOT a spring bean but rather a datatype that's used to hold info about the user
    // Since this class is marked as an Entity, all fields will be columns unless otherwise noted

    @Id // Marks this field as the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // This says this column will be automatically generated and we can define how to generate
    private int userId;

    @Column(nullable = false, unique = true) // Like @Table, provides config info for the column
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
