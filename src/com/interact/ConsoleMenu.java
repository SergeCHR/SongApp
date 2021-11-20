package com.interact;
import com.constants.Constants;
import com.store.Store;
import com.store.StoreReducer;


import java.util.*;

public class ConsoleMenu {
    Store store;
    StoreReducer reducer;
    public ConsoleMenu(Store store, StoreReducer reducer){
        this.store = store;
        this.reducer = reducer;
    }
    private void showOptions(){
        Set<String> commands = reducer.getCommands().keySet();
        int i = 0;
        System.out.println("Available commands");
        System.out.println("================================================================");
        for (String command: commands) {
            System.out.print(command + ", ");
            if (i%3==2){
                System.out.println('\n');
            }
            i++;
        }
        System.out.println("\n================================================================");
        System.out.println("\n\nTry help for full command list with params");
    }
    private void help(){
        System.out.println("================================================================================================================================");
        System.out.println("Call needed command with params");
        System.out.println("================================================================================================================================");
        System.out.println("|" + Constants.WRITE_STORE + " - writes store to text file\t\t\t\t\t\t\t\t\t\t\t\t\t|no params needed");
        System.out.println("|" + Constants.INIT_STORE + " - inits store from text file\t\t\t\t\t\t\t\t\t\t\t\t\t|no params needed");
        System.out.println("|" + Constants.CREATE_SONG + " - creates songs\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|params: name, style, duration");
        System.out.println("|" + Constants.CREATE_COLLECTION + " - creates collection\t\t\t\t\t\t\t\t\t\t\t\t\t\t|params: name");
        System.out.println("|" + Constants.CREATE_DISK + " - creates disk\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|params: name");
        System.out.println("|" + Constants.SHOW_SONGS + " - shows songs created\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|no params needed");
        System.out.println("|" + Constants.SHOW_COLLECTIONS + " - shows collection created\t\t\t\t\t\t\t\t\t\t\t\t|no params needed");
        System.out.println("|" + Constants.SHOW_DISKS + " - shows disks created\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|no params needed");
        System.out.println("|" + Constants.DELETE_SONG + " - deletes song from created songs\t\t\t\t\t\t\t\t\t\t\t\t|params: name");
        System.out.println("|" + Constants.DELETE_COLLECTION + " - deletes collection from created collections\t\t\t\t\t\t\t|params: name");
        System.out.println("|" + Constants.DELETE_DISK + " - deletes disk from created disks\t\t\t\t\t\t\t\t\t\t\t\t|params: name");
        System.out.println("|" + Constants.DELETE_SONG_FROM_COLLECTION + " - deletes song from certain collection\t\t\t\t\t\t\t|params: songName collectionName");
        System.out.println("|" + Constants.DELETE_SONG_FROM_DISK + " - deletes song from certain disk\t\t\t\t\t\t\t\t\t\t|params: songName diskName");
        System.out.println("|" + Constants.SONG_TO_COLLECTION + " - adds certain song to certain collection\t\t\t\t\t\t\t\t|params: songName collectionName");
        System.out.println("|" + Constants.COLLECTION_TO_DISK + " - adds certain collection to certain disk\t\t\t\t\t\t\t\t|params: collectionName diskName");
        System.out.println("|" + Constants.CALCULATE_DISK_DURATION + " - calculates certain disk duration\t\t\t\t\t\t\t\t\t|params: diskName");
        System.out.println("|" + Constants.CALCULATE_COLLECTION_DURATION + " - calculates certain collection duration\t\t\t\t\t\t|params: collectionName");
        System.out.println("|" + Constants.SONGS_BY_DURATION_RANGE + " - shows songs that are in range from certain disk songs\t\t\t|params: diskName rangeStart rangeEnd");
        System.out.println("|" + Constants.SORT_DISK_BY_STYLE + " - sorts certain disk songs by certain style\t\t\t\t\t\t\t\t|params: diskName style");
        System.out.println("|help - shows info about available commands\t\t\t\t\t\t\t\t\t\t\t\t\t|no params needed");
        System.out.println("|" + Constants.EXIT + " - exit from application\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|no params needed");
        System.out.println("================================================================================================================================");
    }
    private String getOption(){
        Scanner in = new Scanner(System.in);
        String option = in.nextLine();
        return option;
    }
    public void start() {
        showOptions();
        while (true){
            String optionInput = getOption();
            List<String> transformedOption = Arrays.asList(optionInput.split(" "));
            String option = transformedOption.get(0);
            Map<String, String> paramsMap = new HashMap<>();
            for (String param: transformedOption) {
                if (!param.equals(option))
                {
                    List<String> transformedParam = Arrays.asList(param.split("="));
                    paramsMap.put(transformedParam.get(0), transformedParam.get(1));
                }
            }
            if (!option.equals("help")){
                if (reducer.getCommands().containsKey(option)){
                    reducer.getCommands().get(option).execute(paramsMap);
                }
                else{
                    System.out.println("Wrong command. Try help...");
                }
            }
            else{
                help();
            }

        }
    }

}
