package javaHW8_1;

/**
 * @fileName Shakespeare.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 8-1 WordCount
 * @date Last Modified: 11/05/2014
 * @description: This is the main method to enter the program and start word count
 */

import java.util.Scanner;

public class Shakespeare {
    public static void main(String[] args) {
    	
    	Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of a file and press Enter to start WordCount: ");
        String FileName = keyboard.nextLine();
        
        FindWordFrequencies findFrequencies
            = new FindWordFrequencies(FileName);
        long start, duration;
        start = System.currentTimeMillis();
        findFrequencies.buildWordFrequencyMap();
        duration = System.currentTimeMillis() - start;
        System.out.println("Duration = " + duration);
        System.out.println(findFrequencies.toString());
        System.out.println("Number of words is " + findFrequencies.numWords());
	}
}
