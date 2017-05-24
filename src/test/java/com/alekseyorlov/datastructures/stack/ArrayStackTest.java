package com.alekseyorlov.datastructures.stack;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.StackEmptyException;
import exception.StackOverflowException;

public class ArrayStackTest {

	@Test(expected = StackEmptyException.class)
	public void testPopEmpty() {

		// given
		final ArrayStack<Integer> stack = new ArrayStack<>(10);
		
		// when
		final Integer item = stack.pop();
		
		// then
		// StackEmptyException is raised
	}

	@Test
	public void testPushAndPop() {
		
		// given
		final ArrayStack<Integer> stack = new ArrayStack<>(10);
		
		// when
		stack.push(15);
		final Integer item = stack.pop();
		
		// then
		assertEquals(15, item.intValue());
	}
	
	@Test(expected = StackOverflowException.class)
	public void testPushOverflowed() {
		
		// given
		final ArrayStack<Integer> stack = new ArrayStack<>(1);
		stack.push(15);
		
		// then
		stack.push(16);
		
		// then
		// StackOverflowException is raised 
	}

	@Test
	public void testEmpty() {
		
		// given
		final ArrayStack<Integer> stack = new ArrayStack<>(10);
		
		// when
		final boolean isEmpty = stack.empty();
		
		// thne
		assertTrue(isEmpty);
	}
	
	@Test(expected = StackEmptyException.class)
	public void testTopEmpty() {
		// given
		final ArrayStack<Integer> stack = new ArrayStack<>(10);
		
		// when
		final Integer item = stack.top();
		
		// then
		// StackEmptyException is raised
	}

	@Test
	public void testTop() {
		
		// given
		final ArrayStack<Integer> stack = new ArrayStack<>(10);
		stack.push(15);
		
		// when
		final Integer item = stack.top();
		
		// then
		assertEquals(15, item.intValue());
	}

}
