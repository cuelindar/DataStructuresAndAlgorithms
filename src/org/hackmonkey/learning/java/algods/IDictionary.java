package org.hackmonkey.learning.java.algods;

public interface IDictionary<k,v> {
	public v find(k key);
	public void insert(k key, v value);
	public void delete(k key);
}
