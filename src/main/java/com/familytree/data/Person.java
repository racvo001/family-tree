package com.familytree.data;

public class Person {
	private String name;
	private String spouse;
	private String[] children;

	public Person() {

	}
	
	public Person(String name, String spouse, String[] children) {
		this.name = name;
		this.spouse = spouse;
		this.children = children;
	}

	public String getName() {
		return this.name;
	}

	public String getSpouse() {
		return this.spouse;
	}

	public String[] getChildren() {
		return this.children;
	}
}