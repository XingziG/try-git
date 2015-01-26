/************************************************************
 * 
 * 95-772 Data Structures for Applications Programmers
 * 
 * Homework 3 SortedLinkedList Implementation with Recursion
 * 
 * SortedLinkedList.java
 * 
 * Andrew ID:xingzig Name:Xingzi Guo
 * 
 ************************************************************/

public class SortedLinkedList implements MyListInterface {

	// we start with the nested class Node, here is its definition
	/**
	 * A node in a singly-linked list Node is a nested class
	 * 
	 * @author xingzig
	 */
	private static class Node {
		private String value;
		private Node next;

		/**
		 * constructor to build a node with specified (could be null) successor
		 * 
		 * @param value
		 *            to be stored by this node
		 * @param next
		 *            is the reference to the next node
		 */
		public Node(String value, Node next) {
			this.value = value;
			this.next = next;
		}

		/**
		 * constructor to build a node without successor
		 * 
		 * @param value
		 *            to be stored by this node
		 */
		public Node(String value) {
			this.value = value;
			this.next = null;
		}

		public String toString() {
			return value;
		}
	}

	// end of the Node definition

	private Node head; // the only filed we have to access the Node list

	/**
	 * initializes an empty linked Node list
	 */
	public SortedLinkedList() {
		head = null;
	}

	public SortedLinkedList(String[] unsorted) {
		if (unsorted == null)
			return;
		else{
			int size = unsorted.length;
			recSortedLinkedList(unsorted, size - 1);
		}
	}

	private void recSortedLinkedList(String[] unsorted, int pos) {

		// base case, we had added unsorted[0], so return
		if (pos < 0) {
			return;
		}
		// else add the unsorted[pos] and recurse to pos-1
		else {
			add(unsorted[pos]);
			recSortedLinkedList(unsorted, pos - 1);
		}
	}

	/**
	 * Inserts a new String. No duplicates allowed and maintain the order
	 * 
	 * @param value
	 *            String to be added.
	 */
	public void add(String value) {
		if (head == null)
			head = new Node(value);
		else if (head.value.compareTo(value) > 0) {
			head = new Node(value, head);
		} else if (head.value.compareTo(value) == 0) {
			return;
		} else
			head = recAdd(head, value);
	}

	private static Node recAdd(Node l, String value) {
		// Base 1, empty linked Node list
		if (l.next == null) {
			l.next = new Node(value);
			return l;
		} else {
			// Base 2, the value behide the leader's value bigger than the value we want to add
			if (l.next.value.compareTo(value) > 0) {
				Node temp = new Node(value, l.next);
				l.next = temp;
				return l;
			}
			// Base 3, the value already in the list
			else if (l.next.value.equals(value)) {
				return l;
			} else
				l.next = recAdd(l.next, value);
			return l;
		}

	}

	/**
	 * Checks the size of the list
	 * 
	 * @return the size of the list
	 */
	public int size() {
		return recSize(head);
	}

	private int recSize(Node l) {
		if (l == null)
			return 0;
		else
			return 1 + recSize(l.next);
	}

	/**
	 * Displays the values of the list
	 */
	public void display() {
		System.out.println("[" + recDisplay(head) + "]");
	}

	private String recDisplay(Node n) {
		// Base 1, empty linked Node list
		if (n == null)
			return null;

		// Base 2, reach to the last Node
		else if (n.next == null) {
			return n.toString();
		}

		else
			return n + ", " + recDisplay(n.next);
	}

	/**
	 * Returns true if the key value is contained in the list
	 * 
	 * @param String
	 *            to be searched
	 * @return true if found, false if not found
	 */
	public boolean contains(String key) {
		return recContains(head, key);
	}

	private boolean recContains(Node n, String key) {
		if (n == null) // base case 1, empty list
			return false;

		if (n.value.equals(key)) // base case 2, find it
			return true;
		else
			return recContains(n.next, key); // go to recursion
	}

	/**
	 * Returns true is the list is empty
	 * 
	 * @return true if it is empty, false if it is not empty
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Removes and returns the first node's String object of the list.
	 * 
	 * @return String object that is removed
	 */
	public String removeFirst() {
		return removeAt(0);
	}

	/**
	 * Removes and returns String object at the index
	 * 
	 * @param index
	 *            index value to be removed
	 * @return String object that is removed
	 */
	public String removeAt(int index) {
		if (index == 0) {
			String result = head.value;
			head = head.next;
			return result;
		} else
			return recRemove(head, index).value;
	}

	private Node recRemove(Node head, int index) {
		// base 1, wrong index
		if (index < 0)
			throw new IllegalArgumentException("index < 0, bad index for remove");

		else if (index == 1) {
			if (head == null){
				throw new IllegalArgumentException("index > size, bad index for remove");
			}
			// base 2 empty list
			if (head.next == null)
				return null;

			// case 3 got it and remove it
			else {
				head.next = head.next.next;
				return head;
			}
		} else { //index > 1
			// base 4, wrong index
			if (head == null)
				throw new IndexOutOfBoundsException("index > size, bad index for remove");
			else
				return recRemove(head.next, index - 1);
		}
	}
}
