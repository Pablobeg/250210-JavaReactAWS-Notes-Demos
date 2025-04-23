package com.revature.daos;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // This is a dependency we need Spring to manage so we mark it with a stereotype annotation
// Extending these repositories take in 2 things -> The type of data and the DATATYPE of the PRIMARY KEY
public interface UserDAO extends JpaRepository<User, Integer> {
    /*
    What exactly is a DAO?
    A DAO is a Data Access Object. It outlines the different ways we can directly access our data
    It doesn't matter what the datasource is, there should be an implementing class for any db I'm trying to access

    Common methods in this interface would be
    create /save
    getAll
    getOne/getById
    update/save
    delete

    Spring Data JPA abstracts away all of the JDBC implementation logic. This means we just need to outline the methods
    inside of this class and we should be good to go

    JpaRepository?
    This is an interface that is provided by Spring Data Jpa and give our repo interfaces access to common methods that
    might be used.

    Hierarchy
    Repository -> Top Level interface that defines a interface as a dao
    CrudRepository -> Provides basic CRUD methods for our data
    PagingAndSortingRepository -> Builds on the CrudRepository and adds in pagination(pages) and sorting
    JpaRepository -> Adds on to the PagingAndSortingRepository and adds in methods for working with batches of data

    Extending the JpaRepository gives us access to all of the methods in the hierarchy
     */

//    User save(User user);
//    List<User> findAll();
//    User getUserById(int userId);
//    User update(User user);
//    boolean deleteById(int userId);

    // We can still define other methods inside of here using the special naming conventions provided by Spring Data JPA
    Optional<User> findUserByUsername(String username);
}
