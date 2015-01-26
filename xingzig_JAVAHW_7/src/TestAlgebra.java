/**
 * @fileName TestAlgebra.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 7-1 TestAlgebra
 * @date Last Modified: 10/29/2014
 * @description: In this assignment, we will read and store a data file. We will find out how close the tree value, for each x0 value, is to the given y value in the data.  
 */

import java.util.*;

public class TestAlgebra {
    static int numIndepVars;
    static int maxDepth = 5;
    static Random rand = new Random();
    
    public static void main(String[] args) {
      
    	Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of a file and press Enter to start calculation: ");
        String FileName = keyboard.nextLine();
    	DataSet data = new DataSet(FileName);
    	numIndepVars = data.getxNum();
    	
    	Node[] ops = {new Plus(), new Minus(), new Mult(), new Divide()};
        OperatorFactory o = new OperatorFactory(ops);
        TerminalFactory t = new TerminalFactory(numIndepVars);
        
        GPTree gpt = new GPTree(o, t, maxDepth, rand);      
		System.out.println(gpt + " = " + gpt.eval(data));
		System.out.println("Tree size = " + gpt.mySize());
    }
}

