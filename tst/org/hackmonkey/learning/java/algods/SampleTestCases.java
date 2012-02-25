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
		stack.Push(in);
		assertEquals(stack.headIndex, 1);
	}
	
	@Test
	public void testPushPop() {
		Object in = new Object();
		stack.Push(in);
		Object out = stack.Pop();
		assertEquals(in, out);
	}
	
	@Test
	public void testUnderflow(){
		Object out = stack.Pop();
		assertNull(out);
	}
	
	@Test
	public void testOverflow(){
		int initialCapacity = stack.currentCapacity;
		for(int i=0;i<initialCapacity;i++){
			stack.Push(new Object());
		}
		stack.Push(new Object());
		assertEquals(stack.headIndex,initialCapacity+1);
	}

}
