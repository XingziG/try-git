/**
 * @fileName TestArithmetic.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 4-1 Arithmetic example
 * @date Last Modified: 09/27/2014
 * @description: Write a arithmetic example to generate four random decimal numbers and using four functions calculator to count their result. 
 */





import java.util.Random;


public class TestArithmetic {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Node n = randOpera(randOpera(randConst(), randConst()), // to calculate the arithmetic problem
					randOpera(randConst(), randConst()));
			System.out.println("" + n.toString() + " = " + n.eval());
		}
	}

	private static Const randConst() {  //generate random numbers
		return new Const((int) (Math.random() * 20+1));
	}

	private static Binop randOpera(Node l, Node r) { //generate random operators
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
