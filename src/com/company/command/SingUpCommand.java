package com.company.command;

import com.company.model.Constants;
import com.company.model.Printer;
import com.company.repository.Repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SingUpCommand implements Command{
    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_SIGNUP);
    private final Repository repository;
    public SingUpCommand(Repository repository){
        this.repository = repository;
    }

    @Override
    public void execute(String commandLine) {
        try{
            Matcher matcher = REGEX.matcher(commandLine);
            if(matcher.find()) {
                Printer.printMessage(repository.signUp(matcher.group(1)));
            }
        }catch (Exception ex){
            Printer.printMessage(Constants.ERROR+ex.getMessage());
        }

    }

    @Override
    public boolean match(String commandLine) {
        return REGEX.matcher(commandLine).find();
    }
}
