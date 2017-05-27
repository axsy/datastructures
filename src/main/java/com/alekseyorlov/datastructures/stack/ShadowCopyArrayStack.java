package com.alekseyorlov.datastructures.stack;

import com.alekseyorlov.datastructures.stack.exception.StackEmptyException;
import com.alekseyorlov.datastructures.stack.exception.StackOverflowException;

public class ShadowCopyArrayStack<T> implements Stack<T> {

	private static final float RESIZE_THRESHOLD = 0.75f;
	private static final int SIZE_MULTIPLIER = 2;
	private T[] storage;
	
	private T[] shadowedStorage;
	
	private int storageSize;
	
	private int shadowedStorageSize;
	
	private int top;
	
	private int copyTop;
	
	@SuppressWarnings("unchecked")
	public ShadowCopyArrayStack(int storageSize) {
		this.storageSize = storageSize;
		this.storage = (T[]) new Object[storageSize];
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

	@Override
	@SuppressWarnings("unchecked")
	public void push(T item) {
		
		// Push an item
		storage[top++] = item;
		
		// Check did the storage size rich the threshold to start shadow copying and replacement of current array storage 
		if (shadowedStorage != null || top >= storageSize * RESIZE_THRESHOLD) {
			
			// If there is no shadow copy yet then it is the first copying run, create new shadow array
			if (shadowedStorage == null) {
				shadowedStorageSize = storageSize * SIZE_MULTIPLIER;
				shadowedStorage = (T[]) new Object[shadowedStorageSize];
			}
			
			// Calculate an amount of data to move
			double stepsCount = Math.ceil(1 / (1 - RESIZE_THRESHOLD));
			
			// Move data chunk
			while(stepsCount > 0 && copyTop < top) {
				shadowedStorage[copyTop] = storage[copyTop];
				
				stepsCount--;
				copyTop++;
			}
			
			// If the copying finished - replace the storage with the new one
			if (top == copyTop) {
				
				// Make shadow array as primary stack storage
				storage = shadowedStorage;
				storageSize = shadowedStorageSize;
				
				// Reset shadow copying state
				shadowedStorage = null;
				copyTop = 0;
			}
		}
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

}
