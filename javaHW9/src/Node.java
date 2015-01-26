/**
 * @fileName Node.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 9-1 genetic programming
 * @date Last Modified: 11/17/2014
 * @description: In this assignment, we will generate 500 GPTrees and evolve 5 generation of trees. 
 * @modify mySize()
 */

/* Generated by Together */
import java.util.*;

public abstract class Node implements Cloneable {
	protected int depth;

	public Node() {
		depth = 0;
	}

	public int mySize() {
		return 1;
	}

	public void setDepth(int d) {
		depth = d;
	}

	public int getDepth() {
		return depth;
	}

	public abstract void setChild(int position, Node n);

	public abstract double eval(double[] data);

	public abstract String toString();

	public abstract void addRandomKids(OperatorFactory o, TerminalFactory t,
			int maxDepth, Random rand);

	public abstract void changeChild(Node oldChild, Node newChild);

	public abstract NodePairPlus traceTree(int nodeNumber, int clipNumber);

	public abstract Node duplicate();

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Node can't clone.");
		}
		return o;
	}
}
