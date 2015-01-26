/**
 * @fileName Binop.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 9-1 genetic programming
 * @date Last Modified: 11/17/2014
 * @description: In this assignment, we will generate 500 GPTrees and evolve 5 generation of best trees 
 * @description: Binop extends the Node. It is the superclass of operators.
 * @modify: public int mySize(), 
 */

import java.util.*;

/** A superclass for all arithmetic binary operators. */
public abstract class Binop extends Node {
	protected Node lChild, rChild;

	public Binop() {
	}

	/**
	 * @param l left child
	 * @param r right child
	 */
	public Binop(Node l, Node r) {
		lChild = l;
		rChild = r;
	}

	public void setChild(int position, Node n) {
		if (position == 1)
			lChild = n;
		else
			rChild = n;
	}

	/**
	 * Add left and right children, and recursively extend them by a specified
	 * amount. If maxDepth has been reached, add terminals as children.
	 * Otherwise add a random operator or terminal child on the left and right,
	 * and ask each child to addRandomKids. Each child has a depth one greater
	 * than the current node. The process stops either when both children are
	 * terminals, or when maxDepth has been reached.
	 */
	public void addRandomKids(OperatorFactory o, TerminalFactory t,
			int maxDepth, Random rand) {
		int i;
		if (depth < maxDepth) {
			i = rand.nextInt(o.getNumOps() + t.getNumIndepVars());
			if (i < t.getNumIndepVars()) {
				lChild = t.getTerminal(rand);
				lChild.depth = depth + 1;
			} else {
				lChild = o.getOperator(rand);
				lChild.depth = depth + 1;
				lChild.addRandomKids(o, t, maxDepth, rand);
			}
			i = rand.nextInt(o.getNumOps() + t.getNumIndepVars());
			if (i < t.getNumIndepVars()) {
				rChild = t.getTerminal(rand);
				rChild.depth = depth + 1;
			} else {
				rChild = o.getOperator(rand);
				rChild.depth = depth + 1;
				rChild.addRandomKids(o, t, maxDepth, rand);
			}
		} else {
			lChild = t.getTerminal(rand);
			lChild.depth = depth + 1;
			rChild = t.getTerminal(rand);
			rChild.depth = depth + 1;
		}
	}

	public int mySize() {
		int size = lChild.mySize() + rChild.mySize() + 1;
		return size;
		
		//return 0;
	}

	/**
	 * Find the parent and child nodes for crossover. There are three
	 * NodePairPlus objects; exactly one of them will be returned, depending on
	 * whether the current node is the parent, or the parent is in the left
	 * subtree, or the parent is in the right subtree. clipNumber is the
	 * pre-determined location of the clip point. nodeNumber is the number of
	 * the current node. If nodeNumber + 1 == clipNumber, the current node is
	 * the parent, and the left child is the child. Otherwise, send testLeft
	 * down the left subtree. If it comes back instantiated, i.e.,
	 * testLeft.parent != null, then the clip point was found down the left
	 * subtree. Return testLeft. If testLeft's counter is one less than the clip
	 * number, the current node is the parent and the right child is the child.
	 * Otherwise, search for the clip point down the right subtree.
	 */
	public NodePairPlus traceTree(int nodeNumber, int clipNumber) {
		NodePairPlus myReturn = new NodePairPlus();
		NodePairPlus testLeft = new NodePairPlus();
		NodePairPlus testRight = new NodePairPlus();
		if (nodeNumber + 1 == clipNumber) {
			myReturn.parent = this;
			myReturn.child = lChild;
			myReturn.counter = clipNumber;
			return myReturn;
		}
		testLeft = lChild.traceTree(nodeNumber + 1, clipNumber);
		if (testLeft.parent != null)
			return testLeft;
		if (testLeft.counter + 1 == clipNumber) {
			myReturn.parent = this;
			myReturn.child = rChild;
			myReturn.counter = clipNumber;
			return myReturn;
		}
		testRight = rChild.traceTree(testLeft.counter + 1, clipNumber);
		return testRight;
	}

	/**
	 * Exchange a child tree with a different child tree (one half of the
	 * crossover operation). Test to see which of lChild or rChild is the old
	 * node, and replace oldChild with newChild.
	 */
	public void changeChild(Node oldChild, Node newChild) {
		if (lChild == oldChild)
			lChild = newChild;
		else if (rChild == oldChild)
			rChild = newChild;
		else
			System.out.println("Can't find oldChild in BinOp.changeChild()");
		return;
	}
}
