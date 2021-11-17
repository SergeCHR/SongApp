package com.command;

import java.util.Map;

public class Exit implements Command{
    @Override
    public void execute(Map<String, String> params) {
        System.out.println("Thanks for using this app!");
        System.exit(0);
    }
}
