package com.revature.controllers;

import com.revature.exceptions.UnauthenticatedException;
import com.revature.models.Post;
import com.revature.services.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    // Add on filter for username here in a minute
    @GetMapping
    public List<Post> getAll(@RequestParam(name = "username", required = false) String username){

        // If I want to filter the posts for those by a specific username we can do so by leverage the query param
        // http://localhost:8080/posts?username=bserfozo

        if (username == null){
            return postService.getAllPosts();
        }

        return postService.getAllPostsByUsername(username);

    }

    @GetMapping("{postId}")
    public Post getPostById(@PathVariable int postId){
        return postService.getPostById(postId);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post, HttpSession session){
        // Validate the user is logged in
        if (session.getAttribute("userId") == null){
            throw new UnauthenticatedException("You must be logged in to create a post!");
        }

        int userId = (int) session.getAttribute("userId");

        return postService.createPost(post, userId);
    }

    // Get my owner personal posts
//    @GetMapping("me")
//    public List<Post> getPersonalPosts(HttpSession session){
//
//    }
}
