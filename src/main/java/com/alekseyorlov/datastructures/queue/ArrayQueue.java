package com.alekseyorlov.datastructures.queue;

import com.alekseyorlov.datastructures.queue.exception.QueueEmptyException;
import com.alekseyorlov.datastructures.queue.exception.QueueOverflowException;

public class ArrayQueue<T> implements Queue<T> {

	private T[] storage;
	
	private int size;
	
	private int capacity;
	
	// Points to the end of the queue
	private int rear;
	
	// Points to the top of the queue
	private int front;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int size) {
		this.size = size;
		
		this.storage = (T[]) new Object[this.size];
	}

	@Override
	public void enqueue(T item) throws QueueOverflowException {
		if (++capacity <= size) {
			storage[rear] = item;
			rear = (rear + 1) % size;
		} else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueEmptyException {
		T item;
		if (--capacity >= 0) {
			item = storage[front];
			front = (front + 1) % size;
		} else {
			throw new QueueEmptyException();
		}
		
		return item;
	}

	@Override
	public boolean empty() {
		return capacity == 0;
	}

}
