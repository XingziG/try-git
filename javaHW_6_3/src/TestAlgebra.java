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
    static int numIndepVars = 3;
    static int maxDepth = 5;
    static Random rand = new Random();
    
    public static void main(String[] args) {
        double[] data = {3.14, 2.78, 1.0};
        Node[] ops = {new Plus(), new Minus(), new Mult(), new Divide()};
        OperatorFactory o = new OperatorFactory(ops);
        TerminalFactory t = new TerminalFactory(numIndepVars);
        
        GPTree gpt = new GPTree(o, t, maxDepth, rand);
               
		System.out.println(gpt + " = " + gpt.eval(data));
		System.out.println("Tree size = " + gpt.mySize());
    }
}

