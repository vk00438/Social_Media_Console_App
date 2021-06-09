package com.company.command;

import com.company.model.Constants;
import com.company.model.Post;
import com.company.model.Printer;
import com.company.repository.Repository;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewPostCommand implements Command{

    private static final Pattern REGEX = Pattern.compile(Constants.REGEX_VIEW);
    private final Repository repository;
    private final Printer printer;

    public ViewPostCommand(Repository repository){
        this.repository = repository;
        this.printer = new Printer();
    }

    @Override
    public void execute(String commandLine) {
        try{
            Matcher matcher = REGEX.matcher(commandLine);
            if(matcher.find()) {
                String postId = matcher.group(1);
                Post post = repository.getPost(postId);
                printer.addLineInMessage(post.toString());
                List<String> replyComments = post.getReplyComments();
                for(String replyId : replyComments){
                    printer.addLineInMessage(repository.getReply(replyId).toString());
                }
                printer.print();
            }
        }catch (Exception ex){
            System.out.println(Constants.ERROR +ex.getMessage());
        }
    }

    @Override
    public boolean match(String commandLine) {
        return REGEX.matcher(commandLine).find();
    }
}
