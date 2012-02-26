package org.hackmonkey.learning.java.algods;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SampleTestCases {
	
	protected Stack<Object> stack;
	
	@Before
	public void setup() {
		stack = null;
		stack = new Stack<Object>();
		assertNotNull(stack);
	}

	@Test
	public void testPush() {
		Object in = new Object();
		stack.push(in);
		assertEquals(stack.headIndex, 1);
	}
	
	@Test
	public void testPushPop() {
		Object in = new Object();
		stack.push(in);
		Object out = stack.pop();
		assertEquals(in, out);
	}
	
	@Test
	public void testUnderflow(){
		Object out = stack.pop();
		assertNull(out);
	}
	
	@Test
	public void testOverflow(){
		int initialCapacity = stack.currentCapacity;
		for(int i=0;i<initialCapacity;i++){
			stack.push(new Object());
		}
		stack.push(new Object());
		assertEquals(initialCapacity+1,stack.headIndex);
		assertTrue((stack.currentCapacity>initialCapacity));
	}

}
