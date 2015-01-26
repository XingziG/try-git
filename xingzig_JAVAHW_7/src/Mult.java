/**
 * @fileName Mult.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 7-1 TestAlgebra
 * @date Last Modified: 10/29/2014
 * @description: In this assignment, we will read and store a data file. We will find out how close the tree value, for each x0 value, is to the given y value in the data.  
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
