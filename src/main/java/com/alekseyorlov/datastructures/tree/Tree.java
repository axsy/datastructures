package com.alekseyorlov.datastructures.tree;

import com.alekseyorlov.datastructures.tree.exception.ItemNotFoundException;

public interface Tree<K,V> {

	V put(K key, V value);
	
	V get(K key) throws ItemNotFoundException;
	
	V delete(K key) throws ItemNotFoundException;
	
}
