/**
 * @fileName This file: Fraction.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework3-1
 */

public class Fraction {
	int numerator;
	int denominator;

	Fraction() { // numerator = denominator = 1
		numerator = 1;
		denominator = 1;
	}

	Fraction(int n, int d) {
		if (d != 0) {
			numerator = n / this.gcd(n, d);
			denominator = d / this.gcd(n, d);
		} else {
			System.out.println("The denominator shouldn't be ZERO!");
			System.exit(0);
		}
	}

	int gcd(int a, int b) {
		if (b == 0)
			return (a);
		else
			return (gcd(b, a % b));
	}

	public String toString() {
		if (this.denominator != 0){
		StringBuilder builder = new StringBuilder();
		builder.append(numerator);
		builder.append("/");
		builder.append(denominator);
		String s = builder.toString();
		return s;
		}
		else return "The denominator shouldn't be zero!";
	}

	String toDecimal() {
		Double e = (double) numerator / (double) denominator;
		String dcm = String.valueOf(e);
		return dcm;
	}

	Fraction add(Fraction f) {
		Fraction newf = null;
		int newDenominator;
		int newNumerator;
		newDenominator = this.denominator * f.denominator;
		newNumerator = this.numerator * f.denominator + f.numerator
				* this.denominator;
		newf = new Fraction(newNumerator, newDenominator);
		return newf;
	}
}
