/**
 * @fileName FindWordFrequencies.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 8-2 WordCount
 * @date Last Modified: 11/05/2014
 * @description: This class will build WordFrequencyMap and Stopwordlist
 */

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class FindWordFrequencies {
	Scanner s = null;
	Scanner l = null;
	WordFrequencies wf = new WordFrequencies();

	FindWordFrequencies() {
	}

	FindWordFrequencies(String fileName) {
		try {
			File f = new File(fileName);
			s = new Scanner(f);
			s.useDelimiter("[^a-zA-Z]+");
		} catch (FileNotFoundException e) {
		}
	}

	void buildWordFrequencyMap() {
		String nextWord = null;
		while (s.hasNext()) { // haven'reached EOF
			nextWord = s.next();
			nextWord = nextWord.toLowerCase();
			wf.put(nextWord);
		}
	}

	void buildStopwordlist(String list) {
		try {
			File f = new File(list);
			l = new Scanner(f);
			// l.useDelimiter("[^a-zA-Z]+"); //it depends on whether we want to delimit the words
		} catch (FileNotFoundException e) {
		}

		String nextWord = null;
		while (l.hasNext()) { // haven'reached EOF
			nextWord = l.next();
			nextWord = nextWord.toLowerCase();
			wf.putStopword(nextWord);
		}
	}

	public int numWords() {
		return wf.numWords();
	}

	public String toString() {
		return wf.toString();
	}
}
