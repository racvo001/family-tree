package com.familytree;
import java.util.Scanner;

import com.familytree.data.DataStore;
import com.familytree.service.FamilyService;
import com.familytree.service.FamilyServiceImpl;

/**
 * main class
 */
public class FamilyTreeApp {
    private static DataStore ds = new DataStore();
    private final static FamilyService fs = new FamilyServiceImpl(ds);

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a person's full name whose family tree to print: ");
        String personName = reader.nextLine();
        System.out.println(personName + "'s' descendants are: ");
        fs.getDescendants(personName);

        reader.close();
    }
}
