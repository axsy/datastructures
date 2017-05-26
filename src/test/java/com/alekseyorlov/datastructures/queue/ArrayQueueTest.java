package com.alekseyorlov.datastructures.queue;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekseyorlov.datastructures.queue.exception.QueueEmptyException;
import com.alekseyorlov.datastructures.queue.exception.QueueOverflowException;

public class ArrayQueueTest {

	@Test(expected = QueueEmptyException.class)
	public void testDequeueEmpty() {
		
		// given
		final Queue queue = new ArrayQueue<>(2);
		
		// when
		queue.dequeue();
		
		// then
		// QueueEmptyException is raised
	}

	@Test
	public void testEnqueueAndDequeue() {
		
		// given
		final Queue<Integer> queue = new ArrayQueue<>(2);
		
		// when
		queue.enqueue(1);
		queue.enqueue(2);
		
		final Integer firstItem = queue.dequeue();
		final Integer secondItem = queue.dequeue();
		
		// then
		assertEquals(1, firstItem.intValue());
		assertEquals(2, secondItem.intValue());
	}
	
	@Test(expected = QueueOverflowException.class)
	public void testEnqueueOverflow() {
		
		// given
		final Queue<Integer> queue = new ArrayQueue<>(2);
		queue.enqueue(1);
		queue.enqueue(2);
		
		// when
		queue.enqueue(3);
		
		// then
		// QueueOverflowException is raised
	}
	
	@Test
	public void testQueueEmpty() {
		
		// given
		final Queue<Integer> queue = new ArrayQueue<>(2);
		
		// when
		final boolean isEmpty = queue.empty();
		
		// then
		assertTrue(isEmpty);
	}
}
