/**
 * @fileName TestEvolver.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 9-1 genetic programming
 * @date Last Modified: 11/17/2014
 * @description: In this assignment, we will generate 500 GPTrees and evolve 5 generation of trees. 
 */

import java.util.Random;


/**
 * This class generate 500 PGTrees and evolve 5 times.
 * 
 * <p> An instance of <code>TestEvolver</code> has four parameters: 
 * <i>numIndepVars</i>, <i>maxDepth</i>, <i>numTrees</i> and <i>random number</i>
 * 
 * The <i>numIndepVars</i> is the number of independent x in the dataset
 * The <i>maxDepth</i> is the max depth of each GPTrees. GPTrees don't need to generate to the max depth
 * The <i>numTrees</i> is the GPTrees we want to generate in each generation
 * The <i>random number</i> is used to generate Nodes randomly in GPTrees
 * @author xingzi
 *
 */
public class TestEvolver { 
	static int numIndepVars;
	static int maxDepth = 5;
	static int numTrees = 500; // generate 500 trees
	static Random rand = new Random();

	
	public static void main(String[] args) {
		 	DataSet ds = new DataSet("Data1.dat");
	        //DataSet ds = new DataSet("Data2a.dat");
		 	numIndepVars = ds.numIndepVars();
		 
	    	Node[] ops = {new Plus(), new Minus(), new Mult(), new Divide()};
	   	 	OperatorFactory o = new OperatorFactory(ops);
	    	TerminalFactory t = new TerminalFactory(numIndepVars);

	    	System.out.println("The Parent Generation:");
			Generation gen = new Generation(numTrees, o, t, maxDepth, rand);
			gen.evalAll(ds);
			gen.printBestTree();
			gen.evalAll(ds);
			
			Evolver evol = new Evolver(gen, ds, rand);
			System.out.println("The 1st Generation:");
			evol.makeNewGeneration();
			gen = evol.getGeneration();	
			gen.printBestTree();
			
			System.out.println("The 2nd Generation:");
			evol.makeNewGeneration();
			gen = evol.getGeneration();	
			gen.printBestTree();
			
			System.out.println("The 3rd Generation:");
			evol.makeNewGeneration();
			gen = evol.getGeneration();	
			gen.printBestTree();
			
			System.out.println("The 4th Generation:");
			evol.makeNewGeneration();
			gen = evol.getGeneration();	
			gen.printBestTree();
			
			System.out.println("The 5th Generation:");
			evol.makeNewGeneration();
			gen = evol.getGeneration();	
			gen.printBestTree();
		
	}

}
