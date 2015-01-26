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
import java.io.*;
import java.util.*;

public class Index {

	/**
	 * Build a tree giving a file name
	 * 
	 * @param fileName
	 *            - input file name
	 * @return BST object
	 */
	public BST<Word> buildIndex(String fileName) {
		return buildIndex(fileName, null);
	}

	/**
	 * Build a tree with a file name and comparator object
	 * 
	 * @param fileName
	 *            - input file name
	 * @param comparator
	 *            - comparator to be used
	 * @return BST object
	 */
	public BST<Word> buildIndex(String fileName, Comparator<Word> comparator) {
		if (fileName == null) {
			System.err.println("null file");
			return null;
		} else {
			BST<Word> bst = new BST<Word>(comparator);
			return buildTreeIndex(fileName, bst);
		}
	}

	private BST<Word> buildTreeIndex(String fileName, BST<Word> bst) {
		int lineNum = 0;
		boolean iC = false;
		Scanner in = null;
		try {
			File file = new File(fileName);
			in = new Scanner(file);
			if (bst.comparator() instanceof IgnoreCase)
				iC = true;

			while (in.hasNextLine()) {
				lineNum++;

				String line = in.nextLine();

				if (iC) {
					line = line.toLowerCase();
				}
				String[] wordsFromText = line.split("\\W");
				for (String word : wordsFromText) {
					if (word.matches("^[a-zA-Z]+$")) {
						Word newWord = new Word(word);
						Word inTreeWord = bst.search(newWord);
						if (inTreeWord != null) {
							inTreeWord.setFrequency(inTreeWord.getFrequency() + 1);
							inTreeWord.getIndex().add(lineNum);
						} else {
							newWord.getIndex().add(lineNum);
							bst.insert(newWord);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Cannot find the file");
		} finally {
			if (in != null)
				in.close();
		}
		return bst;
	}

	/**
	 * Build a tree with a given list and comparator
	 * 
	 * @param list
	 *            - ArrayList of words
	 * @param comparator
	 *            - comparator to be used
	 * @return BST object
	 */
	public BST<Word> buildIndex(ArrayList<Word> list, Comparator<Word> comparator) {
		if (list == null) {
			System.err.println("null list");
			return null;
		}
		BST<Word> bst = new BST<Word>(comparator);
		for (Word word : list) {
			bst.insert(word);
		}
		return bst;
	}

	/**
	 * Sort words alphabetically Note: Should keep the state of the tree
	 * 
	 * @param tree
	 *            - BST tree
	 * @return ArrayList of words sorted alphabetically
	 */
	public ArrayList<Word> sortByAlpha(BST<Word> tree) {

		if (tree == null) {
			System.err.println("null tree");
			return null;
		}

		ArrayList<Word> wl = new ArrayList<Word>();
		for (Word word : tree) {
			wl.add(word);
		}
		Collections.sort(wl);
		return wl;
	}

	/**
	 * Sort words by frequency Note: Should keep the state of the tree
	 * 
	 * @param tree
	 *            - BST tree
	 * @return ArrayList of words sorted by frequency
	 */
	public ArrayList<Word> sortByFrequency(BST<Word> tree) {
		if (tree == null) {
			System.err.println("null tree");
			return null;
		}

		ArrayList<Word> wl = new ArrayList<Word>();
		for (Word word : tree) {
			wl.add(word);
		}
		Collections.sort(wl, new Frequency());
		return wl;
	}
Date
	/**
	 * Find all words of the highest frequency Note: Should keep the state of
	 * the tree
	 * 
	 * @param tree
	 *            - BST tree
	 * @return ArrayList of words that have highest frequency
	 */
	public ArrayList<Word> getHighestFrequency(BST<Word> tree) {
		if (tree == null) {
			System.err.println("null tree");
			return null;
		}

		ArrayList<Word> fwList = sortByFrequency(tree);
		ArrayList<Word> wl = new ArrayList<Word>();

		if (fwList.size() == 0) {
			return null;
		} else {
			Word Word = fwList.get(0);// 0?

			for (Word word : fwList) {
				if (word.getFrequency() == Word.getFrequency()) {
					wl.add(word);
				} else
					break;
			}
		}
		return wl;

	}

}