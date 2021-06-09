package com.company.command;

import com.company.model.Constants;
import com.company.model.Printer;
import com.company.model.User;
import com.company.repository.Repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnPostCommand implements Command{
    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_UNPOST);
    private final Repository repository;

    public UnPostCommand(Repository repository){
        this.repository = repository;
    }

    @Override
    public void execute(String commandLine) {
        User currentUser = repository.getCurrentUser();
        if(currentUser!=null){
            Matcher matcher = REGEX.matcher(commandLine);
            if(matcher.find()){
                String message = matcher.group(1);
                String postId = repository.addPostInRepository(message);
                currentUser.removePostIdInUser(postId);
                Printer.printMessage(String.format(Constants.MSG_UNPOST,postId));
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
