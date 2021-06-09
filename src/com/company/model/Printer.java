package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Printer {

    private List<String> message;

    public Printer(){
        this.message = new ArrayList<>();
    }

    public void addLineInMessage(String line){
        message.add(line);
    }

    public void print(){
        System.out.println(Constants.DASHED_LINE);
        for(String line : message) System.out.printf(Constants.MSG_FORMAT,line);
        System.out.println(Constants.DASHED_LINE);
        clear();
    }

    public static void printMessage(String msg){
        System.out.println(Constants.DASHED_LINE);
        System.out.printf(Constants.MSG_FORMAT,msg);
        System.out.println(Constants.DASHED_LINE);
    }
    public void clear(){
        message = new ArrayList<>();
    }
}
