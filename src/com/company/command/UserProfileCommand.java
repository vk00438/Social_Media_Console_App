package com.company.command;

import com.company.model.Constants;
import com.company.model.Printer;
import com.company.model.User;
import com.company.repository.Repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserProfileCommand implements Command{

    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_PROFILE);
    private final Repository repository;
    private final Printer printer;

    public UserProfileCommand(Repository repository){
        this.repository=repository;
        this.printer = new Printer();
    }

    @Override
    public void execute(String commandLine) {
        User currentUser = repository.getCurrentUser();
        if(currentUser!=null){
            printer.addLineInMessage(currentUser.toString());
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
