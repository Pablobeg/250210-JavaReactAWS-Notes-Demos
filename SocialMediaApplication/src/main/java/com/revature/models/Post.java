package com.revature.models;
// Add in our JPA annotations

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Column(columnDefinition = "TEXT") // Default this implementation is something like varchar(255)
    private String content;

    // Used for timing of the posts
    private LocalDateTime createdAt = LocalDateTime.now();

    // This will be a reference to the User table
    // TODO Unidirectional vs Bidirectional Relationships
    @ManyToOne // Many Posts belong to One User
    @JoinColumn(name = "user_id") // This provides info for the column doing the joining
    private User owner;

    public Post() {
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
