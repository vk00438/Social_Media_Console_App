package com.company.repository;

import com.company.model.Constants;
import com.company.model.Post;
import com.company.model.Reply;
import com.company.model.User;

import java.io.*;
import java.util.Map;

public class FileMemoryRepository{

    private final File userFile;
    private final File postFile;
    private final File replyFile;

    Repository inMemoryRepository = new InMemoryRepository();

    public FileMemoryRepository() throws IOException, ClassNotFoundException {
        this.userFile = new File(Constants.USER_FILE_PATH);
        this.postFile = new File(Constants.POST_FILE_PATH);
        this.replyFile = new File(Constants.REPLY_FILE_PATH);
        loadFilesInMemory();
    }

    public void loadFilesInMemory() throws IOException, ClassNotFoundException {
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(userFile));
        inMemoryRepository.setUserMap((Map<String, User>) reader.readObject());
        reader = new ObjectInputStream(new FileInputStream(postFile));
        inMemoryRepository.setPostMap((Map<String, Post>) reader.readObject());
        reader = new ObjectInputStream(new FileInputStream(replyFile));
        inMemoryRepository.setReplyMap((Map<String, Reply>) reader.readObject());
    }

    public void dumpSessionInFiles() throws IOException {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(userFile));
        writer.writeObject(inMemoryRepository.getUserMap());
        writer = new ObjectOutputStream(new FileOutputStream(postFile));
        writer.writeObject(inMemoryRepository.getPostMap());
        writer = new ObjectOutputStream(new FileOutputStream(replyFile));
        writer.writeObject(inMemoryRepository.getReplyMap());
        writer.close();
    }
}
