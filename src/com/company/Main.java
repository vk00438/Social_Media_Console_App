package com.company;

import com.company.command.CommandParser;
import com.company.repository.InMemoryRepository;
import com.company.repository.Repository;

import java.util.Scanner;

public class Main {
    private static final String PREFIX = ">>> ";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Repository repository = new InMemoryRepository();
            CommandParser commandParser = new CommandParser(repository);
            String currentUser = "root";
            String[] commands ={
                    "signup~root",
                    "login~root",
                    "post~I am the root user!!!! ",
                    "logout"
            };
            for(String command : commands){
                commandParser.execute(command);
            }
            while(true){
                System.out.print(PREFIX);
                String commandLine = scanner.nextLine();
                if(commandLine.equals("")) {
                    continue;
                }
                commandParser.execute(commandLine);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
