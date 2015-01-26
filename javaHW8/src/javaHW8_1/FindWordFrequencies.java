package javaHW8_1;

/**
 * @fileName FindWordFrequencies.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 8-1 WordCount
 * @date Last Modified: 11/05/2014
 * @description: This class will build WordFrequencyMap
 */

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class FindWordFrequencies {
    Scanner s = null;
    WordFrequencies wf = new WordFrequencies();
    FindWordFrequencies() {}
    FindWordFrequencies(String fileName) {
    	try {
    		File f = new File(fileName);
    		s = new Scanner(f);
    		s.useDelimiter("[^a-zA-Z]+");
    	}
    	catch ( FileNotFoundException e) {}

    }
    void buildWordFrequencyMap() {
        String nextWord = null;
        while (s.hasNext()) {   // haven'reached EOF
        	nextWord = s.next();
            nextWord = nextWord.toLowerCase();
            wf.put(nextWord);
        }
    }
    public int numWords() {return wf.numWords(); }
    public String toString() { return wf.toString(); }
}
