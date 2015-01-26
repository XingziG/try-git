/**
 * @fileName TestAlgebra.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 6-1 TestAlgebra
 * @date Last Modified: 10/20/2014
 * @description: In this assignment, we need to generate an advanced arithmetic tree with 3 independent variables and some constant numbers. The maximum depth 
 * of the tree is 6.
 */

package xingzig_homework_5_2;

import java.text.NumberFormat;
import java.util.*;

public class TestAlgebra {
	static int numIndepVars = 3; // the number of independent variables
	static int maxDepth = 5;
	static Random rand = new Random();

	public static void main(String[] args) throws CloneNotSupportedException {
		double[] data = new double[3]; // data is the independent variables
		data[0] = 3.14;
		data[1] = 2.78;
		data[2] = 1.0;
		Node[] ops = { new Plus(), new Minus(), new Mult(), new Divide() };
		OperatorFactory o = new OperatorFactory(ops);
		TerminalFactory t = new TerminalFactory(numIndepVars);
		
		Node root = o.getOperator(rand); // get the first operator
		root.addRandomKids(o, t, maxDepth, rand); //add random kids to the root
		String s = root.toString();
		
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		System.out.println(s + " = " + nf.format(root.eval(data)));

	}
}
