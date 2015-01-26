package xingzig_JAVAHW_7_2;

import java.util.Random;

public class Generation {
	/** A container of GPTrees. */

	private int numTrees;
	private GPTree[] population;
	private double[] fitness;

	/**
	 * Specifies the number of GPTrees in this generation, the factories used to
	 * generate the individual trees, the maximum tree depth, and the Random
	 * object used.
	 */
	Generation(int numTrees, OperatorFactory o, TerminalFactory t, int m,
			Random r) {
		this.numTrees = numTrees;
		population = new GPTree[numTrees];
		fitness = new double[numTrees];
		for (int i = 0; i < numTrees; i++)
			population[i] = new GPTree(o, t, m, r);
	}

	Generation(int n) {
		numTrees = n;
		population = new GPTree[numTrees];
		fitness = new double[numTrees];
	}

	/**
	 * Evaluate each tree in this generation, and set each tree's fitness value.
	 */
	public void evalAll(DataSet theData) {  // You need to write this
		
		for (int i = 0; i < numTrees; i++) {
			fitness[i] = population[i].eval(theData);
		}

	}

	public GPTree getTree(int i) {
		return population[i];
	}

	/** Prints the tree with the lowest fitness value. */
	public void printBestTree() { // You need to write this
		double temp = fitness[0];
		int index = 0;

		for (int i = 1; i < population.length; i++) {
			if (temp > fitness[i]) {
				temp = fitness[i];
				index = i;
			}
		}
		
		System.out.println("The smallest fitness is " + population[index] + " = " + temp);
		System.out.println("Tree size = " + population[index].mySize());
	}

	public int getNumTrees() {
		return numTrees;
	}

	public void printGeneration() {
		for (int i = 0; i < numTrees; i++) {
			System.out.println(population[i]);
		}
	}
}
