/**
 * @fileName Const.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 6-1 TestAlgebra
 * @date Last Modified: 10/20/2014
 * @description: Const class is used to generate and hold constant numbers in the program 
 */

import java.text.NumberFormat;
import java.util.Random;

public class Const extends Node { // operand number is put in const
	private double value;

	public Const(double d) { // constructor of const
		value = d;
	}

	@Override
	public double eval(double[] data) { // get the const value
		return value;
	}

	@Override
	public void addRandomKids(OperatorFactory o, TerminalFactory t,
			int maxDepth, Random rand) {
	} // Since const is a terminal, it does nothing when we call the addRandomKids method.

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getInstance(); //format all const number to 2 fraction digits
		nf.setMaximumFractionDigits(2);
		return nf.format(value) + "";
	}

}
