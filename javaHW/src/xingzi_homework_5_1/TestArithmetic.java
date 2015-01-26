/**
 * @fileName TestArithmetic.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 5-1 Arithmetic example
 * @date Last Modified: 10/14/2014
 * @description: Write a arithmetic example to generate four random decimal numbers or use variables given, 
 *               using four functions calculator to count their result.
 */

package xingzi_homework_5_1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class TestArithmetic {

	public static void main(String[] args) {
		double[][] data = new double[2][];
		data[0] = new double[] { 1, 2, 3 }; // initialize variables
		data[1] = new double[] { 4, 5, 6 }; // initialize variables
		System.out
				.println("We will use Xn={1,2,3} and Xn={4,5,6} for each equation. I will test the arithmetic tree for 5 times.\n");
		for (int i = 0; i < 5; i++) {
			Node n = randOpera(randOpera(randTerminal(), randTerminal()), // to calculate the arithmetic problem
					randOpera(randTerminal(), randTerminal()));
			for (double[] d : data) {
				System.out.println("Xn= " + Arrays.toString(d));
				System.out.println("" + n.toString() + " = "
						+ String.format("%.2f", n.eval(d)));
			}
			System.out.println("");
		}
	}

	private static Node randTerminal() { // generate random leaf
		Node result = null;
		Random s = new Random(); // start fliping a coin
		int i = s.nextInt(2);

		switch (i) {
		// flip a fair coin, if it comes up tails, we generate a variable
		case 0:
			result = new Variable(new Random().nextInt(3));
			break;

		// flip a fair coin, if it comes up heads, we generate a constant
		case 1:
			result = new Const((int) (Math.random() * 20 + 1));
			break;
		}
		return result;
	}

	private static Binop randOpera(Node l, Node r) { // generate random operators
		Binop result = null;
		Random s = new Random();
		int i = s.nextInt(4);

		switch (i) {
		case 0:
			result = new Plus(l, r);
			break;
		case 1:
			result = new Minus(l, r);
			break;
		case 2:
			result = new Mult(l, r);
			break;
		case 3:
			result = new Divide(l, r);
			break;

		}
		return result;
	}
}
