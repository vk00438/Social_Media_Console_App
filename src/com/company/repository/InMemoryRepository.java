package com.company.repository;

import com.company.model.Constants;
import com.company.model.Post;
import com.company.model.Reply;
import com.company.model.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository implements Repository{

    private Map<String, User> userMap = new HashMap<>();
    private Map<String, Post> postMap = new HashMap<>();
    private Map<String, Reply> replyMap = new HashMap<>();
    private User currentUser;

    @Override
    public String signUp(String userName) {
        if(userMap.containsKey(userName)){
            return String.format(Constants.ERROR_SIGNUP,userName);
        }else{
            userMap.put(userName,new User(userName));
            return String.format(Constants.MSG_SIGNUP,userName);
        }
    }

    @Override
    public boolean userInRepository(String userName) {
        return userMap.containsKey(userName);
    }

    @Override
    public String addPostInRepository(String message) {
        Post post = new Post(currentUser.getUserName(),message);
        postMap.put(post.getPostId(),post);
        return post.getPostId();
    }

    @Override
    public String addReplyInRepository(String userName,String postId,String comment) {
        Reply reply = new Reply(userName,postId,comment);
        replyMap.put(reply.getReplyId(),reply);
        return reply.getReplyId();
    }

    @Override
    public void addReplyIdInPost(String postId, String replyId) {
        postMap.get(postId).addReplyIdInPost(replyId);
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public User getUser(String userId) {
        return userMap.get(userId);
    }

    @Override
    public void setCurrentUser(String userName) {
        this.currentUser = userMap.get(userName);
    }

    @Override
    public Post getPost(String postId) {
        return postMap.get(postId);
    }

    @Override
    public Reply getReply(String replyId) {
        return replyMap.get(replyId);
    }

    @Override
    public Map<String,User> getUserMap() {
        return userMap;
    }

    @Override
    public Map<String,Post> getPostMap() {
        return postMap;
    }

    @Override
    public Map<String,Reply> getReplyMap() {
        return replyMap;
    }

    @Override
    public void setUserMap(Map<String,User> userMap) {
        this.userMap = userMap;
    }

    @Override
    public void setPostMap(Map<String,Post> postMap) {
        this.postMap = postMap;
    }

    @Override
    public void setReplyMap(Map<String,Reply> replyMap) {
        this.replyMap = replyMap;
    }
}
