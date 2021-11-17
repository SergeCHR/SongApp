package com.interact;
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
        System.out.println(reducer.getCommands().keySet());
        System.out.println("Try help for full command list with params");
    }
    private void help(){
        System.out.println("================================================================");
        System.out.println("Call needed command with params");
        System.out.println("================================================================");
        System.out.println("|write_store\t\t\t\t\t|no params needed");
        System.out.println("|init_store\t\t\t\t\t|no params needed");
        System.out.println("|create_song\t\t\t\t\t|params: name, style, duration");
        System.out.println("|create_collection\t\t\t\t|params: name");
        System.out.println("|create_disk\t\t\t\t\t|params: name");
        System.out.println("|show_songs\t\t\t\t\t\t|no params needed");
        System.out.println("|show_collections\t\t\t\t|no params needed");
        System.out.println("|show_disks\t\t\t\t\t\t|no params needed");
        System.out.println("|delete_song\t\t\t\t\t|params: name");
        System.out.println("|delete_collection\t\t\t\t|params: name");
        System.out.println("|delete_disk\t\t\t\t\t|params: name");
        System.out.println("|delete_song_from_collection\t|params: songName collectionName");
        System.out.println("|delete_song_from_disk\t\t\t|params: songName diskName");
        System.out.println("|song_to_collection\t\t\t\t|params: songName collectionName");
        System.out.println("|collection_to_disk\t\t\t\t|params: collectionName diskName");
        System.out.println("|calculate_disk_duration\t\t|params: diskName");
        System.out.println("|calculate_collection_duration\t|params: collectionName");
        System.out.println("|sort_disk_by_style\t\t\t\t|params: diskName style");
        System.out.println("|help\t\t\t\t\t\t\t|no params needed");
        System.out.println("|exit\t\t\t\t\t\t\t|no params needed");
        System.out.println("================================================================");
    }
    private String getOption(){
        Scanner in = new Scanner(System.in);
        String option = in.nextLine();
        return option;
    }
    public void start() {
        while (true){
            showOptions();
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
                reducer.getCommands().get(option).execute(paramsMap);
            }
            else{
                help();
            }

        }
    }

}
