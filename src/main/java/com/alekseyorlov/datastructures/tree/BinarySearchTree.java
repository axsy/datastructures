package com.alekseyorlov.datastructures.tree;

import com.alekseyorlov.datastructures.tree.exception.ItemNotFoundException;

public class BinarySearchTree<V> implements Tree<Integer, V> {

	private class Node {
	
		Object left;
		
		Object right;
		
		Integer key;
	}

	private Node root = new Node();

	@Override
	public V put(Integer key, V value) {
		V previous;
		
		if (root.left == null) {
			root.left = value;
			root.key = key;
			previous = value;
		} else {
			Node leaf = root;
			while(leaf.right != null) {
				if (key < leaf.key) {
					leaf = (Node) leaf.left;
				} else {
					leaf = (Node) leaf.right;
				}
			}
			
			previous = (V) leaf.left;
			
			Node oldNode = new Node();
			oldNode.left = leaf.left;
			oldNode.key = leaf.key;
			
			Node newNode = new Node();
			newNode.left = value;
			newNode.key = key;
			
			if (leaf.key < key) {
				leaf.key = key;
				leaf.left = oldNode;
				leaf.right = newNode;
			} else {
				leaf.left = newNode;
				leaf.right = oldNode;
			}
		}
		
		return previous;
	}

	@Override
	public V get(Integer key) throws ItemNotFoundException {
		V result;
		if (root.left == null) {
			throw new ItemNotFoundException();
		} else {
			Node leaf = root;
			while (leaf.right != null) {
				if (key < leaf.key) {
					leaf = (Node) leaf.left;
				} else {
					leaf = (Node) leaf.right;
				}
			}
			
			if (leaf.key != key) {
				throw new ItemNotFoundException();
			} else {
				result = (V) leaf.left;
			}
		}
		
		return result;
	}

}
