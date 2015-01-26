/**
 * @fileName This file: Fraction.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework3-2
 */

public class BinominalTree {
	int periodNum;
	double currentPrise;
	double upwardPrise;
	double[][] odds;

	// allocate array
	public BinominalTree(double p, double u, int n) {
		periodNum = n;
		currentPrise = p;
		upwardPrise = u;
		double d = 1 / u;
		odds = new double[n + 1][];
		for (int i = 0; i <= n; i++)
			odds[i] = new double[i + 1];

		// fill the array
		for (int i = 0; i < odds.length; i++)
			for (int j = 0; j < odds[i].length; j++) {

				/* conpute binominal tree */
				double stockPrice = p;
				odds[i][j] = stockPrice * Math.pow(u, j) * Math.pow(d, i - j);
			}
	}

	void PrintTree() {

		for (double[] row : odds) {
			for (double odd : row)
				System.out.printf("%4.2f" + "\t", odd);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out
				.println("This program will create and print the tree with p=$50.00, n=5 and u= 1.1224.");
		BinominalTree stock = new BinominalTree(50, 1.1224, 5);
		stock.PrintTree();

	}
}
