package com.alekseyorlov.datastructures.queue;

import com.alekseyorlov.datastructures.queue.exception.QueueEmptyException;
import com.alekseyorlov.datastructures.queue.exception.QueueOverflowException;

public class DoublyLinkedListQueue<T> implements Queue<T> {

	private class Node {
		
		T item;
		
		// points to top of the queue
		Node ahead;
		
		// points to bottom of the queue
		Node behind;
		
	}

	// this node does not keep any value but keeps references to both ends of the queue
	private Node entrypointNode = new Node();
	
	public DoublyLinkedListQueue() {
		entrypointNode = new Node();
		
		entrypointNode.ahead = entrypointNode;
		entrypointNode.behind = entrypointNode;
	}
	
	@Override
	public void enqueue(T item) throws QueueOverflowException {
		Node newNode = new Node();
		newNode.item = item;
		
		// since ahead points to the top of the queue it has a reference to a previously latest element
		newNode.ahead = entrypointNode.ahead;
		
		// endtrypointNode is a lowest node in a queue, so it is at its end
		entrypointNode.ahead = newNode;
		
		// since behind points to the bottom of the queue then previously lowest node should point to the new node
		newNode.ahead.behind = newNode;
		
		// nobody is lower then a new node, but entryPointNode references both ends of the queue
		newNode.behind = entrypointNode;
	}

	@Override
	public T dequeue() throws QueueEmptyException {
		T item;
		if (!empty()) {
			
			// since entrypointNode is on both ends of the queue, then behind points to real queue top
			Node topNode = entrypointNode.behind;
			item = topNode.item;
			
			// a node that was behind topNode is a new top of the queue and points to entrypointNode
			topNode.behind.ahead = entrypointNode;
			
			// entrypointsNode points to an element that is behind the topNode as a real top of the queue
			entrypointNode.behind = topNode.behind;
		} else {
			throw new QueueEmptyException();
		}
		
		return item;
	}

	@Override
	public boolean empty() {
		
		// a queue is empty if entrypointNode is behind entrypointNode (initial state)
		return entrypointNode.behind == entrypointNode;
	}

}
