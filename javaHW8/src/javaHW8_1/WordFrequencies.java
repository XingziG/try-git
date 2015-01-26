package javaHW8_1;

/**
 * @fileName WordFrequencies.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 8-1 WordCount
 * @date Last Modified: 11/05/2014
 * @description: This class holds Maps, each pair of which holds as key a String and as value
 * a WordCount.
 */
import java.util.*;

public class WordFrequencies {
    public HashMap<String, WordCount> hm = new HashMap<String, WordCount>();
    /**
     * Inserts a new word into the map, or if the word already exists,
     * increments its word count.
     * @param c the word to be added.
     */
    public void put(String c) {
        if (hm.containsKey(c))
            ((WordCount)hm.get(c)).i++;
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
     * @return 
     */
    public int numWords() { return hm.size(); }
}
