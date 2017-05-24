package com.alekseyorlov.datastructures.stack;

import com.alekseyorlov.datastructures.exception.StackEmptyException;
import com.alekseyorlov.datastructures.exception.StackOverflowException;

public interface Stack<T> {

	T pop() throws StackEmptyException;
	
	T push(T item) throws StackOverflowException;
	
	T top() throws StackEmptyException;
	
	boolean empty();
	
	int size();
}
