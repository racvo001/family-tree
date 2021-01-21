package com.interviewcode.service;

import com.interviewcode.data.DataStore;
import com.interviewcode.data.Person;

public class FamilyServiceImpl implements FamilyService {
    private DataStore ds;

    public FamilyServiceImpl(DataStore ds) {
        this.ds = ds;
    }

    @Override
    public void getDescendants(String personName) {
        Person person = ds.getPersonByName(personName);
        String[] children = ds.getPersonChildren(personName);
        
        if (person != null  && children != null && children.length > 0) {

        }
    }

    private boolean hasChildren(Person person) {
        return null != person.getChildren() &&  person.getChildren().length > 0;
    }
}
