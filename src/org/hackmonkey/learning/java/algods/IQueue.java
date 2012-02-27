package org.hackmonkey.learning.java.algods;

public interface IQueue<T> {

	public int getCurrentCapacity();

	public int getItemCount();

	public void enqueue(T item);

	public T dequeue();

}