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

	@Override
	public V delete(Integer key) throws ItemNotFoundException {
		V result;
		
		// If tree is empty (by its emptiness marker) then just throw an ItemNotFoundException
		if (root.left == null) {
			throw new ItemNotFoundException();
			
		// If tree is a leaf (by its emptiness marker) and the leaf is the one being deleted then just reset tree and return it
		} else if (root.right == null) {
			if (root.key == key) {
				result = (V) root.left;
				root.left = null;
				root.key = null;
			} else {
				throw new ItemNotFoundException();
			}
			
		// Otherwise get the leaf corresponded to the key.
		// Comparing to get() the difference is we have to hold the link to the upper object (to reassign the links)
		} else {
			Node upperNode = null;
			Object tmpNode = root, otherNode = null;
			while (((Node) tmpNode).right != null) {
				
				// keep parent node
				upperNode = ((Node) tmpNode);
				if (key < upperNode.key) {
					
					// get the next node to explore and it's sibling
					tmpNode = upperNode.left;
					otherNode = upperNode.right;
				} else {
					
					// get the next node to explore and it's sibling
					tmpNode = upperNode.right;
					otherNode = upperNode.left;
				}
			}
			
			// If found leaf's key is equal to one being deleted - perform the deletion.
			// It means assign otherNode to upperNode (get rid of splitting node and replace it with the survived subtree)
			if (((Node) tmpNode).key == key) {
				result = (V) ((Node) tmpNode).left;
				upperNode.left = ((Node) otherNode).left;
				upperNode.right = ((Node) otherNode).right;
				upperNode.key = ((Node) otherNode).key;
			} else {
				throw new ItemNotFoundException();
			}
		}
		
		return result;
	}
	
}
