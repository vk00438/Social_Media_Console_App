package com.company.command;

import com.company.model.Constants;
import com.company.model.Printer;
import com.company.model.User;
import com.company.repository.Repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpvoteCommand implements Command{

    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_UPVOTE);
    private final Repository repository;

    public UpvoteCommand(Repository repository){
        this.repository=repository;
    }

    @Override
    public void execute(String commandLine) {
        User currentUser = repository.getCurrentUser();
        if(currentUser!=null){
            Matcher matcher = REGEX.matcher(commandLine);
            if(matcher.find()) {
                String postId = matcher.group(1);
                if(repository.getPost(postId)!=null) repository.getPost(postId).upVote();
                Printer.printMessage(Constants.MSG_UPVOTE);
            }

        }else{
            Printer.printMessage(Constants.ERROR_LOGIN);
        }
    }

    @Override
    public boolean match(String commandLine) {
        return REGEX.matcher(commandLine).find();
    }
}
