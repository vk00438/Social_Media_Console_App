package com.company.model;

public interface Constants {
    String ERROR = "error: ";
    String REGEX_VIEW = "^view~(.+)";
    String DOWN_VOTED = "Down Voted!!";
    String REGEX_DOWN_VOTE = "^downvote~(.+)";
    String ERROR_LOGIN = "Need to login First before downVote command!! use login~userName";
    String REGEX_FOLLOW = "^follow~(.+)";
    String ERROR_USER_EXIST =  "User with userName %s does not exist!!";
    String REGEX_EXIT = "^exit$";
    String MSG_EXIT = "Bye!!!  See you soon! Your friends are waiting for you!!";
    String MSG_INVALID = "Command : %s is Invalid!";
    String REGEX_LOGIN = "^login~(.*)";
    String MSG_LOGIN = "User %s Logged In!!!";
    String MSG_LOGOUT = "User logged out!! login again use login~userName";
    String REGEX_NEWSFEED = "^newsfeed$";
    String REGEX_POST =  "^post~(.+)";
    String DASHED_LINE = "-----------------------------------------------------------";
    String MSG_FORMAT = "%s\n";
    String REGEX_LOGOUT = "^logout$";
    String REGEX_REPLY = "^reply~(.+)~(.+)";
    String MSG_REPLY = "Reply Added!!!!";
    String REGEX_SIGNUP = "^signup~(.+)";
    String MSG_SIGNUP = "SingUp successful!! New User added with userName %s";
    String ERROR_SIGNUP = "User with userName %s already exist!! Try again!";
    String REGEX_UPVOTE = "^upvote~(.+)";
    String MSG_UPVOTE = "UpVoted!!!";
    String POST_FORMAT = "\nPost : %s\n\nPost Id : %s \nPosted By : %s\nDate : %s\nUpvotes : %s | Downvotes : %s" +
            "\nNumber of Replies : %s\nReplyId : [%s]\n";
    String REPLY_FORMAT = "Reply : \nFrom User : %s\nComment : %s";
    String USER_FORMAT = "\nUser Full Name : %s\nTotal User Following : %s\nTotal Posts : %s\n";
    String MSG_FOLLOW = "You started Following %s !!! Stay in Touch!";
    String USER_FILE_PATH = "user_file.txt";
    String POST_FILE_PATH = "post_file.txt";
    String REPLY_FILE_PATH = "reply_file.txt";
    String REGEX_SAVE = "^save$";
    String ERROR_SAVE = "Error while saving!!";
    String REGEX_LOAD = "^load$";
    String REGEX_UNFOLLOW = "^unfollow~(.+)";
    String MSG_UNFOLLOW = "You started Unfollowing %s !!! Fuck them!";
    String REGEX_PROFILE = "^profile$";
    String REGEX_LIST_FRIENDS = "^friends$";
    String REGEX_UNPOST = "^unpost~(.+)";
    String MSG_UNPOST = "Post %s UnPosted!!!!";
}
