package com.company.command;

import com.company.model.*;
import com.company.repository.Repository;

import java.io.*;
import java.util.Map;
import java.util.regex.Pattern;

public class LoadSessionCommand implements Command{
    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_LOAD);
    private final Repository repository;
    private final Printer printer;

    public LoadSessionCommand(Repository repository){
        this.repository=repository;
        this.printer = new Printer();
    }

    @Override
    public void execute(String commandLine) {
        try{
            File userFile = new File(Constants.USER_FILE_PATH);
            File postFile = new File(Constants.POST_FILE_PATH);
            File replyFile = new File(Constants.REPLY_FILE_PATH);
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(userFile));
            repository.setUserMap((Map<String, User>) reader.readObject());
            reader = new ObjectInputStream(new FileInputStream(postFile));
            repository.setPostMap((Map<String, Post>) reader.readObject());
            reader = new ObjectInputStream(new FileInputStream(replyFile));
            repository.setReplyMap((Map<String, Reply>) reader.readObject());
        }catch (Exception ex){
            System.out.println(Constants.ERROR_SAVE);
        }
    }

    @Override
    public boolean match(String commandLine) {
        return REGEX.matcher(commandLine).find();
    }
}
