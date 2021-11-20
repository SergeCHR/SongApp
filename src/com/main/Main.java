package com.main;

import com.interact.ConsoleMenu;
import com.store.Store;
import com.store.StoreReducer;


public class Main {
   public static void main(String[] args){
       Store store = new Store();
       StoreReducer reducer = new StoreReducer(store);
       ConsoleMenu menu = new ConsoleMenu(store, reducer);
       menu.start();
   }
}
