package com.alekseyorlov.datastructures.stack;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekseyorlov.datastructures.stack.exception.StackEmptyException;
import com.alekseyorlov.datastructures.stack.exception.StackOverflowException;

public class ArrayStackTest {

	@Test(expected = StackEmptyException.class)
	public void testPopEmpty() {

		// given
		final Stack<Integer> stack = new ArrayStack<>(10);
		
		// when
		final Integer item = stack.pop();
		
		// then
		// StackEmptyException is raised
	}

	@Test
	public void testPushAndPop() {
		
		// given
		final Stack<Integer> stack = new ArrayStack<>(10);
		
		// when
		stack.push(15);
		stack.push(20);
		
		final Integer firstItem = stack.pop();
		final Integer secondItem = stack.pop();
		
		// then
		assertEquals(20, firstItem.intValue());
		assertEquals(15, secondItem.intValue());
	}
	
	@Test(expected = StackOverflowException.class)
	public void testPushOverflowed() {
		
		// given
		final Stack<Integer> stack = new ArrayStack<>(1);
		stack.push(15);
		
		// then
		stack.push(16);
		
		// then
		// StackOverflowException is raised 
	}

	@Test
	public void testEmpty() {
		
		// given
		final Stack<Integer> stack = new ArrayStack<>(10);
		
		// when
		final boolean isEmpty = stack.empty();
		
		// thne
		assertTrue(isEmpty);
	}
	
	@Test(expected = StackEmptyException.class)
	public void testTopEmpty() {
		// given
		final Stack<Integer> stack = new ArrayStack<>(10);
		
		// when
		final Integer item = stack.top();
		
		// then
		// StackEmptyException is raised
	}

	@Test
	public void testTop() {
		
		// given
		final Stack<Integer> stack = new ArrayStack<>(10);
		stack.push(15);
		
		// when
		final Integer item = stack.top();
		
		// then
		assertEquals(15, item.intValue());
	}

}
