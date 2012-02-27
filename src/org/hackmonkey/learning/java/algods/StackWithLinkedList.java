package org.hackmonkey.learning.java.algods;

public class StackWithLinkedList<T> implements IStack<T> {

	LinkedListNode<T> head;
	int itemCount;
	
	public StackWithLinkedList() {
		head = null;
		itemCount = 0;
	}

	@Override
	public void push(T item) {
		head = new LinkedListNode<T>(item,head);
		itemCount++;
	}

	@Override
	public T pop() {
		if(itemCount == 0){
			return (T)null;
		}
		
		T ret = head.getValue();
		head = head.getNextNode();
		itemCount--;
		return ret;
	}

	@Override
	public int getItemCount() {
		return itemCount;
	}

	@Override
	public int getCurrentCapacity() {
		return itemCount;
	}
}
