package org.hackmonkey.learning.java.algods;

public interface IStack<T> {

	public void push(T item);

	public T pop();

	public int getItemCount();
	
	public int getCurrentCapacity();
}