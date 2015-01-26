/**
 * @fileName Evolver.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 9-1 genetic programming
 * @date Last Modified: 11/17/2014
 * @description: In this assignment, we will generate 500 GPTrees and evolve 5 generation of trees.  
 * @description: Evolver class is used to evolve new generations
 */
import java.util.Random;

/**
 * This class evolve new generations.
 * 
 * <p> An instance of <code>Evolver</code> has three parameters: <i>generation</i>, <i>dataset</i> and <i>random number</i>
 * 
 * <p>The <i>generation</i> is the old generation which contains 500 trees.
 * <p>The <i>dataset</i> is a dataset of variable x and y to evaluate the trees that have been generate 
 * <p>The <i>random number</i> is used to choose parent trees based on the parents' proportion. Parent trees with higher porportion are more
 * likely to be chosen.
 * 
 * @author xingzi
 *
 */
public class Evolver {
	private Generation generation;
	private Generation newgeneration;
	private DataSet dataset;
	private Random rand;

	/**
	 * Constructor
	 * 
	 * @param g the old generation which contains 500 trees.
	 * @param d a dataset of variable x and y to evaluate the trees that have been generate 
	 * @param r is used to choose parent trees based on the parents' proportion. Parent trees with higher porportion are more likely to be chosen.
	 */
	public Evolver(Generation g, DataSet d, Random r) {
		generation = g;
		dataset = d;
		rand = r;
	}

	/**
	 * @return the generation of 500 trees
	 */
	public Generation getGeneration() {
		return generation;
	}

	/**
	 * makeNewGeneration This method creates a new generation of trees, and replaces the old generation with this new one
	 * 
	 * <p> The new generation should be the same size as the original.
	 * <p> To make the new generation, choose pairs of trees, proportional to their fitness, 
	 * and cross them over to make a new pair of children. Store these
	 * children in a new Generation object, and repeat this process until the
	 * new generation is complete
	 * 
	 * @see Evolver#crossover(GPTree, GPTree, Random)
	 * @see Generation#chooseTreeProportionalToFitness(Random)
	 * @see Generation#setPopulation(GPTree[])
	 * @see Generation#evalAll(DataSet)
	 */
	public void makeNewGeneration() {
		generation.evalAll(dataset);
		int NumofTrees = generation.getNumTrees();
		newgeneration = new Generation(NumofTrees);
		GPTree[] BufferedGPTreeArray = new GPTree[NumofTrees];
			
		for (int i = 0; i < NumofTrees; i += 2){
			GPTree tree1 = generation.chooseTreeProportionalToFitness(rand).duplicate();
			GPTree tree2 = generation.chooseTreeProportionalToFitness(rand).duplicate();
			crossover(tree1, tree2, rand);
			BufferedGPTreeArray[i] = tree1;
			if(i<NumofTrees-1)
			BufferedGPTreeArray[i+1] = tree2;
		}
		newgeneration.setPopulation(BufferedGPTreeArray);
		newgeneration.evalAll(dataset);
		
		generation = newgeneration;
	}
	
	/**
	 * crossover This method crosses over nodes from parent trees
	 * 
	 * <p> This method uses random number to determine which node to break and cross them over each other
	 * 
	 * @param t1 parent tree1
	 * @param t2 parent tree2
	 * @param rand random number to determine the break point
	 * @see GPTree#randomParentAndChild(Random)
	 * @see Node#changeChild(Node, Node)
	 */
	private void crossover(GPTree t1, GPTree t2, Random rand) {
        NodePairPlus pair1 = t1.randomParentAndChild(rand);
        NodePairPlus pair2 = t2.randomParentAndChild(rand);
        pair1.parent.changeChild(pair1.child, pair2.child);
        pair2.parent.changeChild(pair2.child, pair1.child);
    }

}
