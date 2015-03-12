package com.myproj.test;

import java.util.ArrayList;

public class MyLibrary {

	 String name;
	 ArrayList<Book> books;
	 ArrayList<Person> people;

	public MyLibrary(String name) {
		this.name = name;
		books = new ArrayList<Book>();
		people = new ArrayList<Person>();
		
	}

	public String getName() {
		return name;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	public void addBook(Book b1) {
		this.books.add(b1);
		
	}

	public void removeBook(Book b1) {
		this.books.remove(b1);
		
	}
	public void addPerson(Person p1) {
		this.people.add(p1);
		
	}
	public void removePerson(Person p1) {
		this.people.remove(p1);
	}

	public boolean checkOut(Book b1, Person p1) {
		int booksOut = this.getBooksForPerson(p1).size();
		if ((b1.getPerson() == null) && (booksOut < p1.getMaxBooks())){
			b1.setPerson(p1);
			return true;				
		}
		else {
			return false;
		}
	}

	public boolean checkIn(Book b1) {
		if (b1.getPerson() != null){
			b1.setPerson(null);
			return true;
		}
		else {
			return false;
		}
	}

	public ArrayList<Book> getBooksForPerson(Person p1) {
		ArrayList<Book> result = new ArrayList<Book>();
		for (Book aBook : this.getBooks()) {
			if ((aBook.getPerson() != null) && (aBook.getPerson().getName().equals(p1.getName()))){
				result.add(aBook);
			}				
		}
		return result;
	}
	
	public String toString() {
		return this.getName() + ": " 
		+ this.getBooks().size() + "books;" 
		+ this.getPeople().size() + "people";
	}
	
	public static void main(String[] args) {
		//create a new my library
		MyLibrary testLibrary = new MyLibrary("Test Drive Library");
		
		Book b1 = new Book("book1");
		Book b2 = new Book("book2");
		
		b1.setAuthor("tera");
		b2.setAuthor("sridhar");
		
		Person p1 = new Person();
		Person p2 = new Person();
		p1.setName("jim");
		p2.setName("Sue");
		
		System.out.println("Just created new library");
		
		testLibrary.printStatus();
		System.out.println("checkout book book1 to jim");
		testLibrary.checkOut(b1, p1);
		
		System.out.println("some more stuff");
		testLibrary.checkOut(b2, p2);
		testLibrary.printStatus();
		
	}

	private void printStatus() {
		System.out.println("status report of my library");
		
	}
}
