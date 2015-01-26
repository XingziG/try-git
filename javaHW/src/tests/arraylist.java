package tests;

import java.util.ArrayList;

public class arraylist {
	public static void main(String[] args){
		ArrayList<Integer> number = new ArrayList<Integer>(0);
		for (int i = 0; i<10; i++)
			number.add(i);
			System.out.println(number);
		for (int i=0; i<number.size(); i++)
			if (number.get(i)%2==0) number.remove(i);
		System.out.println(number);
	}
}
