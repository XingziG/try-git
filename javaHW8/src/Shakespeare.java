/**
 * @fileName Shakespeare.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 8-2 WordCount
 * @date Last Modified: 11/05/2014
 * @description: This is the main method to enter the program and start word count
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Shakespeare {
    public static void main(String[] args) throws FileNotFoundException {
    	System.setOut(new PrintStream(new File("/Users/xingzi/Desktop/test.log")));
    	//TODO remove the upper line!
    	
    	Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of a file and press Enter to start WordCount: ");
        String FileName = keyboard.nextLine();
        
        System.out.println("Enter the name of a file containing stopwords: ");
        String Stopwords = keyboard.nextLine();
        
        FindWordFrequencies findFrequencies = new FindWordFrequencies(FileName);
        
        long start, duration;
        start = System.currentTimeMillis();
        
        findFrequencies.buildStopwordlist(Stopwords);
        findFrequencies.buildWordFrequencyMap();
        
        duration = System.currentTimeMillis() - start;
        System.out.println("Duration = " + duration);
        System.out.println(findFrequencies.toString());
        System.out.println("Number of words is " + findFrequencies.numWords());
	}
}
