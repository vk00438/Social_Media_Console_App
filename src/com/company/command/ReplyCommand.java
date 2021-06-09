package com.company.command;

import com.company.model.Constants;
import com.company.model.Printer;
import com.company.model.User;
import com.company.repository.Repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplyCommand implements Command{
    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_REPLY);
    private final Repository repository;

    public ReplyCommand(Repository repository){
        this.repository=repository;
    }

    @Override
    public void execute(String commandLine) {
        User currentUser = repository.getCurrentUser();
        if(currentUser!=null){
            Matcher matcher = REGEX.matcher(commandLine);
            if(matcher.find()){
                String postId = matcher.group(1);
                String comment = matcher.group(2);
                String replyId = repository.addReplyInRepository(currentUser.getUserName(),postId,comment);
                repository.addReplyIdInPost(postId,replyId);
                Printer.printMessage(Constants.MSG_REPLY);
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
