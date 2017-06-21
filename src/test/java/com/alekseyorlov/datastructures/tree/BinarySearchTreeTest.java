package com.alekseyorlov.datastructures.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alekseyorlov.datastructures.tree.exception.ItemNotFoundException;

public class BinarySearchTreeTest {

	@Test(expected = ItemNotFoundException.class)
	public void testGetEmpty() {
		
		// given
		final BinarySearchTree<String> tree = new BinarySearchTree<>();
		
		// when
		tree.get(1);
		
		// then
		// ItemNotFoundException is raised
	}

	@Test
	public void testPutAndGet() {
		
		// given
		final BinarySearchTree<String> tree = new BinarySearchTree<>();
		final String firstValue = "first value";
		final String secondValue = "second value";
		final String thirdValue = "third value";
		
		tree.put(5, firstValue);
		tree.put(2, secondValue);
		tree.put(3, thirdValue);
		
		// when
		final String retrievedFirstValue = tree.get(5);
		final String retrievedSecondValue = tree.get(2);
		final String retrievedThirdValue = tree.get(3);
		
		// then
		assertEquals(firstValue, retrievedFirstValue);
		assertEquals(secondValue, retrievedSecondValue);
		assertEquals(thirdValue, retrievedThirdValue);
	}

}
