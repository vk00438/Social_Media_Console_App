package com.company.command;

import com.company.model.Constants;
import com.company.model.Post;
import com.company.model.Printer;
import com.company.model.User;
import com.company.repository.Repository;

import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WallFeedCommand implements Command{
    private static final Pattern REGEX = Pattern.compile("wallfeed");
    private final Repository repository;
    private final Printer printer;

    public WallFeedCommand(Repository repository){
        this.repository=repository;
        this.printer = new Printer();
    }

    @Override
    public void execute(String commandLine) {
        User currentUser = repository.getCurrentUser();
        if(currentUser!=null){
            List<String> postIds = currentUser.getUserPosts();
            for(String postId : postIds){
                printer.addLineInMessage(repository.getPost(postId).toString());
            }
        }else{
            printer.addLineInMessage(Constants.ERROR_LOGIN);
        }
        printer.print();
    }

    @Override
    public boolean match(String commandLine) {
        return REGEX.matcher(commandLine).find();
    }
}
