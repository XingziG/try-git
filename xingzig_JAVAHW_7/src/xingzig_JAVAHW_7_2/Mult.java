package xingzig_JAVAHW_7_2;
/**
 * @fileName Mult.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 6-3 TestAlgebra
 * @date Last Modified: 10/20/2014
 * @description: In this assignment, we need to generate an advanced arithmetic tree with 3 independent variables and some constant numbers. The maximum depth 
 * of the tree is 6. We add GPTree to homework 6-1
 */


public class Mult extends Binop { // "*" operator

	public Mult() { 
		super();
	}

	public Mult(Node l, Node r) {
		super(l, r); //call father  constructor
	}

	@Override
	public double eval(double[] data) {
		return lChild.eval(data) * rChild.eval(data);
	}

	@Override
	public String toString() {
		return "(" + lChild.toString() + " * " + rChild.toString() + ")";
	}
	
}
