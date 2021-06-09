package com.company.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Post implements Serializable {

    private String postId;
    private final String userId;
    private final String postMessage;
    private final long publishTime;
    private final List<String> replyComments = new ArrayList<>();
    private int upVote;
    private int downVote;

    public Post(String userId,String postMessage){
        this.publishTime = Instant.now().toEpochMilli();
        this.postId = UUID.randomUUID().toString();
        this.userId = userId;
        this.postMessage = postMessage;
        this.upVote = 0;
        this.downVote = 0;
    }

    public List<String> getReplyComments() {
        return replyComments;
    }

    public long getRFM(){
        long time = Instant.now().toEpochMilli();
        return (long)(upVote+downVote)*100+(long)replyComments.size()*10+Math.abs(time-publishTime);
    }
    public void addReplyIdInPost(String replyId){
        replyComments.add(replyId);
    }

    @Override
    public String toString() {
        return Constants.DASHED_LINE+String.format(Constants.POST_FORMAT,
                postMessage,postId,userId,publishTime,upVote,downVote,replyComments.size(),replyComments.toString())
                +Constants.DASHED_LINE;
    }

    public void upVote(){
        upVote++;
    }

    public void downVote(){
        downVote--;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }


}
