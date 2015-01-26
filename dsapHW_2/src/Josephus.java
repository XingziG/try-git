import java.util.*;

/**********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * 
 * Homework Assignment 2 Solve Josephus problem with different data structures
 * and compare running time
 * 
 * Andrew ID: xingzig Name: Xingzi Guo
 * 
 **********************************************************/

public class Josephus {

	/**
	 * This method uses ArrayDeque data structure as Queue/Deque to find the
	 * survivor's position.
	 * 
	 * @param size
	 *            Number of people in the circle that is bigger than 0.
	 * @param rotation
	 *            Elimination order in the circle. The value has to be greater
	 *            than 0.
	 * @return The position value of the survivor.
	 */
	public int playWithAD(int size, int rotation) {
		if (size < 1 || rotation < 1)
			throw new RuntimeException("Wrong input!");

		if (size == 1) {
			return 1;
		}
		ArrayDeque<Integer> AD = new ArrayDeque<Integer>(size);
		for (int i = 1; i <= size; i++) {
			AD.add(i);
		}

		// It is tricky because everytime when rotation = size, we need to
		// delete the last one
		// Thus, using (rotation-1) % size to count the step keeps the last one
		// stay at [0] when rotation = size
		while (size > 1) {
			int step = (rotation - 1) % size;
			for (int i = 0; i < step; i++) {
				int tmp = AD.removeFirst();
				AD.add(tmp);
			}
			AD.removeFirst();
			size--;
		}
		return AD.peekFirst();
	}

	/**
	 * This method uses LinkedList data structure as Queue/Deque to find the
	 * survivor's position.
	 *
	 * @param size
	 *            Number of people in the circle that is bigger than 0.
	 * @param rotation
	 *            Elimination order in the circle. The value has to be greater
	 *            than 0.
	 * @return The position value of the survivor.
	 */
	public int playWithLL(int size, int rotation) {
		if (size < 1 || rotation < 1)
			throw new RuntimeException("Wrong input!");

		if (size == 1) {
			return 1;
		}
		LinkedList<Integer> LL = new LinkedList<Integer>();
		for (int i = 1; i <= size; i++) {
			LL.add(i);
		}

		while (size > 1) {
			int step = (rotation - 1) % size;
			for (int i = 0; i < step; i++) {
				int tmp = LL.removeFirst();
				LL.add(tmp);
			}
			LL.removeFirst();
			size--;
		}
		return LL.peekFirst();
	}

	/**
	 * This method uses LinkedList data structure to find the survivor's
	 * position. However, this does not use the LinkedList as Queue/Deque.
	 * Instead, this method uses LinkedList as "Linked List."
	 *
	 * That means, it uses index value to find and remove a person to be
	 * executed in the circle.
	 *
	 * @param size
	 *            Number of people in the circle that is bigger than 0.
	 * @param rotation
	 *            Elimination order in the circle. The value has to be greater
	 *            than 0.
	 * @return The position value of the survivor.
	 */
	public int playWithLLAt(int size, int rotation) {
		if (size < 1 || rotation < 1)
			throw new RuntimeException("Wrong input!");

		if (size == 1) {
			return 1;
		}

		LinkedList<Integer> list = new LinkedList<Integer>();

		for (int i = 1; i <= size; i++)
			list.add(i);
		
		int startpoint = 0;
		int temp;
		while (size > 1) {
			temp = startpoint + rotation - 1;
			startpoint = temp % size;
			list.remove(temp % size);
			size--;
		}
		return list.getFirst();
	}
}

