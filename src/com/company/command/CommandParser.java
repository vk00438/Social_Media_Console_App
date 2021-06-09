package com.company.command;

import com.company.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {
    private final List<Command> commandList = new ArrayList<>();
    private final Command invalidCommand;
    public CommandParser(Repository repository){
        commandList.add(new ExitCommand());
        commandList.add(new SingUpCommand(repository));
        commandList.add(new LoginCommand(repository));
        commandList.add(new LogoutCommand(repository));
        commandList.add(new PostCommand(repository));
        commandList.add(new WallFeedCommand(repository));
        commandList.add(new FollowCommand(repository));
        commandList.add(new UpvoteCommand(repository));
        commandList.add(new DownVoteCommand(repository));
        commandList.add(new ReplyCommand(repository));
        commandList.add(new NewsFeedCommand(repository));
        commandList.add(new ViewPostCommand(repository));
        commandList.add(new SaveSessionCommand(repository));
        commandList.add(new LoadSessionCommand(repository));
        commandList.add(new UnfollowCommand(repository));
        commandList.add(new UserProfileCommand(repository));
        commandList.add(new ListFriendsCommand(repository));
        commandList.add(new UnPostCommand(repository));
        invalidCommand = new InvalidCommand();
    }
    public void execute(String commandLine){
        Command command = getCommand(commandLine);
        command.execute(commandLine);
    }
    private Command getCommand(String commandLine){
        for(Command command : commandList){
            if(command.match(commandLine)){
                return command;
            }
        }
        return invalidCommand;
    }
}
