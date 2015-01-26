/**
 * @fileName Divide.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 4-1 Arithmetic example
 * @date Last Modified: 09/27/2014
 * @description: Write a arithmetic example to generate four random decimal numbers and using four functions calculator to count their result. 
 */

package xingzig;

public class Divide extends Binop {
	
	public Divide(Node l, Node r) {
		super(l, r); //call father  constructor
		if (r.eval() == 0)
			System.out.println("Attention! The divident shouldn't be 0! You won't have the correct anwser followed:");
	}

	@Override
	public double eval() {
		return lChild.eval() / rChild.eval();
	}

	@Override
	public String toString() {
		return "(" + lChild.toString() + " / " + rChild.toString() +")";
	}
}
