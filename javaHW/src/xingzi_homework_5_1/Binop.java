/**
 * @fileName Binop.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 5-1 Arithmetic example
 * @date Last Modified: 10/14/2014
 * @description: Write a arithmetic example to generate four random decimal numbers or use variables given, 
 *               using four functions calculator to count their result. 
 */
package xingzi_homework_5_1;

public abstract class Binop extends Node { // Binop class is the father of the
											// operators {+, -, *, /}
	protected Node lChild, rChild;

	public Binop(Node l, Node r) {
		lChild = l; // to generate the left operand
		rChild = r; // to generate the right operand
	}
}