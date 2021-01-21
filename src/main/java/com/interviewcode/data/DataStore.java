package com.interviewcode.data;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * DataStore class that provides access to user data.
 * Pretend this class accesses a database.
 */
public class DataStore {
	private List<Person> persons = new ArrayList<>();

	public DataStore() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String currentDir = System.getProperty("user.dir");
			this.persons = Arrays.asList(mapper.readValue(new File(currentDir + "/families.json"), Person[].class));
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Person getPersonByName(String name) {
		return this.persons.stream().filter(person -> person.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

	public String[] getPersonChildren(String name) {
		return getPersonByName(name).getChildren();
	}

	public List<Person> getPersonGrandChildren(String name) {
		List<Person> grandChildren = new ArrayList<>();

		Person person = getPersonByName(name);
		if (null != person) {
			for (String child : person.getChildren()) {
				grandChildren.add(getPersonByName(child));
			}
		}
		return grandChildren;
	}

	public String[] getSpouseChildren(String name) {
		String spouseName = getPersonByName(name).getSpouse();
		return getPersonByName(spouseName).getChildren();
	}
}