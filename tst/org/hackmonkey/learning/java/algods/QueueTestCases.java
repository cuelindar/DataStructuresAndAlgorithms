package org.hackmonkey.learning.java.algods;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTestCases {
	
	protected Queue<Object> queue;

	@Before
	public void setUp() throws Exception {
		queue = new Queue<Object>();
	}

	@Test
	public void testEmptyCount(){
		assertEquals(0,queue.itemCount());
	}
	
	@Test
	public void testEnqueue() {
		queue.enqueue(new Object());
		assertEquals(0,queue.headIndex);
	}
	
	@Test
	public void testEnqueueDequeue(){
		Object in = new Object();
		queue.enqueue(in);
		Object out = queue.dequeue();
		assertSame("Dequeued item did not match enqueued item.",in,out);
	}
	
	@Test
	public void testUnderflow(){
		Object out = queue.dequeue();
		assertNull(out);
	}
	
	@Test
	public void testOverflow(){
		int initialCapacity = queue.currentCapacity;
		for(int i=0;i<initialCapacity;i++){
			queue.enqueue(new Object());
		}
		queue.enqueue(new Object());
		assertTrue(queue.currentCapacity > initialCapacity);
	}
	
	@Test
	public void testLoop(){
		int initialCapacity = queue.currentCapacity;
		Object in, out;
		for(int i=0;i<initialCapacity+2;i++){
			in = new Object();
			queue.enqueue(in);
			out = queue.dequeue();
			assertSame(String.format("Dequeued object did not match enqueued object, iteration: %d.", i), in, out);
		}
		assertEquals(initialCapacity,queue.currentCapacity);
	}

	@Test
	public void testItemCountA(){
		queue.enqueue(new Object());
		assertEquals(1,queue.itemCount());
	}

	@Test
	public void testItemCountB(){
		int initialCapacity = queue.currentCapacity;
		for(int i=0;i<initialCapacity+1;i++){
			queue.enqueue(new Object());			
		}
		assertEquals(initialCapacity+1,queue.itemCount());
	}
}
