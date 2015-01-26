/**
 * @fileName Const.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 5-1 Arithmetic example
 * @date Last Modified: 10/14/2014
 * @description: Write a arithmetic example to generate four random decimal numbers or use variables given, 
 *               using four functions calculator to count their result. 
 */

package xingzi_homework_5_1;

public class Const extends Node { //operand random number [1,20] is put in const 
	private double value;

	public Const(double d) {
		value = d;				// the value in constant
	}

	public double eval(double[] data) {
		return value;
	}
	
	public String toString() {
		return value + "";
	}
}
