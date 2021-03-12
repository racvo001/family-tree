package com.familytree.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.familytree.data.DataStore;
import com.familytree.data.Person;
import com.familytree.service.FamilyService;

public class FamilyServiceImpl implements FamilyService {
	 private DataStore ds;

    public FamilyServiceImpl(DataStore ds) {
        this.ds = ds;
    }

	@Override
	public void getDescendants(String personName) {
		
		Person p = ds.getPersonByName(personName);
		if (!hasChildren(p))
			return;
		
		String[] childrens;
		childrens = ds.getPersonChildren(personName);
		for (String s : childrens) {
			System.out.println("Child: " + s);
			
			List<Person> grandChildren = new ArrayList<>();
			grandChildren = ds.getPersonGrandChildren(s);
			for (int i = 0; i < grandChildren.size(); i++) {
				System.out.println("GrandChild: " + grandChildren.get(i).getName());
			}
			
			getDescendants(s);
		}
		
		
		
		

	}

    private boolean hasChildren(Person person) {
        return null != person.getChildren() &&  person.getChildren().length > 0;
    }
}
