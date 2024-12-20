package org.example.models;

import java.util.ArrayList;
import java.util.Collections;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    //
    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            } else {
                System.out.println(item + " is already in the list.");
            }
        }
        Collections.sort(groceryList);
    }


    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (!checkItemIsInList(item)) {
                System.out.println(item + " is not in the list.");
            } else {
                groceryList.remove(item);
            }
        }
        Collections.sort(groceryList);
    }


    public static boolean checkItemIsInList(String item) {
        return groceryList.contains(item);
    }


    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Sorted Grocery List:");
        for (String item : groceryList) {
            System.out.println("- " + item);
        }
    }
}
