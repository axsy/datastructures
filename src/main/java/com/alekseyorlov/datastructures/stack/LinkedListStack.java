package com.alekseyorlov.datastructures.stack;

import com.alekseyorlov.datastructures.stack.exception.StackEmptyException;

public class LinkedListStack<T> implements Stack<T> {

	private class Node {
		
		T item;
		
		Node previous;
		
	}
	
	private Node node = new Node();

	@Override
	public T pop() throws StackEmptyException {
		T item;
		if (!empty()) {
			item = node.item;
			Node previousNode = node.previous;
			node = previousNode;
		} else {
			throw new StackEmptyException();
		}
		
		return item;
	}

	@Override
	public T push(T item) {
		Node newNode = new Node();
		newNode.item = item;
		newNode.previous = this.node;
		
		this.node = newNode;
		
		return item;
	}

	@Override
	public T top() throws StackEmptyException {
		T item;
		if (!empty()) {
			item = node.item;
		} else {
			throw new StackEmptyException();
		}
		
		return item;
	}

	@Override
	public boolean empty() {
		return node.previous == null;
	}

}
