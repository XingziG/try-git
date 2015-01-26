/**
 * @fileName Divide.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 6-1 TestAlgebra
 * @date Last Modified: 10/20/2014
 * @description: In this assignment, we need to generate an advanced arithmetic tree with 3 independent variables and some constant numbers. The maximum depth 
 * of the tree is 6.
 */

package xingzig_homework_5_2;

public class Divide extends Binop { // "/" operator
	
	public Divide() {
		super();
	}

	public Divide(Node l, Node r) {
		super(l, r); // call father (Binop) constructor
	}

	@Override
	public double eval(double[] data) {

		return lChild.eval(data) / rChild.eval(data);
	}

	@Override
	public String toString() {
		return "(" + lChild.toString() + " / " + rChild.toString() + ")";
	}
}
