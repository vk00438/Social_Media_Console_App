package com.company.repository;

import com.company.model.Post;
import com.company.model.Reply;
import com.company.model.User;

import java.util.Map;

public interface Repository {
    String signUp(String userName);
    boolean userInRepository(String userName);
    String addPostInRepository(String message);
    String addReplyInRepository(String userName,String postId,String comment);
    void addReplyIdInPost(String postId,String replyId);
    User getCurrentUser();
    User getUser(String userId);
    void setCurrentUser(String userName);
    Post getPost(String postId);
    Reply getReply(String replyId);
    Map<String, User> getUserMap();
    Map<String, Post> getPostMap();
    Map<String, Reply> getReplyMap();
    void setUserMap(Map<String, User> userMap);
    void setPostMap(Map<String, Post> postMap);
    void setReplyMap(Map<String, Reply> replyMap);
}
