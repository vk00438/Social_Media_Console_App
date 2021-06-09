package com.company.command;

import com.company.model.Constants;
import com.company.model.Printer;
import com.company.model.User;
import com.company.repository.Repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FollowCommand implements Command{
    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_FOLLOW);
    private final Repository repository;
    private final Printer printer;

    public FollowCommand(Repository repository){
        this.repository=repository;
        this.printer = new Printer();
    }

    @Override
    public void execute(String commandLine) {
        User currentUser = repository.getCurrentUser();
        if(currentUser!=null){
            Matcher matcher = REGEX.matcher(commandLine);
            if(matcher.find()){
                String userName = matcher.group(1);
                if(repository.userInRepository(userName)){
                    currentUser.addFollowing(userName);
                    printer.addLineInMessage(String.format(Constants.MSG_FOLLOW,userName));
                }else{
                    printer.addLineInMessage(String.format(Constants.ERROR_USER_EXIST,userName));
                }
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
