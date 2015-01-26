/**
 * @fileName Node.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 4-1 Arithmetic example
 * @date Last Modified: 09/27/2014
 * @description: Write a arithmetic example to generate four random decimal numbers and using four functions calculator to count their result. 
 */

package xingzig;

public class Node { // the node class is the father of both the Binop class and the
					// Const class.
	public Node() { // the constuctor of Node
	}

	public double eval() { //should not generate the instance of Node
		System.out.println("Error: eval Node");
		return 0;
	}
}