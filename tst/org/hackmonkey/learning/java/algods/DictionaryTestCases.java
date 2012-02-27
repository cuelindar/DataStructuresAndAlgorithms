package org.hackmonkey.learning.java.algods;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTestCases {
	DictionaryWithLinkedList<String,Object> dictionary;

	@Before
	public void setUp() throws Exception {
		dictionary = new DictionaryWithLinkedList<String,Object>();
	}

	@Test
	public void testAddElement() {
		dictionary.insert("a", new Object());
		assertNotNull(dictionary.head);
	}

	@Test
	public void testFindElementA(){
		Object in = new Object();
		dictionary.insert("a", in);
		Object out = dictionary.find("a");
		assertSame(in,out);
	}
	
	@Test
	public void testFindElementB(){
		Object inA, inB;

		inA = new Object();
		inB = new Object();

		dictionary.insert("a", inA);
		dictionary.insert("b", inB);

		Object out = dictionary.find("a");
		assertSame(inA, out);
		assertNotSame(inB, out);
	}

	@Test
	public void testFindMissingElement(){
		Object in = new Object();
		dictionary.insert("a", in);
		Object out = dictionary.find("b");
		assertNull(out);
	}
	
	@Test
	public void testRemoveElementA(){
		Object in = new Object();
		dictionary.insert("a", in);
		dictionary.delete("a");
		assertNull(dictionary.head);
	}

	@Test
	public void testRemoveElementB(){
		Object inA, inB;

		inA = new Object();
		inB = new Object();

		dictionary.insert("a", inA);
		dictionary.insert("b", inB);

		dictionary.delete("a");
		Object out = dictionary.find("b");
		assertSame(inB, out);
	}
	
	@Test
	public void testRemoveAll(){
		Object inA, inB, inC;

		inA = new Object();
		inB = new Object();
		inC = new Object();

		dictionary.insert("a", inA);
		dictionary.insert("b", inB);
		dictionary.insert("c", inC);

		dictionary.delete("a");
		dictionary.delete("b");
		dictionary.delete("c");

		assertNull(dictionary.head);
	}
}
