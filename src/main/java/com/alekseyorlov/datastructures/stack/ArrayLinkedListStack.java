package com.alekseyorlov.datastructures.stack;

import com.alekseyorlov.datastructures.stack.exception.StackEmptyException;
import com.alekseyorlov.datastructures.stack.exception.StackOverflowException;

public class ArrayLinkedListStack<T> implements Stack<T> {

	private class Node {
		
		T[] storage;
		
		int size;
		
		int top;
		
		Node previous;

		@SuppressWarnings("unchecked")
		public Node(int size) {
			this.size = size;
			this.storage = (T[]) new Object[size];
		}
		
	}

	private int capacity;
	
	private Node node;
	
	public ArrayLinkedListStack(int capacity) {
		this.capacity = capacity;
		
		node = new Node(capacity);
	}

	@Override
	public T pop() throws StackEmptyException {
		T result;
		
		if (!empty()) {
			if (node.top == 0) {
				Node previousNode = node.previous;
				node = previousNode;
			}
			
			result = node.storage[--node.top];
		} else {
			throw new StackEmptyException();
		}
		
		return result;
	}

	@Override
	public T push(T item) throws StackOverflowException {
		T result;
		
		if (node.top == node.size) {
			Node newNode = new Node(capacity);
			newNode.previous = node;
			node = newNode;
		}
		
		node.storage[node.top++] = item;
		result = item;
		
		return result;
	}

	public T top() throws StackEmptyException{
		T result;
		if (!empty()) {
			result = node.storage[node.top - 1];
		} else {
			throw new StackEmptyException();
		}
		
		return result;
	}
	
	public boolean empty() {
		return node.top == 0 && node.previous == null;
	}
	
}
