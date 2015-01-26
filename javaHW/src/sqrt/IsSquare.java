package sqrt;

import java.util.Scanner;

public class IsSquare {

	public static void main(String[] args) {
		System.out.println("please enter the number:");
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine() == true) {
			long getNum = in.nextLong();// get input
			double n = Math.sqrt(getNum);
			if (n == (int) n) {
				System.out
						.println("The number you entered is the square of n: "
								+ (int) n);
			} else {
				System.out
						.println("The number you entered is not the square of any integer");
			}

		}

	}

}
