/**
 * @fileName Node.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 5-1 Arithmetic example
 * @date Last Modified: 10/14/2014
 * @description: Write a arithmetic example to generate four random decimal numbers or use variables given, 
 *               using four functions calculator to count their result. 
 */

package xingzi_homework_5_1;

public abstract class Node { // the node class is the father of both the Binop
								// class and the Const class.
	public Node() {          // the constuctor of Node
	}

	public abstract double eval(double[] data);
}