package com.myproj.test;

public class Person {
	//	fields or variables
	private String name;
	private int maxBooks;
	
	//Constructor
	public Person(){
		name = "Sridhar";
		maxBooks = 2;
	}
	//methods
	public String getName() {
		return name;
		
	}
	public void setName(String any_name) {
		name = any_name;
		
		
	}

	public int getMaxBooks() {
		return maxBooks;
	}

	public void setMaxBooks(int max_books) {
		this.maxBooks = max_books;
	}
	
	public String toString() {
		return this.getName() + " (" + this.getMaxBooks() + " books)";
	}

}
