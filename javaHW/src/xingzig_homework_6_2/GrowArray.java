/**
 * @fileName GrowArray.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 6-2 re-write arrayGrow() method
 * @date Last Modified: 10/20/2014
 * @description: Re-write the arrayGrow() method from the book (and the course notes) 
 * so that it works properly for two-dimensional arrays. Increase both dimensions by 4. 
 * Write a driver program to show your new method works for a 2x3 initial array. 
 * The new array should be 6x7.
 * 
 * Let's attempt to first grow the second dimension (from 2x3 to 2x7) of the original array,
 * and then add a new 2D array (4x7) to the back of the array. 
 */
package xingzig_homework_6_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GrowArray {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } }; // original array size 2*3
		int[][] b = null;						  // b is the grown array
		b = (int[][]) arrayGrow(a);
		System.out.println("Original array:");
		for (int[] row : a) {
			for (int num : row)
				System.out.print(num+" ");
			System.out.println();
		}
		
		System.out.println("The grown array:");
		for (int[] row : b) {
			for (int num : row)
				System.out.print(num+" ");
			System.out.println();
		}
	}

	/**
	 * @param a is the 2D array that you want to grow
	 * @return grown 2D array
	 */
	static Object arrayGrow(Object a) {
		Class cl = a.getClass(); //get the class, the class of a[][] is 2D array
		if (!cl.isArray())
			return null;
		int length = Array.getLength(a); // get the length of a[][]
		Class componentType = cl.getComponentType(); // the componentType is 1D array
		Object tmp = Array.newInstance(componentType, length); // generate a copy of a[][]
		System.arraycopy(a, 0, tmp, 0, length); // copy the array a[][]

		for (int i = 0; i < length; i++) { // start to grow the 1D-arrays in tmp[][]
			Object newSmallArray = oneDimensionalArrayGrow(Array.get(tmp, i)); // using Array.get(Object array, int index), I can get each small 1D array in tmp[][]
																 // then use arrayGrow() method to grow each small 1D array
			Array.set(tmp, i, newSmallArray);// I need to replace the original small array (1*3)s with the grown small array (1*7)s
		}

		Object grownarray = oneDimensionalArrayGrow(tmp);  // now grownarray is the (2*7) semifinished array
		
		/*
		 * now start to add the (4*7) 2D array
		 */
		Class componentType1 = Array.get(grownarray, 0).getClass().getComponentType(); // get the componentType of grownarray[][], it is 1D array
		int newLength = Array.getLength(Array.get(grownarray, 0)); // get the 1D array's length, which is 7
		for (int i = 0; i < 4; i++) {
			Array.set(grownarray, length + i, Array.newInstance(componentType1, newLength)); // add 4 (1*7) 1D arrays to the grownarray
		}
		return grownarray;
	}

	/**
	 * @param a is the 1D array that you want to grow
	 * @return grown 1D array
	 */
	static Object oneDimensionalArrayGrow(Object a) {
		Class cl = a.getClass(); // cl refers to the class of a, which is a 1D array here
		if (!cl.isArray())
			return null;

		Class componentType = cl.getComponentType(); // componentType refers to the data type in the array, which is int here

		int length = Array.getLength(a); // get the length of the array
		int newLength = length + 4;
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(a, 0, newArray, 0, length);
		return newArray;
	}

}
