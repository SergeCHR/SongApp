package com.main;

import com.audio.collection.SongCollection;
import com.audio.collection.SongCollectionUtils;
import com.audio.song.Song;
import com.helpers.HelperFunctions;
import com.interact.ConsoleMenu;
import com.store.Store;
import com.store.StoreReducer;

import java.util.ArrayList;
import java.util.List;

public class Main {
   public static void main(String[] args){
       Store store = new Store();
       StoreReducer reducer = new StoreReducer(store);
       ConsoleMenu menu = new ConsoleMenu(store, reducer);
       menu.start();
   }
}
