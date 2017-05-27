package com.alekseyorlov.datastructures.stack;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekseyorlov.datastructures.stack.exception.StackEmptyException;

public class ShadowCopyArrayStackTest {

	@Test(expected = StackEmptyException.class)
	public void testPopEmpty() {

		// given
		final Stack<Integer> stack = new ShadowCopyArrayStack<>(1);
		
		// when
		final Integer item = stack.pop();
		
		// then
		// StackEmptyException is raised
	}

	@Test
	public void testPushAndPop() {
		
		// given
		final Stack<Integer> stack = new ShadowCopyArrayStack<>(1);
		
		// when
		stack.push(15);
		stack.push(20);
		
		final Integer firstItem = stack.pop();
		final Integer secondItem = stack.pop();
		
		// then
		assertEquals(20, firstItem.intValue());
		assertEquals(15, secondItem.intValue());
	}

	@Test
	public void testEmpty() {
		
		// given
		final Stack<Integer> stack = new ShadowCopyArrayStack<>(1);
		
		// when
		final boolean isEmpty = stack.empty();
		
		// then
		assertTrue(isEmpty);
	}
	
	@Test(expected = StackEmptyException.class)
	public void testTopEmpty() {
		
		// given
		final Stack<Integer> stack = new ShadowCopyArrayStack<>(1);
		
		// when
		final Integer item = stack.top();
		
		// then
		// StackEmptyException is raised
	}
	
	@Test
	public void testTop() {
		
		// given
		final Stack<Integer> stack = new ShadowCopyArrayStack<>(1);
		stack.push(15);
		
		// when
		final Integer item = stack.top();
		
		// then
		assertEquals(15, item.intValue());
	}

}
