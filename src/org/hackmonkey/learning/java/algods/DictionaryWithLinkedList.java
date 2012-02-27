package org.hackmonkey.learning.java.algods;

public class DictionaryWithLinkedList<k,v> implements IDictionary<k,v> {

	private class KeyValuePair<T,U>{
		T pairKey;
		U pairValue;
		
		public KeyValuePair(T key,U value){
			pairKey = key;
			pairValue = value;
		}
		
		public T getKey(){
			return pairKey;
		}
		
		public U getValue(){
			return pairValue;
		}

		public void setKey(T key){
			pairKey = key;
		}
		
		public void setValue(U value){
			pairValue = value;
		}
	}
	
	protected LinkedListNode<KeyValuePair<k,v>> head;
	
	public DictionaryWithLinkedList() {
		head = null;
	}
	
	protected LinkedListNode<KeyValuePair<k,v>> getNodePriorTo(k key){
		LinkedListNode<KeyValuePair<k,v>> cur = head;
		while(cur != null){
			if(key.equals(cur.getNextNode().getValue().getKey())){
				return cur;
			}
			cur = cur.getNextNode();
			if(cur == head)
			{
				cur = null;
			}
		}
		return cur;	
	}

	public LinkedListNode<KeyValuePair<k,v>> locate(k key) {
		LinkedListNode<KeyValuePair<k,v>> cur = getNodePriorTo(key);
		if(cur == null){return null;}
		return cur.getNextNode();
	}

	@Override
	public void insert(k key, v value) {
		LinkedListNode<KeyValuePair<k,v>> newNode
			= new LinkedListNode<KeyValuePair<k,v>>(new KeyValuePair<k,v>(key,value));
		if(head == null){
			head = newNode;
		}
		else{
			newNode.setNextNode(head.getNextNode());
		}
		head.setNextNode(newNode);
	}

	@Override
	public void delete(k key) {
		LinkedListNode<KeyValuePair<k,v>> preNode = getNodePriorTo(key);
		
		if(preNode == null){return;}
		
		LinkedListNode<KeyValuePair<k,v>> doomedNode = preNode.getNextNode();
		if(head == doomedNode){
			head = preNode;
		}
		
		preNode.setNextNode(doomedNode.getNextNode());
		doomedNode.setNextNode(null);

		if(head.getNextNode() == null){
			head = null;
		}
	}

	@Override
	public v find(k key) {
		LinkedListNode<KeyValuePair<k,v>> location = locate(key);
		if(location == null) { return null; }
		return location.getValue().getValue();
	}

}
