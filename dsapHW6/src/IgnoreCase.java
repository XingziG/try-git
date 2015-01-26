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

public class IgnoreCase implements Comparator<Word> {

	@Override
	public int compare(Word o1, Word o2) {
		return o1.getWord().compareToIgnoreCase(o2.getWord());
	}

}