package com.revature.daos;

import com.revature.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDAO extends JpaRepository<Post, Integer> {

    // We want to get all of the posts by the owner's username
    List<Post> findAllByOwner_Username(String username);
    // This will search for all posts with an owner whose username field matches what we put in
    // Filtering is done on the DB side as opposed to the Java side, limiting the amount of info transported
}
