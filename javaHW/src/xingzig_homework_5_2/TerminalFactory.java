/**
 * @fileName TerminalFactory.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 6-1 TestAlgebra
 * @date Last Modified: 10/20/2014
 * @description: In this assignment, we need to generate an advanced arithmetic tree with 3 independent variables and some constant numbers. The maximum depth 
 * of the tree is 6.
 * @description: TerminalFactory is used to give out random terminals
 */

package xingzig_homework_5_2;

import java.util.Random;

public class TerminalFactory {
	private int numIndepVars;

	/**
	 * constructor 
	 * @param n is the number of independent variables
	 */
	TerminalFactory(int n) { 
		numIndepVars = n;
	}

	/**
	 * chooses a random number between 0 and numIndepVars. If this random
	 * number is less than numIndepVars, a Variable node is created whose index
	 * is the random number. Thus the index held by a Variable object will lie
	 * between 0 and numIndepVars-1. If the random number equals numIndepVars, a
	 * Const node is returned (with its value a random double in [0, 1}.
	 * 
	 * @param rand
	 * @return Node, can be a const or a variable
	 */
	public Node getTreminal(Random rand) {
		
		int i = rand.nextInt(numIndepVars+1);
		
		if (i == numIndepVars){			
			return new Const((Math.random()));
		}
		else{		
			return new Variable(i);
		}
	}

	public int getNumIndepVars() {
		return numIndepVars;
	}
}
