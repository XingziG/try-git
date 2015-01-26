/*****************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * 
 * Lab 2 LinkedList Operation Implementation
 * 
 * Singly Linked List
 * 
 * Andrew ID: xingzig
 * Name: Xingzi Guo
 *
 *****************************************************/

import java.util.*;

public class LinkedListLab<AnyType> implements Iterable<AnyType> {

	private Node<AnyType> head;

	public LinkedListLab() {
		head = null;
	}

	public void insert(AnyType dataItem) {
		if (head == null)
			head = new Node<AnyType>(dataItem, head);
		else {
			Node<AnyType> tmp = head;
			while (tmp.next != null)
				tmp = tmp.next;

			tmp.next = new Node<AnyType>(dataItem, null);
		}
	}

	/**
	 * Find object that is kth to the last node of linkedlist
	 * 
	 * @param k
	 *            kth position to the last. 1 means the last node
	 * @return Object that is located at kth to the last
	 */
	public AnyType kthToLast(int k) {
		if (k < 1)
			return null;
		else {
			Iterator<AnyType> front = iterator();
			Iterator<AnyType> back = iterator();
			for (int i = 0; i < k; i++) {
				if (front.hasNext()) 
					front.next();
				else 
					return null;
			}
			while (front.hasNext()){
				front.next();
				back.next();
		}
		return back.next();
		}
	}

	/**
	 * Returns a string representation
	 * 
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		for (Object x : this)
			result.append(x + " ");

		return result.toString();
	}

	/*******************************************************
	 * 
	 * The Iterator class
	 * 
	 ********************************************************/
	public Iterator<AnyType> iterator() {
		return new LinkedListLabIterator();
	}

	private class LinkedListLabIterator implements Iterator<AnyType> {
		private Node<AnyType> nextNode;

		public LinkedListLabIterator() {
			nextNode = head;
		}

		public boolean hasNext() {
			return nextNode != null;
		}

		public AnyType next() {
			if (!hasNext())
				throw new NoSuchElementException();
			AnyType result = nextNode.data;
			nextNode = nextNode.next;
			return result;
		}

		// not supporting remove()
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/******************************************************
	 * 
	 * Node (static nested class)
	 * 
	 ******************************************************/
	private static class Node<AnyType> {
		private AnyType data;
		private Node<AnyType> next;

		public Node(AnyType data, Node<AnyType> next) {
			this.data = data;
			this.next = next;
		}
	}

}