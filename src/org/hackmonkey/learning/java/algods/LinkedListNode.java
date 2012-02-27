package org.hackmonkey.learning.java.algods;

public class LinkedListNode<T> {
	protected Object value;
	protected LinkedListNode<T> nextNode;
	protected LinkedListNode<T> prevNode;

	public LinkedListNode(T item, LinkedListNode<T> next, LinkedListNode<T> prev){
		value = item;
		nextNode = next;
		prevNode = prev;
	}
	
	public LinkedListNode(T item, LinkedListNode<T> next){
		this(item,next,null);
	}
	
	public LinkedListNode(T item){
		this(item,null,null);
	}
	
	public LinkedListNode(){
		this(null,null,null);
	}
	
	public T getValue(){
		@SuppressWarnings("unchecked")
		T ret = (T)value;
		return ret;
	}
	
	public void setValue(T item){
		value = item;
	}
	
	public LinkedListNode<T> getNextNode(){
		return nextNode;
	}
	
	public void setNextNode(LinkedListNode<T> next){
		nextNode = next;
	}

	public LinkedListNode<T> getPreviousNode(){
		return prevNode;
	}
	
	public void setPreviousNode(LinkedListNode<T> prev){
		prevNode = prev;
	}
}
