/**
 * @fileName Divide.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 7-1 TestAlgebra
 * @date Last Modified: 10/29/2014
 * @description: In this assignment, we will read and store a data file. We will find out how close the tree value, for each x0 value, is to the given y value in the data.  
 * 
 */


public class Divide extends Binop { // "/" operator
	
	public Divide() {
		super();
	}

	public Divide(Node l, Node r) {
		super(l, r); // call father (Binop) constructor
	}

	@Override
	public double eval(double[] data) {
		if (Math.abs(rChild.eval(data)) < 0.0001){
		return 1.0;
		}
		return lChild.eval(data) / rChild.eval(data);
	}

	@Override
	public String toString() {
		return "(" + lChild.toString() + " / " + rChild.toString() + ")";
	}

	
}
