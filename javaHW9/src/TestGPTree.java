/**
 * @fileName TestGPTree.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 9-1 genetic programming
 * @date Last Modified: 11/17/2014
 * @description: In this assignment, we will generate 500 GPTrees and evolve 5 generation of trees. 
 */
/* Generated by Together */
import java.util.*;
import java.text.*;

public class TestGPTree {
    static int maxDepth = 1;
	static Random rand = new Random();
    public static void crossover(GPTree t1, GPTree t2, Random rand) {
        NodePairPlus pair1 = t1.randomParentAndChild(rand);
        NodePairPlus pair2 = t2.randomParentAndChild(rand);
        pair1.parent.changeChild(pair1.child, pair2.child);
        pair2.parent.changeChild(pair2.child, pair1.child);
    }
    public static void main(String[] args) {
        DataSet ds = new DataSet("Data2.dat");
        //DataSet ds = new DataSet("Data2a.dat");
    	Node[] ops = {new Plus(), new Minus(), new Mult(), new Divide()};
   	 	OperatorFactory o = new OperatorFactory(ops);
    	TerminalFactory t = new TerminalFactory(ds.numIndepVars());
        GPTree tree1 = new GPTree(o, t, maxDepth, rand);
        GPTree tree2 = new GPTree(o, t, maxDepth, rand);
        System.out.println(tree1);
        System.out.println(tree2);
        System.out.println();
        crossover(tree1, tree2, rand);
        System.out.println(tree1);
        System.out.println(tree2);
    }
}
