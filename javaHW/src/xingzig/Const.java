/**
 * @fileName Const.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 4-1 Arithmetic example
 * @date Last Modified: 09/27/2014
 * @description: Write a arithmetic example to generate four random decimal numbers and using four functions calculator to count their result. 
 */

package xingzig;

public class Const extends Node { //operand number is put in const 
	private double value;

	public Const(double d) {
		value = d;
	}

	public double eval() {
		return value;
	}
	
	public String toString() {
		return eval() + "";
	}
}
