package org.hackmonkey.learning.java.algods;

public class QueueWithLinkedList<T> implements IQueue<T> {

	LinkedListNode<T> head;
	LinkedListNode<T> tail;
	int itemCount;
	
	public QueueWithLinkedList(){
		head = null;
		tail = null;
		itemCount = 0;
	}
	
	@Override
	public int getCurrentCapacity() {
		return itemCount;
	}

	@Override
	public int getItemCount() {
		return itemCount;
	}

	@Override
	public void enqueue(T item) {
		head = new LinkedListNode<T>(item,head);
		if(itemCount == 0){tail = head;}
		itemCount++;
	}

	@Override
	public T dequeue() {
		if(itemCount == 0){return null;}
		
		T ret = tail.getValue();
		tail = tail.getNextNode();
		itemCount--;
		return ret;
	}

}
