package com.alekseyorlov.datastructures.stack;

import com.alekseyorlov.datastructures.stack.exception.StackEmptyException;
import com.alekseyorlov.datastructures.stack.exception.StackOverflowException;

public class ArrayStack<T> implements Stack<T> {

	private T[] storage;
	private int size;
	private int top;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int size) {
		this.size = size;
		this.storage = (T[]) new Object[size];
	}

	public T pop() throws StackEmptyException {
		T result;
		if (!empty()) {
			result = this.storage[--top];
		} else {
			throw new StackEmptyException();
		}
		
		return result;
	}

	public T push(T item) throws StackOverflowException {
		T result;
		if (top < size) {
			storage[top++] = item;
			result = item;
		} else {
			throw new StackOverflowException();
		}
		
		return result;
	}

	public boolean empty() {
		return top == 0;
	}

	public T top() throws StackEmptyException{
		T result;
		if (!empty()) {
			result = storage[top - 1];
		} else {
			throw new StackEmptyException();
		}
		
		return result;
	}

	@Override
	public int size() {
		return size;
	}

}
