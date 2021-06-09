package com.company.command;

import com.company.model.Constants;
import com.company.model.Printer;
import com.company.repository.Repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginCommand implements Command{
    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_LOGIN);
    private final Repository repository;
    private final Printer printer;

    public LoginCommand(Repository repository){
        this.repository=repository;
        this.printer = new Printer();
    }

    @Override
    public void execute(String commandLine) {
        Matcher matcher = REGEX.matcher(commandLine);
        if(matcher.find()){
            String userName = matcher.group(1);
            if(repository.userInRepository(userName)){
                repository.setCurrentUser(userName);
                printer.addLineInMessage(String.format(Constants.MSG_LOGIN,userName));
            }else{
                printer.addLineInMessage(String.format(Constants.ERROR_USER_EXIST,userName));
            }
            printer.print();
        }
    }

    @Override
    public boolean match(String commandLine) {
        return REGEX.matcher(commandLine).find();
    }
}
