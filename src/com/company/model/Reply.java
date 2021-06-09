package com.company.model;

import java.io.Serializable;

public class Reply implements Serializable {
    private static int count = 1;
    private final String replyId;
    private final String userId;
    private String postId;
    private final String comment;

    public Reply(String userId,String postId,String comment){
        this.replyId = Integer.toString(count++);
        this.userId = userId;
        this.postId = postId;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return String.format(Constants.REPLY_FORMAT,userId,comment);
    }

    public String getReplyId() {
        return replyId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

}
