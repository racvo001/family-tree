package com.interviewcode;
import java.util.Scanner;

import com.interviewcode.data.DataStore;
import com.interviewcode.service.FamilyService;
import com.interviewcode.service.FamilyServiceImpl;

/**
 * main class
 */
public class InterviewCodeApp {
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
