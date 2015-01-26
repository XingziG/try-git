/**
 * @fileName Binop.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 4-1 Arithmetic example
 * @date Last Modified: 09/27/2014
 * @description: Write a arithmetic example to generate four random decimal numbers and using four functions calculator to count their result. 
 */
package xingzig;

public class Binop extends Node { //Binop class is the father of the operators {+, -, *, /}
	protected Node lChild, rChild;

	public Binop(Node l, Node r) { 
		lChild = l;  //to generate the left operand
		rChild = r;  //to generate the right operand
	}
}