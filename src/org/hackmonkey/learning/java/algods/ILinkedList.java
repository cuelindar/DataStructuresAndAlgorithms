package org.hackmonkey.learning.java.algods;

public interface ILinkedList<T> {

	void insert(T item);
	void insertAt(T item, int index);
	void remove();
	void removeAt(int index);
	int getSize();
	T peakAt(int index);
}
