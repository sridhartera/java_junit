package com.myproj.test;

import junit.framework.TestCase;

public class PersonTest extends TestCase {

	public void testPerson() {
		Person p1 = new Person();
		assertEquals("Sridhar", p1.getName()); //assertEquals static method
		assertEquals(2, p1.getMaxBooks());
	}

	public void testSetName() {
		Person p2 = new Person();
		p2.setName("Tera");
		assertEquals("Tera", p2.getName());
	}

	public void testSetMaxBooks() {
		Person p3 = new Person();
		p3.setMaxBooks(10);
		assertEquals(10, p3.getMaxBooks());
	}
	
	public void testToString() {
		Person p4 = new Person();
		p4.setName("Sridhar Tera");
		p4.setMaxBooks(7);
		String testString = "Sridhar Tera (7 books)";
		assertEquals(testString, p4.toString());
		
	}

}
