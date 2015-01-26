/**
 * @fileName WordFrequencies.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 8-2 WordCount
 * @date Last Modified: 11/05/2014
 * @description: This class holds Maps, each pair of which holds as key a String and as value
 * a WordCount. We first generate the stop-words map. When adding a word from the artical, I first check
 * whether it is exist in the stop-words map(sw). If it is not, we add it to the wold-count map(hm), otherwise
 * we omit this word.
 */
import java.util.*;
public class WordFrequencies {
	public HashMap<String, WordCount> hm = new HashMap<String, WordCount>(); // this map holds word count
	public HashMap<String, Integer> sw = new HashMap<String, Integer>(); // this map holds stop words 

	/**
	 * Inserts stop words in to the map
	 * 
	 * @param s
	 * 			the word to be added as one of the stop words
	 */
	public void putStopword(String s){
		sw.put(s, null);
	}
	
	/**
	 * Inserts a new word into the map, or if the word already exists,
	 * increments its word count.
	 * 
	 * @param c
	 *            the word to be added.
	 */	
	public void put(String c) {
		
		if (sw.containsKey(c)) {
			return;
		}
		
			if (hm.containsKey(c))
				((WordCount) hm.get(c)).i++;
			else
				hm.put(c, new WordCount());
		}
	

	/* As is required by the professor, we should use Hashmap to hold the word count 
	 * and print it out alphabatically, so I override the toString() method.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Object[] keys = hm.keySet().toArray();
		Arrays.sort(keys);
		StringBuffer printout = new StringBuffer();
		for(Object key : keys) {
			  printout.append(key + "=").append(hm.get(key) + " ");
			}
		return printout.toString();
	}

	/**
	 * Returns the number of different words in the map.
	 * 
	 * @return
	 */
	public int numWords() {
		return hm.size();
	}
}
