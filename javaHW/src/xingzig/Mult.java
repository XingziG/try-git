/**
 * @fileName Mult.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 4-1 Arithmetic example
 * @date Last Modified: 09/27/2014
 * @description: Write a arithmetic example to generate four random decimal numbers and using four functions calculator to count their result. 
 */

package xingzig;

public class Mult extends Binop {
	public Mult(Node l, Node r) {
		super(l, r); //call father  constructor
	}

	@Override
	public double eval() {
		return lChild.eval() * rChild.eval();
	}

	@Override
	public String toString() {
		return "(" + lChild.toString() + " * " + rChild.toString() + ")";
	}
}
