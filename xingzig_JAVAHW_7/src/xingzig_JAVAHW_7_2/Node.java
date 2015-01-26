package xingzig_JAVAHW_7_2;
/**
 * @fileName Node.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 6-3 TestAlgebra
 * @date Last Modified: 10/20/2014
 * @description: In this assignment, we need to generate an advanced arithmetic tree with 3 independent variables and some constant numbers. The maximum depth 
 * of the tree is 6. We add GPTree to homework 6-1
 */

import java.util.Random;

public abstract class Node implements Cloneable {
	private int depth = 0; // when a node is initialized the depth is 0. When it
							// is added to a tree, we set the depth to one
							// larger than it's root's depth

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() { // the clone method is for the operators
		Node cloned = null;
		try {
			cloned = (Node) super.clone();
		}
		catch (CloneNotSupportedException e) {
			System.out.println("Node can't clone.");
		}
		return cloned;
	}

	/**
	 * @return get the current depth of the node
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param i set the current depth of the node
	 */
	public void setDepth(int i) { 
		depth = i;
	}

	/**
	 * @param o is an instance of OperatorFactory which has the method of generating random operators
	 * @param t is an instance of TerminalFactory which has the method of generating random terminals
	 * @param maxDepth gives the maximun depth of the tree
	 * @param rand is a random number
	 */
	public abstract void addRandomKids(OperatorFactory o, TerminalFactory t,
			int maxDepth, Random rand);

	/**
	 * @param data gives the independent variables
	 * @return get the value of node
	 */
	public abstract double eval(double[] data);

	public abstract String toString();

	public abstract int mySize();
}