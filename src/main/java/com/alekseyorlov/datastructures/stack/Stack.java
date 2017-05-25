package com.alekseyorlov.datastructures.stack;

import com.alekseyorlov.datastructures.stack.exception.StackEmptyException;
import com.alekseyorlov.datastructures.stack.exception.StackOverflowException;

public interface Stack<T> {

	T pop() throws StackEmptyException;
	
	T push(T item) throws StackOverflowException;
	
	T top() throws StackEmptyException;
	
	boolean empty();
}
