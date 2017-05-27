package com.alekseyorlov.datastructures.queue;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekseyorlov.datastructures.queue.exception.QueueEmptyException;
import com.alekseyorlov.datastructures.queue.exception.QueueOverflowException;

public class DoublyLinkedListQueueTest {

	@Test(expected = QueueEmptyException.class)
	public void testDequeueEmpty() {
		
		// given
		final Queue<Integer> queue = new DoublyLinkedListQueue<>();
		
		// when
		queue.dequeue();
		
		// then
		// QueueEmptyException is raised
	}

	@Test
	public void testEnqueueAndDequeue() {
		
		// given
		final Queue<Integer> queue = new DoublyLinkedListQueue<>();
		
		// when
		queue.enqueue(1);
		queue.enqueue(2);
		
		final Integer firstItem = queue.dequeue();
		final Integer secondItem = queue.dequeue();
		
		// then
		assertEquals(1, firstItem.intValue());
		assertEquals(2, secondItem.intValue());
	}
	
	@Test
	public void testQueueEmpty() {
		
		// given
		final Queue<Integer> queue = new DoublyLinkedListQueue<>();
		
		// when
		final boolean isEmpty = queue.empty();
		
		// then
		assertTrue(isEmpty);
	}

}
