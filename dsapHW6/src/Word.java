/*****************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * 
 * Homework 6: Building Index using BST
 * 
 * Andrew ID: xingzig
 * Name: Xingzi Guo
 * 
 *****************************************************/
import java.util.*;

public class Word implements Comparable<Word> {

	private String word;
	private Set<Integer> index; // word's line number in the source text
								// 有这个word的行号
	private int frequency; // counts occurrences of the word

	public Set<Integer> getIndex() {
		return index;
	}

	public String getWord() {
		return word;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public Word(String word) {
		this.word = word;
		this.frequency = 1;
		index = new HashSet<Integer>();
	}

	@Override
	public int compareTo(Word o) {
		return word.compareTo(o.word);
	}

	@Override
	public String toString() {
		return word + " " + frequency + " " + index;
	}

}