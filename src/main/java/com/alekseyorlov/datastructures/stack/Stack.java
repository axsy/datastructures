package com.alekseyorlov.datastructures.stack;

import exception.StackEmptyException;
import exception.StackOverflowException;

public interface Stack<T> {

	T pop() throws StackEmptyException;
	
	T push(T item) throws StackOverflowException;
	
	T top() throws StackEmptyException;
	
	boolean empty();
	
	int size();
}
