/**
 * @fileName OperatorFactory.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 7-1 TestAlgebra
 * @date Last Modified: 10/29/2014
 * @description: In this assignment, we will read and store a data file. We will find out how close the tree value, for each x0 value, is to the given y value in the data.  
 * @description: OperatorFactory is used to give out random operators
 */

import java.util.Random;

public class OperatorFactory {
	private Node[] currentOps;
	
	/**
	 * @param n a reference of a Node array to hold four independent operators
	 */
	OperatorFactory (Node[] n){
		currentOps = n;
	}
	
	/**
	 * @param rand random number
	 * @return a specific randomly chosen operator, return type Node
	 */
	public Node getOperator(Random rand){
		int i = rand.nextInt(4);
		return (Node) currentOps[i].clone();
	}
	
	/**
	 * @return get the number of independent operators
	 */
	public int getNumOps(){
		return currentOps.length;
	}

}
