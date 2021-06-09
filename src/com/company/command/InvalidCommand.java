package com.company.command;

import com.company.model.Constants;
import com.company.model.Printer;

public class InvalidCommand implements Command{

    @Override
    public void execute(String commandLine) {
        Printer.printMessage(String.format(Constants.MSG_INVALID,commandLine));
    }

    @Override
    public boolean match(String commandLine) {
        return false;
    }
}
