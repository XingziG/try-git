/**
 * @fileName OperatorFactory.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 6-1 TestAlgebra
 * @date Last Modified: 10/20/2014
 * @description: OperatorFactory is used to give out random operators
 */
package xingzig_homework_5_2;

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
