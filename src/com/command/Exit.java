package com.command;

import java.util.Map;

public class Exit implements Command{
    public static final String NAME = "exit";
    public static final String INFO = "exit from application";
    public static final String PARAMS = "|no params needed";
    @Override
    public void execute(Map<String, String> params) {
        System.out.println("Thanks for using this app!");
        System.exit(0);
    }
}
