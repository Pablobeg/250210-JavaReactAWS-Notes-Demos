package com.revature.services;

import com.revature.daos.PostDAO;
import com.revature.daos.UserDAO;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Post;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostDAO postDAO;

    private final UserDAO userDAO;

    @Autowired
    public PostService(PostDAO postDAO, UserDAO userDAO) {
        this.postDAO = postDAO;
        this.userDAO = userDAO;
    }


    // TODO Create a post
    public Post createPost(Post post, int userId){
        // Before creating a post we need to make sure the user was set properly so this needs to be an authenticated
        // method
        // We'll look up the user by their id to make sure everything is good
        Optional<User> potentialUser = userDAO.findById(userId);

        if (potentialUser.isEmpty()){
            return null;
        }

        // Otherwise the user exists
        // Set the owner of the post
        post.setOwner(potentialUser.get());

        return postDAO.save(post);
    }

    // TODO Get all posts
    public List<Post> getAllPosts(){
        return postDAO.findAll();
    }

    // TODO get a single post
    public Post getPostById(int postId){
        // There is a possibility that they're looking up a post whose id is not in the Database
        // If the post is not found then we'll throw an exception
        return postDAO.findById(postId).orElseThrow(() ->
                new ResourceNotFoundException("No Post found with Id: " + postId));
    }

    // TODO get all posts from a user (userId)
    public List<Post> getAllPostsByUserId(int userId){
        // We can do this is one of two ways
        // Streaming
        // Get all of the posts, stream them and filter them
        return postDAO.findAll().stream()
                .filter((post) -> {
                    return userId == post.getOwner().getUserId();
                }).toList();
        // Why might we not want to do this? We're moving a large number of posts
    }

    // Get all posts from a user by username
    public List<Post> getAllPostsByUsername(String username){
        return postDAO.findAllByOwner_Username(username);
    }

    // TODO delete posts
}
