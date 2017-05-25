package com.alekseyorlov.datastructures.stack;

import com.alekseyorlov.datastructures.stack.exception.StackEmptyException;

public class LinkedListStack<T> implements Stack<T> {

	private class Node {
		private T item;
		private Node previous;
		public T getItem() {
			return item;
		}
		public void setItem(T item) {
			this.item = item;
		}
		public Node getPrevious() {
			return previous;
		}
		public void setPrevious(Node previous) {
			this.previous = previous;
		}
		
	}
	
	private Node node = new Node();

	@Override
	public T pop() throws StackEmptyException {
		T item;
		if (!empty()) {
			item = node.getItem();
			Node previousNode = node.getPrevious();
			node = previousNode;
		} else {
			throw new StackEmptyException();
		}
		
		return item;
	}

	@Override
	public T push(T item) {
		Node newNode = new Node();
		newNode.setItem(item);
		newNode.setPrevious(this.node);
		
		this.node = newNode;
		
		return item;
	}

	@Override
	public T top() throws StackEmptyException {
		T item;
		if (!empty()) {
			item = node.getItem();
		} else {
			throw new StackEmptyException();
		}
		
		return item;
	}

	@Override
	public boolean empty() {
		return node.getPrevious() == null;
	}

}
