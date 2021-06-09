package com.company.command;

import com.company.model.Constants;
import com.company.model.Post;
import com.company.model.Printer;
import com.company.model.User;
import com.company.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NewsFeedCommand implements Command{
    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_NEWSFEED);
    private final Repository repository;
    private final Printer printer;

    public NewsFeedCommand(Repository repository) {
        this.repository = repository;
        this.printer = new Printer();
    }

    @Override
    public void execute(String commandLine) {
        List<Post> newsfeed = new ArrayList<>();
        User user = repository.getCurrentUser();
        for(String userId : user.getFollowingUsers()){
            User follower = repository.getUser(userId);
            for(String postId :follower.getUserPosts()){
                newsfeed.add(repository.getPost(postId));
            }
        }
        newsfeed.sort((p1,p2) -> {
            if(p1.getRFM()>=p2.getRFM()) {
                return 0;
            }
            return 1;
        });
        for(int i=0;i<20&& i<newsfeed.size();i++){
            printer.addLineInMessage(newsfeed.get(i).toString());
        }
        printer.print();
    }

    @Override
    public boolean match(String commandLine) {
        return REGEX.matcher(commandLine).find();
    }
}
