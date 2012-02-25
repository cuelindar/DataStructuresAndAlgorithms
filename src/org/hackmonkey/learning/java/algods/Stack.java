package org.hackmonkey.learning.java.algods;

// implement a stack using an array
public class Stack <T> {
	private static final int defaultInitialCapacity = 10;
	protected int headIndex;
	protected int currentCapacity;
	protected Object[] rep;
	
	public Stack(int initialCapacity){
		rep = new Object[initialCapacity];
		currentCapacity = initialCapacity;
		headIndex = 0;
	}
	
	public Stack(){
		this(defaultInitialCapacity);
	}
	
	public void Push(T item){
		// if there's room, put the item on the stack
		if(headIndex < currentCapacity-1){
			rep[headIndex++] = item;
		}
		else { // there wasn't room, so grow the array size and add it
			int newCapacity = currentCapacity + defaultInitialCapacity;
			Object newRep[] = new Object[newCapacity];
			for(int i=0;i<currentCapacity;i++){
				newRep[i] = rep[i];
			}
			rep = newRep;
			currentCapacity = newCapacity;
			Push(item);
		}		
	}
	
	public T Pop(){
		// make sure we're not going to fall off the bottom...
		if(headIndex == 0){
			return (T)null;
		}
		@SuppressWarnings("unchecked")
		T ret = (T) rep[--headIndex];
		rep[headIndex] = null;
		return ret;
	}
}