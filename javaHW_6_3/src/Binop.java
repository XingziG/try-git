/**
 * @fileName Binop.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 6-1 TestAlgebra
 * @date Last Modified: 10/20/2014
 * @description: In this assignment, we need to generate a advanced arithmetic tree with 3 variables and constant numbers. 
 * @description: Binop extends the Node. It is the superclass of operators.
 */

import java.util.Random;

public abstract class Binop extends Node { // Binop class is the father of the
											// operators {+, -, *, /}
	protected Node lChild, rChild;

	public Binop() {
		super();
	}

	public Binop(Node l, Node r) {
		lChild = l; // to generate the left operand
		rChild = r; // to generate the right operand
	}

	/**
	 * This method needs to be supplied with an OperatorFactory object, a
	 * TerminalFactory object, an int specifying the maximum tree depth, a
	 * Random object To ensure that the trees created don’t get too large, each
	 * and every Node will now hold an int (call it depth) that records how far
	 * down in the tree it is. When a Node object is first created (i.e., by its
	 * constructor), it has depth zero. When a Node is added to a tree, its
	 * depth variable is set to be one larger than that of its parent.
	 */
	public void addRandomKids(OperatorFactory o, TerminalFactory t,
			int maxDepth, Random rand) {

		// If n’s depth is equal to maxDepth, the tree shouldn’t be enlarged
		// any further. Set both its left and right children to be terminals.
		if (this.getDepth() == maxDepth) {
			lChild = t.getTreminal(rand);// get Terminal and set depth
			lChild.setDepth(this.getDepth() + 1);
			rChild = t.getTreminal(rand);
			rChild.setDepth(this.getDepth() + 1);
		}

		// Otherwise, the tree continues to grow. First add a left child, by
		// choosing a random number between 0 and (numOperators + numIndepVars).
		else {
			int i = rand.nextInt(o.getNumOps() + t.getNumIndepVars());
			int j = rand.nextInt(o.getNumOps() + t.getNumIndepVars());
			 
			 
			if (i < o.getNumOps()) {					// If this number is less than numOperators, add a new operator as							
				lChild = o.getOperator(rand);			// the left child (by calling getOperator()).
				lChild.setDepth(this.getDepth() + 1);   // Set the new child’s depth to one larger than n’s depth.
				lChild.addRandomKids(o, t, maxDepth, rand);	//Then call the new child’s addRandomKids() method. This is the recursive step that keeps the
															// tree building process going.
			} 
			else {										// If this number is larger than numOperators, add a new terminal as
				lChild = t.getTreminal(rand);			// the left child (by calling getTerminal()).
				lChild.setDepth(this.getDepth() + 1);	// Set the new child’s depth to one larger than n’s depth.
	
			}

			if (j < o.getNumOps()) {					//repeat the same process for right child
				rChild = o.getOperator(rand);
				rChild.setDepth(this.getDepth() + 1);
				rChild.addRandomKids(o, t, maxDepth, rand);
			} else {
				rChild = t.getTreminal(rand);
				rChild.setDepth(this.getDepth() + 1);
			}
		}
	}
	
	public int mySize(){
		int size = lChild.mySize() + rChild.mySize() + 1;
		
		return size;
		
	};
}