/**
 * @fileName Variable.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 7-1 TestAlgebra
 * @date Last Modified: 10/29/2014
 * @description: In this assignment, we will read and store a data file. We will find out how close the tree value, for each x0 value, is to the given y value in the data.  
 */

import java.util.Random;

public class Variable extends Node{
	private int index;
	
	public Variable(int i){ 
		index = i;
		
	}
	
	@Override
	public double eval(double[] data){
		
		return data[index];
	}
	
	@Override
	public void addRandomKids(OperatorFactory o, TerminalFactory t, int maxDepth, Random rand){}
	
	@Override
	public String toString() {
		return "X"+index;
	}
	public int mySize(){
		return 1;
	}
}
