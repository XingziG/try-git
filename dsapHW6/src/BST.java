/*****************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * 
 * Homework 6: Building Index using BST
 * 
 * Andrew ID: xingzig
 * Name: Xingzi Guo
 * 
 *****************************************************/
import java.util.*;

public class BST<T extends Comparable<T>> implements Iterable<T>,
		BSTInterface<T> {

	private Node<T> root;
	private Comparator<T> comparator;

	public BST() {
		this(null);
	}

	public BST(Comparator<T> comparator) {
		this.comparator = comparator;
		root = null;
	}

	/**
	 * Returns the comparator used to order this collection.
	 * 
	 * @return comparator
	 */
	public Comparator<T> comparator() {
		return comparator;
	}

	/**
	 * Returns the root data of this tree.
	 * 
	 * @return root data
	 */
	public T getRoot() {
		if (root != null)
			return root.data;
		else
			return null;
	}

	/**
	 * Returns the height of this tree. if the tree is empty or tree has only a
	 * root node, then the height of the tree is 0.
	 * 
	 * @return int value of the height
	 */
	public int getHeight() {
		return recGetHeight(root);
	}

	private int recGetHeight(Node<T> root) {
		if (root == null) // empty tree
			return 0;
		else if (root.left == null && root.right == null) // only has one node
			return 0;
		else
			return 1 + Math.max(recGetHeight(root.left),
					recGetHeight(root.right));
	}

	/**
	 * Returns the number of ndoes in this tree.
	 * 
	 * @return int value of the number of nodes.
	 */
	public int getNumberOfNodes() {
		return recGetNumOfNodes(root);
	}

	/**
	 * If node is NULL then return 0; else if left child and right child are
	 * NULL then return 1; else recursively count the number of nodes in left
	 * sub tree + the number of nodes in right sub tree + 1
	 * 
	 * @param root
	 * @return the number of Nodes in the BST
	 */
	private int recGetNumOfNodes(Node<T> root) {
		if (root == null)
			return 0;
		else
			return 1 + recGetNumOfNodes(root.left)
					+ recGetNumOfNodes(root.right);
	}

	/**
	 * Given the value (object) to be searched, it tries to find it.
	 * 
	 * @param toSearch
	 *            - value to be searched
	 * @return The value (object) of the search result. If nothing found, null.
	 */
	@Override
	public T search(T toSearch) {
		if (toSearch == null)
			return null;
		else
			return comparator == null ? recSearch(root, toSearch)
					: recSearchUsingComparator(root, toSearch);
	}

	/**
	 * natural ordering
	 * 
	 * @param root
	 * @param toSearch
	 * @return
	 */
	private T recSearch(Node<T> root, T toSearch) {
		if (root == null)
			return null;

		if (toSearch.compareTo(root.data) < 0)
			return recSearch(root.left, toSearch); // go to left tree
		else if (toSearch.compareTo(root.data) > 0)
			return recSearch(root.right, toSearch); // go to right tree
		else
			return root.data;
	}

	/**
	 * Using specific comparator
	 * 
	 * @param root
	 * @param toSearch
	 * @return
	 */
	private T recSearchUsingComparator(Node<T> root, T toSearch) {

		if (root == null)
			return null;

		if (comparator.compare(root.data, toSearch) > 0)
			return recSearchUsingComparator(root.left, toSearch);
		else if (comparator.compare(root.data, toSearch) < 0)
			return recSearchUsingComparator(root.right, toSearch);
		else
			return root.data;
	}

	/**
	 * Inserts a value (object) to the tree. No duplicates allowed.
	 * 
	 * @param toInsert
	 *            - a value (object) to be inserted to the tree.
	 */
	@Override
	public void insert(T toInsert) {
		if (toInsert == null)
			return;
		else 
			root = comparator == null ? recInsert(root, toInsert)
					: recInsertUsingComparator(root, toInsert);
	}

	/**
	 * Inserting by natural ordering
	 * 
	 * @param parent
	 * @param toInsert
	 * @return
	 */
	private Node<T> recInsert(Node<T> parent, T toInsert) {
		if (parent == null)
			return new Node<T>(toInsert);

		if (toInsert.compareTo(parent.data) < 0)
			parent.left = recInsert(parent.left, toInsert);
		else if (toInsert.compareTo(parent.data) > 0)
			parent.right = recInsert(parent.right, toInsert);

		return parent;
	}

	/**
	 * Inserting by specific comparator ordering
	 * 
	 * @param parent
	 * @param toInsert
	 * @return
	 */
	private Node<T> recInsertUsingComparator(Node<T> parent, T toInsert) {
		if (parent == null)
			return new Node<T>(toInsert);

		if (comparator.compare(parent.data, toInsert) > 0)
			parent.left = recInsertUsingComparator(parent.left, toInsert);
		else if (comparator.compare(parent.data, toInsert) < 0)
			parent.right = recInsertUsingComparator(parent.right, toInsert);

		return parent;

	}

	/**
	 * In-order iterator
	 * 
	 * @return iterator object
	 */
	@Override
	public Iterator<T> iterator() {
		return new InOrderItr();
	}

	/**
	 * This inOrderHelperClass has two variables: <i>treeNode</i> --store
	 * current treeNode， <i>visitedLeft</i> --indicates whether we have visited
	 * the left child of the current treeNode or not
	 * 
	 */
	private class inOrderHelperClass {
		Node<T> treeNode;
		boolean visitedLeft = false;

		inOrderHelperClass(Node<T> treeNode) {
			this.treeNode = treeNode;
		}
	}

	/**
	 * inner class for in-order iterator that implements <b>Iterator</b>
	 * interface.
	 * 
	 * <p>
	 * Every time we visit a new Node, we construct a inOrderHelperClass object,
	 * pass {@code current Node} as grguments
	 * 
	 * <p>
	 * If visitedLeft is <b>true</b>, it means we have visited the left child,
	 * then we should go to the parent node by popping a node out of the stack;
	 * 
	 * <p>
	 * If visitedLeft is <b>false</b>, it means we haven't visited the left
	 * child, then we should continue go to the left branch by pushing a left
	 * node into the stack.
	 *
	 */
	private class InOrderItr implements Iterator<T> {
		private final Stack<inOrderHelperClass> stack = new Stack<inOrderHelperClass>();

		public InOrderItr() {
			if (root != null) {
				stack.push(new inOrderHelperClass(root));
			}
		}

		/*
		 * If the stack is empty, it means that we have traverse all the
		 * treeNodes
		 * 
		 * If it is not empty, it means that we still have parents' nodes in the
		 * stack and that we haven't traversed all the treeNodes
		 */
		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException("No more node to iterate");
			}

			while (hasNext()) {
				// Peeking the top node in the stack to check whether it have
				// left child.
				// If it has a left child, it is not a leaf node.
				inOrderHelperClass treeNodeState = stack.peek();
				Node<T> treeNode = treeNodeState.treeNode;

				// keep pushing left unvisited node into the stack until we
				// meet
				// the leaf node.
				if (!treeNodeState.visitedLeft) {
					pushInStackIfNotNull(treeNode.left);
					treeNodeState.visitedLeft = true;
				}

				else {
					stack.pop(); // When we meet the leaf node, we pop it.
					pushInStackIfNotNull(treeNode.right);
					// Every time we pop a Node, we have to push its right
					// child
					// into the stack, if it has one.
					return treeNode.data;
				}
			}

			throw new AssertionError(
					"A node has not been returned when it should have been.");
		}

		private void pushInStackIfNotNull(Node<T> node) {
			if (node != null)
				stack.push(new inOrderHelperClass(node));
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	// private static nested class for Node
	private static class Node<T> {
		private T data;
		private Node<T> left;
		private Node<T> right;

		public Node(T data) {
			this(data, null, null);
		}

		public Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return data.toString();
		}
	}

	/***********************************************************
	 * 
	 * For a very simple debug purpose:
	 * 
	 * Test your BST with this first to make sure your BST works. But, this is a
	 * starting point. Should test more!
	 * 
	 ***********************************************************/
	public static void main(String[] args) {
		BST<Integer> b = new BST<Integer>();
		int[] ar = { 31, 16, 49, 5, 18, 51, 4, 13, 17, 19, 8 };
		for (Integer x : ar)
			b.insert(x);

		for (Integer x : b)
			System.out.print(x + " ");

		System.out.println();
		System.out.println(b.search(8));
		System.out.println(b.getHeight());
		System.out.println(b.getNumberOfNodes());
	}

}