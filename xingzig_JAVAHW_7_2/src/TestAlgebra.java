/**
 * @fileName TestAlgebra.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 6-3 TestAlgebra
 * @date Last Modified: 10/20/2014
 * @description: In this assignment, we need to generate an advanced arithmetic tree with 3 independent variables and some constant numbers. The maximum depth 
 * of the tree is 6. We add GPTree to homework 6-1
 */

import java.util.*;

public class TestAlgebra {
    static int numIndepVars = 1;
    static int maxDepth = 5;
    static Random rand = new Random();
    static int numTrees;
    
    public static void main(String[] args) {
      
    	Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of a file and press Enter to start calculation: ");
        String FileName = keyboard.nextLine();
    	DataSet data = new DataSet(FileName);
    	Node[] ops = {new Plus(), new Minus(), new Mult(), new Divide()};
        OperatorFactory o = new OperatorFactory(ops);
        TerminalFactory t = new TerminalFactory(numIndepVars);
        
        Generation ge = new Generation(numTrees, o, t, maxDepth, rand);// TODO 
        
        GPTree gpt = new GPTree(o, t, maxDepth, rand);      
		System.out.println(gpt + " = " + gpt.eval(data));
		System.out.println("Tree size = " + gpt.mySize());
    }
}

