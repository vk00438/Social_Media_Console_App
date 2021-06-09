package com.company.command;

import com.company.model.Constants;
import com.company.model.Printer;
import com.company.model.User;
import com.company.repository.Repository;

import java.util.regex.Pattern;

public class ListFriendsCommand implements Command{

    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_LIST_FRIENDS);
    private final Repository repository;
    private final Printer printer;

    public ListFriendsCommand(Repository repository){
        this.repository=repository;
        this.printer = new Printer();
    }

    @Override
    public void execute(String commandLine) {
        User currentUser = repository.getCurrentUser();
        if(currentUser!=null){
            for(String user : currentUser.getFollowingUsers()){
                printer.addLineInMessage(user);
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
