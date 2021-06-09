package com.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private final String userName;
    private final List<String> followingUsers = new ArrayList<>();
    private final List<String> userPosts = new ArrayList<>();

    @Override
    public String toString() {
        return String.format(Constants.USER_FORMAT,userName,followingUsers.size(),userPosts.size());
    }

    public User(String userName){
        this.userName = userName;
    }

    public void addPostIdInUser(String postId){
        userPosts.add(postId);
    }

    public void removePostIdInUser(String postId){
        userPosts.remove(postId);
    }

    public void addFollowing(String userName){
        followingUsers.add(userName);
    }

    public void removeFollowing(String userName){
        followingUsers.remove(userName);
    }

    public String getUserName() {
        return userName;
    }

    public List<String> getFollowingUsers() {
        return followingUsers;
    }

    public List<String> getUserPosts() {
        return userPosts;
    }
}
