package com.familytree.service;

import com.familytree.data.DataStore;
import com.familytree.data.Person;

public class FamilyServiceImpl implements FamilyService {
    private DataStore ds;

    public FamilyServiceImpl(DataStore ds) {
        this.ds = ds;
    }

    @Override
    public void getDescendants(String personName) {
 
    }

    private boolean hasChildren(Person person) {
        return null != person.getChildren() &&  person.getChildren().length > 0;
    }
}
