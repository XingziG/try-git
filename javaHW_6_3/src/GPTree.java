/**
 * @fileName GPTree.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 6-3 TestAlgebra
 * @date Last Modified: 10/20/2014
 * @description: In this assignment, we need to generate an advanced arithmetic tree with 3 independent variables and some constant numbers. The maximum depth 
 * of the tree is 6. We add GPTree to homework 6-1
 */


import java.util.Random;

public class GPTree {
	private Node root;
	private int mySize;

	GPTree() {
		root = null;
	}

	GPTree(OperatorFactory o, TerminalFactory t, int maxDepth, Random rand) {
		root = o.getOperator(rand);
		root.addRandomKids(o, t, maxDepth, rand);
	}

	public String toString() {
		return root.toString();
	}

	public double eval(double[] data) {
		return root.eval(data);
	}

	// The following requires that you add the mySize() method
	// to Node and all its subclasses. Try it!
	public int mySize() {
		return root.mySize();
	}
}
