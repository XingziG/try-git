/**
 * @fileName Game.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework2-2
 * @date Last Modified: 09/07/2014
 */

import java.util.*;

public class Game {
	Door door1, door2, door3;

	void setUpGame() {
		door1 = new Door();
		door2 = new Door();
		door3 = new Door();
		// initialize all the Door variables to false
		// use random number to put prize in to the door
		Random r = new Random();
		int grandPrizeDoor = r.nextInt(3);
		switch (grandPrizeDoor) {
		case 0:
			door1.hasGrandPrize = true;
			break;
		case 1:
			door2.hasGrandPrize = true;
			break;
		case 2:
			door3.hasGrandPrize = true;
			break;
		}
	}

	// use random number to set the player's choice
	void contestantChooseDoor() {
		Random r = new Random();
		int contestantDoor = r.nextInt(3);

		switch (contestantDoor) {
		case 0:
			door1.chosenByContestant = true;
			break;
		case 1:
			door2.chosenByContestant = true;
			break;
		case 2:
			door3.chosenByContestant = true;
			break;
		}
	}

	void openDoor() {
		// if the prize is in door1
		if (door1.hasGrandPrize) {
			// if she chooses door1
			if (door1.chosenByContestant) {
				// random open door2 or door3
				Random r = new Random();
				int openADoor = r.nextInt(2);
				switch (openADoor) {
				case 0:
					door2.isOpened = true;
					break;
				case 1:
					door3.isOpened = true;
					break;
				}
			}
			// if she dosen't choose door1
			else if (door2.chosenByContestant) { // if she choose door2
				door3.isOpened = true;// open door3
			} else { // if she choose door3
				door2.isOpened = true;
			}
		}

		else if (door2.hasGrandPrize) {
			// she choose door1:
			if (door1.chosenByContestant) { //
				door3.isOpened = true; // open door3
			} else if (door2.chosenByContestant) {
				Random r = new Random();
				int openADoor = r.nextInt(2);
				switch (openADoor) {
				case 0:
					door1.isOpened = true;
					break;
				case 1:
					door3.isOpened = true;
					break;// randomly open door1 or door3
				}
			} else
				door1.isOpened = true;
		} else { // door3 has GrandPrize
			if (door1.chosenByContestant) { //
				door2.isOpened = true; // open door2
			} else if (door2.chosenByContestant) {
				door1.isOpened = true;// open door3
			} else {
				Random r = new Random();
				int openADoor = r.nextInt(2);
				switch (openADoor) {
				case 0:
					door1.isOpened = true;
					break;
				case 1:
					door2.isOpened = true;
					break;// randomly open door1 or door3
				}
			}
		}
	}

	void switchDoor(boolean a) {
		if (!a) {
			return;
		} else {
			if (door1.chosenByContestant) {
				door1.chosenByContestant = false;
				if (door2.isOpened)
					door3.chosenByContestant = true;
				else
					door2.chosenByContestant = true;
			} else if (door2.chosenByContestant) {
				door2.chosenByContestant = false;
				if (door1.isOpened)
					door3.chosenByContestant = true;
				else
					door1.chosenByContestant = true;
			} else {
				door3.chosenByContestant = false;
				if (door1.isOpened)
					door2.chosenByContestant = true;
				else
					door1.chosenByContestant = true;
			}

		}
	}

	boolean winning() {
		if ((door1.hasGrandPrize && door1.chosenByContestant)
				|| (door2.hasGrandPrize && door2.chosenByContestant)
				|| (door3.hasGrandPrize && door3.chosenByContestant))
			return true;
		else
			return false;
	}
}
