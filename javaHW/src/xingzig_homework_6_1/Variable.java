/**
 * @fileName Variable.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 6-1 TestAlgebra
 * @date Last Modified: 10/20/2014
 * @description: In this assignment, we need to generate an advanced arithmetic tree with 3 independent variables and some constant numbers. The maximum depth 
 * of the tree is 6. Variable class is used to return variables and hold a variable index which has been chosen.
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
}
