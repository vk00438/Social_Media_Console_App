package com.company.command;

import com.company.model.Constants;
import com.company.model.Printer;
import com.company.repository.Repository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.regex.Pattern;

public class SaveSessionCommand implements Command{
    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_SAVE);
    private final Repository repository;
    private final Printer printer;

    public SaveSessionCommand(Repository repository){
        this.repository=repository;
        this.printer = new Printer();
    }

    @Override
    public void execute(String commandLine) {
        try{
            File userFile = new File(Constants.USER_FILE_PATH);
            File postFile = new File(Constants.POST_FILE_PATH);
            File replyFile = new File(Constants.REPLY_FILE_PATH);
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(userFile));
            writer.writeObject(repository.getUserMap());
            writer = new ObjectOutputStream(new FileOutputStream(postFile));
            writer.writeObject(repository.getPostMap());
            writer = new ObjectOutputStream(new FileOutputStream(replyFile));
            writer.writeObject(repository.getReplyMap());
        }catch (Exception ex){
            System.out.println(Constants.ERROR_SAVE);
        }

    }

    @Override
    public boolean match(String commandLine) {
        return REGEX.matcher(commandLine).find();
    }
}
