package org.hackmonkey.learning.java.algods;

public class QueueWithTwoStacks<T> implements IQueue<T> {

	IStack<T> leftStack;
	IStack<T> rightStack;
	int itemCount;
	
	public QueueWithTwoStacks() {
		leftStack = new Stack<T>();
		rightStack = new Stack<T>();
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
		if(itemCount == 0){
			leftStack.push(item);
		}
		else {
			rightStack.push(item);
			for(int i=0;i<leftStack.getItemCount();i++){
				rightStack.push(leftStack.pop());
			}
			for(int i=0;i<rightStack.getItemCount();i++){
				leftStack.push(rightStack.pop());
			}
		}
		itemCount++;
	}

	@Override
	public T dequeue() {
		itemCount--;
		return leftStack.pop();
	}

}
