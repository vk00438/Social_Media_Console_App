package com.company.command;

import com.company.model.Constants;
import com.company.model.Printer;
import com.company.model.User;
import com.company.repository.Repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DownVoteCommand implements Command{
    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_DOWN_VOTE);
    private final Repository repository;
    private final Printer printer;

    public DownVoteCommand(Repository repository){
        this.repository=repository;
        this.printer = new Printer();
    }
    @Override
    public void execute(String commandLine) {
        User currentUser = repository.getCurrentUser();
        if(currentUser!=null){
            Matcher matcher = REGEX.matcher(commandLine);
            if(matcher.find()) {
                String postId = matcher.group(1);
                if(repository.getPost(postId)!=null) repository.getPost(postId).downVote();
                // System.out.println("Down Voted");
                printer.addLineInMessage(Constants.DOWN_VOTED);
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
