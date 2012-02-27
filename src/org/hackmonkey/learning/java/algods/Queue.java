package org.hackmonkey.learning.java.algods;

public class Queue <T> implements IQueue<T> {

	protected Object[] rep;
	protected int currentCapacity;
	protected final static int defaultInitialCapacity = 10;
	protected int headIndex;
	protected int tailIndex;
	
	public Queue(){
		this(defaultInitialCapacity);
	}
	
	public Queue(int initialCapacity){
		currentCapacity = initialCapacity;
		rep = new Object[currentCapacity];
		headIndex = -1;
		tailIndex = -1;
	}
	
	@Override
	public int getCurrentCapacity(){
		return currentCapacity;
	}
	
	@Override
	public int getItemCount(){
		if(headIndex == -1) {return 0;}
		if(headIndex > tailIndex){
			return headIndex - tailIndex + 1;
		}
		else if (tailIndex > headIndex){
			return headIndex - (currentCapacity - tailIndex) + 1;
		}
		return 1;
	}
	
	protected int resizeBy(int size){
		// if size is 0, there is no resize requested
		if(size == 0){return currentCapacity;}

		// calculate the resulting size requested, and the number of items already enqueued
		int newSize = currentCapacity + size;
		int itemCount = getItemCount();

		// make sure we don't select a new size too small to hold the existing items
		if(newSize < itemCount){
			newSize = itemCount;
		}

		// create the new array
		Object[] newRep = new Object[newSize];
		// if there were existing items enqueued, then copy them
		if(itemCount > 0){
			for(int i=0;i<itemCount;i++){
				newRep[i] = dequeue();
			}
		}
		
		// initialize fields to be congruent with the new array representation
		rep = newRep;
		tailIndex = 0;
		headIndex = itemCount -1;
		currentCapacity = newSize;
		
		// send back the actual capacity that we resized to
		return currentCapacity;
	}
	
	@Override
	public void enqueue(T item){
		// see if the queue is empty, if so fix up the tail
		int itemCount = getItemCount();
		if(itemCount == 0){
			tailIndex = 0;
		}

		// if we're full, increase capacity
		if(itemCount==currentCapacity){
			resizeBy(defaultInitialCapacity);
		}

		// advance the head index and...
		// check to see if we have reached the end of the array and need to loop around
		if(++headIndex == currentCapacity){
			headIndex = 0;
		}
		// put the item into the array at the next headIndex
		rep[headIndex] = item;
	}
	
	@Override
	public T dequeue(){
		// check how many items are in the queue
		int itemCount = getItemCount();
		
		// if we're already empty, return null
		if(itemCount ==0 ) {return (T)null;}
		
		// remember the item we're going to return and advance the tail index
		int itemIndex = tailIndex++;

		// if the tail runs off the end of the array, loop back
		if(tailIndex == currentCapacity){
			tailIndex = 0;
		}
		
		// if the tail runs into the head, we're now empty
		if(itemIndex == headIndex){
			headIndex = -1;
		}
		
		// get the item out of the array so we can return it
		@SuppressWarnings("unchecked")
		T ret = (T)rep[itemIndex];
		
		// get rid of our reference to the item we're returning
		rep[itemIndex] = null;

		// send the item back to the caller
		return ret;
	}
}
