package com.interact;
import com.command.*;
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
        System.out.println("|" + WriteStoreToFile.NAME + " - " + WriteStoreToFile.INFO + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + WriteStoreToFile.PARAMS);
        System.out.println("|" + InitStoreFromFile.NAME + " - " + InitStoreFromFile.INFO + "\t\t\t\t\t\t\t\t\t\t\t\t\t" + InitStoreFromFile.PARAMS);
        System.out.println("|" + CreateSong.NAME + " - " + CreateSong.INFO + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + CreateSong.PARAMS);
        System.out.println("|" + CreateCollection.NAME + " - " + CreateCollection.INFO + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + CreateCollection.PARAMS);
        System.out.println("|" + CreateDisk.NAME + " - " + CreateDisk.INFO + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + CreateDisk.PARAMS);
        System.out.println("|" + ShowSongs.NAME + " - " + ShowSongs.INFO + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + ShowSongs.PARAMS);
        System.out.println("|" + ShowCollections.NAME + " - " + ShowCollections.INFO + "\t\t\t\t\t\t\t\t\t\t\t\t" + ShowCollections.PARAMS);
        System.out.println("|" + ShowDisks.NAME + " - " + ShowDisks.INFO + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + ShowDisks.PARAMS);
        System.out.println("|" + DeleteSong.NAME + " - " + DeleteSong.INFO + "\t\t\t\t\t\t\t\t\t\t\t\t" + DeleteSong.PARAMS);
        System.out.println("|" + DeleteCollection.NAME + " - " + DeleteCollection.INFO + "\t\t\t\t\t\t\t" + DeleteCollection.PARAMS);
        System.out.println("|" + DeleteDisk.NAME + " - " + DeleteDisk.INFO + "\t\t\t\t\t\t\t\t\t\t\t\t" + DeleteDisk.PARAMS);
        System.out.println("|" + DeleteSongFromCollection.NAME + " - " + DeleteSongFromCollection.INFO + "\t\t\t\t\t\t\t" + DeleteSongFromCollection.PARAMS);
        System.out.println("|" + DeleteSongFromDisk.NAME + " - " + DeleteSongFromDisk.INFO + "\t\t\t\t\t\t\t\t\t\t" + DeleteSongFromDisk.PARAMS);
        System.out.println("|" + AddSongToCollection.NAME + " - " + AddSongToCollection.INFO + "\t\t\t\t\t\t\t" + AddSongToCollection.PARAMS);
        System.out.println("|" + AddCollectionToDisk.NAME + " - " + AddCollectionToDisk.INFO + "\t\t\t\t\t\t\t" + AddCollectionToDisk.PARAMS);
        System.out.println("|" + CalculateDiskDuration.NAME + " - " + CalculateDiskDuration.INFO + "\t\t\t\t\t\t\t\t\t" + CalculateDiskDuration.PARAMS);
        System.out.println("|" + CalculateCollectionDuration.NAME + " - " + CalculateCollectionDuration.INFO + "\t\t\t\t\t\t" + CalculateCollectionDuration.PARAMS);
        System.out.println("|" + SongsByDurationRange.NAME + " - " + SongsByDurationRange.INFO + "\t\t\t" + SongsByDurationRange.PARAMS);
        System.out.println("|" + SortDiskByStyle.NAME + " - " + SortDiskByStyle.INFO + "\t\t\t\t\t\t\t\t" + SortDiskByStyle.PARAMS);
        System.out.println("|help - shows info about available commands\t\t\t\t\t\t\t\t\t\t\t\t\t|no params needed");
        System.out.println("|" + Exit.NAME + " - " + Exit.INFO + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + Exit.PARAMS);
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
            if (!reducer.getCommands().containsKey(option) && !option.equals("help")){
                System.out.println("Wrong command. Try help...");
            }
            else{
                if (!option.equals("help")){
                    for (String param: transformedOption) {
                        if (!param.equals(option))
                        {
                            List<String> transformedParam = Arrays.asList(param.split("="));
                            if (transformedParam.size()>1){
                                paramsMap.put(transformedParam.get(0), transformedParam.get(1));
                            }
                        }
                    }
                    reducer.getCommands().get(option).execute(paramsMap);
                }
                else{
                    help();
                }

            }

        }
    }

}
