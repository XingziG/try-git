package dsaplab1;

/*************************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * Lab 1 ArrayList time comparison and String manipulation
 * 
 * Comparing ArrayList operations (add to the end VS. remove)
 *
 *************************************************************/

import java.util.*;

public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList<Integer> tmp = new ArrayList<Integer>();
		int size = 100000;

		// running time of adding values to the end
		Stopwatch timer1 = new Stopwatch();
		for (int i = 0; i < size; i++)
			tmp.add(i);

		System.out.println("running time for adding " + size
				+ " items into arraylist : " + timer1.elapsedTime()
				+ " millisec");

		// running time of removal
		Stopwatch timer2 = new Stopwatch();
		for (int i = 0; i < size; i++) {
			//tmp.remove(0);
			//tmp.remove(tmp.size()/2);
			 tmp.remove(tmp.size()-1);
		}

		System.out.println("running time for removing " + size
				+ " items from arraylist : " + timer2.elapsedTime()
				+ " millisec");
	}

}
