package org.hackmonkey.learning.java.algods;

public class StackWithTwoQueues<T> implements IStack<T> {

	IQueue<T> leftQueue;
	IQueue<T> rightQueue;
	
	int itemCount;
	
	public StackWithTwoQueues(){
		leftQueue = new Queue<T>();
		rightQueue = new Queue<T>();
		itemCount = 0;
	}
	
	@Override
	public void push(T item) {
		if(itemCount > 0){
			rightQueue.enqueue(item);
			for(int i=0;i<leftQueue.getItemCount();i++){
				rightQueue.enqueue(leftQueue.dequeue());
			}
			for(int i=0;i<rightQueue.getItemCount();i++){
				leftQueue.enqueue(rightQueue.dequeue());
			}
		}
		else{
			leftQueue.enqueue(item);
		}
		itemCount++;
	}

	@Override
	public T pop() {
		if(itemCount == 0){
			@SuppressWarnings("unchecked")
			T ret = (T)null;
			return ret;
		}
		
		itemCount--;
		return leftQueue.dequeue();
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
