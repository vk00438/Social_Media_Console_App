package com.company.command;

import com.company.model.Constants;
import com.company.model.Printer;

import java.util.regex.Pattern;

public class ExitCommand implements Command{
    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_EXIT);

    @Override
    public void execute(String commandLine) {
        Printer.printMessage(Constants.MSG_EXIT);
        System.exit(0);
    }

    @Override
    public boolean match(String commandLine) {
        return REGEX.matcher(commandLine).find();
    }
}
