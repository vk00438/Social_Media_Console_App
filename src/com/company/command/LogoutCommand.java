package com.company.command;

import com.company.model.Constants;
import com.company.model.Printer;
import com.company.repository.Repository;

import java.util.regex.Pattern;

public class LogoutCommand implements Command{

    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_LOGOUT);
    private final Repository repository;

    public LogoutCommand(Repository repository){
        this.repository=repository;
    }

    @Override
    public void execute(String commandLine) {
        this.repository.setCurrentUser(null);
        Printer.printMessage(Constants.MSG_LOGOUT);
    }

    @Override
    public boolean match(String commandLine) {
        return REGEX.matcher(commandLine).find();
    }
}
