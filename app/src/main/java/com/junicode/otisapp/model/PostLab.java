package com.junicode.otisapp.model;


import java.util.ArrayList;
import java.util.List;

public class PostLab {
    private List<Post> listaPosts;

    public PostLab() {
        this.listaPosts = new ArrayList<>();
    }

    public List<Post> getPosts() {
        return listaPosts;
    }

    public void addPost(Post post) {
        this.listaPosts.add(post);
    }

    public int getLastPosition() {
        return (this.listaPosts.size() - 1); //if the result is negative, there are not elements in the list
    }
}
