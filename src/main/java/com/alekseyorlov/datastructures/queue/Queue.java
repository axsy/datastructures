package com.alekseyorlov.datastructures.queue;

import com.alekseyorlov.datastructures.queue.exception.QueueEmptyException;
import com.alekseyorlov.datastructures.queue.exception.QueueOverflowException;

public interface Queue<T> {

	void enqueue(T item) throws QueueOverflowException;
	
	T dequeue() throws QueueEmptyException;
	
	boolean empty();
	
}
