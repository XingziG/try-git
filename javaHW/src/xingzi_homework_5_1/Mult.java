/**
 * @fileName Mult.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 5-1 Arithmetic example
 * @date Last Modified: 10/14/2014
 * @description: Write a arithmetic example to generate four random decimal numbers or use variables given, 
 *               using four functions calculator to count their result. 
 */

package xingzi_homework_5_1;

public class Mult extends Binop {
	public Mult(Node l, Node r) {
		super(l, r); //call father  constructor
	}

	@Override
	public double eval(double[] data) {
		return lChild.eval(data) * rChild.eval(data); //do the calculation
	}

	@Override
	public String toString() {
		return "(" + lChild.toString() + " * " + rChild.toString() + ")";
	}
}
