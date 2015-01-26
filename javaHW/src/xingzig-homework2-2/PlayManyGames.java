/**
 * @fileName PlayManyGames.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework2-2
 * @date Last Modified: 09/07/2014
 */

import java.util.Scanner;

public class PlayManyGames {

	public static void main(String[] args) {
		Game theGame = new Game();
		boolean doSwitchJob;
		Scanner in = new Scanner(System.in);

		while (true) {

			System.out
					.println("Do you want to always swich or never swich? Press 1-Always, 0-Never.");
			String i = in.next();
			double count = 0;

			if (i.equals("0") || i.equals("1")) {

				// If she choose never change:
				if (i.equals("0")) {
					doSwitchJob = false;
				} else {
					doSwitchJob = true;
				}

				for (int j = 0; j < 10000; j++) {
					theGame.setUpGame();
					theGame.contestantChooseDoor();
					theGame.openDoor();
					theGame.switchDoor(doSwitchJob);
					if (theGame.winning())
						count++;
				}
				System.out.println("The chance to win is: " + count / 10000);
				in.close();
				System.exit(0);
			}

			else {
				System.out
						.println("You didn't follow the instruction, please press 0 or 1.");
			}
		}
	}
}
