package com.myproj.test;

import junit.framework.TestCase;
import java.util.ArrayList;

public class MyLibraryTest extends TestCase {
	private Book b1;
	private Book b2;
	private Person p1;
	private Person p2;
	private MyLibrary ml;
	//test constructor
	public void testMyLibrary() {
		MyLibrary ml = new MyLibrary("Test");
		
		assertEquals("Test", ml.name);
		
		
		assertTrue(ml.books instanceof ArrayList);
		assertTrue(ml.people instanceof ArrayList);
				
	}
	public void Setup() {
		b1 = new Book("book1");
		b2 = new Book("book2");
		p1 = new Person();
		p2 = new Person();
		p1.setName("tera");
		p2.setName("sridhar");
		ml = new MyLibrary("Test");
			
	}
	
	public void testAddBook() {
		
		Setup();
		assertEquals(0, ml.getBooks().size());
		
		ml.addBook(b1);
		ml.addBook(b2);
		
		assertEquals(2, ml.getBooks().size());
		assertEquals(0, ml.getBooks().indexOf(b1));
		assertEquals(1, ml.getBooks().indexOf(b2));
		
		ml.removeBook(b1);
		assertEquals(1, ml.getBooks().size());
		assertEquals(0, ml.getBooks().indexOf(b2));
	}
	public void testCheckOut() {
		Setup();
		
		addItems();
		
		assertTrue("Book Did not CheckOut correctly", ml.checkOut(b1,p1));
		assertEquals("tera", b1.getPerson().getName());
		assertFalse("Book was already checked out", ml.checkOut(b1,p2));
		
		assertTrue("Bookcheck in failed", ml.checkIn(b1));
		assertFalse("Book was already checked in", ml.checkIn(b1));
		assertFalse("Book was never checked out", ml.checkIn(b2));
		
		
		//additional test for max books
		Setup();
		p1.setMaxBooks(1);
		addItems();
		
		assertTrue("first book did not check out", ml.checkOut(b2,p1));
		assertFalse("second book should not have checked out", ml.checkOut(b1, p1));
		
	}
	private void addItems() {
		ml.addBook(b1);
		ml.addBook(b2);
		ml.addPerson(p1);
		ml.addPerson(p2);
	}
	public void testGetBooksForPerson() {
		Setup();
		addItems();
		assertEquals(0, ml.getBooksForPerson(p1).size());
		
		ml.checkOut(b1, p1);
		
		ArrayList<Book> testBooks = ml.getBooksForPerson(p1);
		assertEquals(1, testBooks.size());
		assertEquals(0, testBooks.indexOf(b1));
		
		ml.checkOut(b2, p1);
		testBooks = ml.getBooksForPerson(p1);
		assertEquals(2, testBooks.size());
		assertEquals(1, testBooks.indexOf(b2));
		
		
	}
}
