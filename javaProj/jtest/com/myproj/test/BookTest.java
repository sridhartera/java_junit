package com.myproj.test;

import junit.framework.TestCase;

public class BookTest extends TestCase {
	public void testBook() {
		Book b1 = new Book("Core Java");
		assertEquals("Core Java", b1.title);
		assertEquals("my author", b1.author);
			
	}
	public void testGetPerson() {
		Book b2 = new Book("Core Java1");
		Person p2 = new Person();
		p2.setName("frnd1");
		
		//book is loaned to this person
		b2.setPerson(p2);
		
		Person testPerson = b2.getPerson();
		String testName = testPerson.getName();
		assertEquals("frnd1", testName);
		
	}

}
