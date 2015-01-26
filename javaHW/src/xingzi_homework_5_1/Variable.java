/**
 * @fileName Variable.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 5-1 Arithmetic example
 * @date Last Modified: 10/14/2014
 * @description: Write a arithmetic example to generate four random decimal numbers or use variables given, 
 *               using four functions calculator to count their result. 
 */

package xingzi_homework_5_1;

public class Variable extends Node{
	private int index;
	
	public Variable(int i){ //constuctor
		index = i;
		
	}
	public double eval(double[] data){
		
		return data[index]; //return the X(n) variable.
	}
	
	public String toString() {
		return "X"+index;
	}
}
