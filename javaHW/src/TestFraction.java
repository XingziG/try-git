/**
 * @fileName This file: TestFraction.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework3-1
 */

public class TestFraction {
	public static void main(String[] args) {
		Fraction f1 = new Fraction();
		Fraction f2 = new Fraction(1, 3);
		Fraction f3 = new Fraction(3, 6);

		System.out.println("f1 = " + f1);
		System.out.println("f2 = " + f2);
		System.out.println("f3 = " + f3);
		System.out.println("f1 + f2 = " + f1.add(f2));
		System.out.println("f2 in decimal is: " + f2.toDecimal());
	}
}
