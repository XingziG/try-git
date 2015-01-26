/*******************************************************
 * 
 * 95-772 Data Structures for Application Programmers 
 * 
 * Homework 5 Document Similarity
 * 
 * Name: Xingzi Guo
 * ID: xingzig
 * 
 *******************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Similarity {

	HashMap<String, Integer> freqOfWords = new HashMap<String, Integer>(16,
			0.65f);
	int numOfWords = 0;
	int numberOfLines = 0;

	/**
	 * This constructor takes a string
	 * 
	 * @param string
	 */
	public Similarity(String string) {
		if (string == null)
			return;
		String lc = string.toLowerCase();
		String[] words = lc.split("\\W");
		for (String word : words) {
			if (word.matches("^[a-zA-Z]+$")) {
				if (freqOfWords.get(word) == null)
					freqOfWords.put(word, 1);
				else
					freqOfWords.put(word, freqOfWords.get(word) + 1);
				numOfWords++;
			}
		}
	}

	/**
	 * This constructor takes a file
	 * 
	 * @param file
	 */
	public Similarity(File file) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				numberOfLines++;
				String line = scanner.nextLine().toLowerCase();
				String[] wordsFromText = line.split("\\W");

				for (String word : wordsFromText) {
					if (word.matches("^[a-zA-Z]+$")) {
						Integer frequency = freqOfWords.get(word);
						if (frequency == null)
							frequency = 1;
						else
							frequency++;
						freqOfWords.put(word, frequency);
						numOfWords++;
					}
				}

			}
		} catch (FileNotFoundException e) {
			System.err.println("Cannot find the file");
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}

	/**
	 * Calculate the euclidean norm
	 * 
	 * @return the value of euclidean norm
	 */
	public double euclideanNorm() {
		return countEuclideanNorm(freqOfWords);
	}

	/**
	 * Helper method to calculate the euclidean norm
	 * 
	 * @param map
	 * @return the value of euclidean norm
	 */
	private double countEuclideanNorm(HashMap<String, Integer> map) {
		if (map == null) {
			System.err.println("wrong argument: null");
			return 0.0;
		}
		double sum = 0;
		for (String key : map.keySet()) {
			sum = sum + Math.pow(map.get(key), 2);
		}
		return Math.sqrt(sum);
	}

	/**
	 * Calculate the dot product value of two map. The data structure we use is
	 * hashmap. It takes constant searching time, so the running time complexity
	 * won't be quadratic.
	 * 
	 * @param map
	 * @return the dot product of two map
	 */
	public double dotProduct(HashMap<String, Integer> map) {
		if (map == null) {
			System.err.println("wrong argument: null");
			return 0.0;
		}
		double sumProduct = 0.0;
		for (String key : map.keySet()) {
			if (freqOfWords.get(key) != null) {
				sumProduct = sumProduct + (double) freqOfWords.get(key)
						* (double) map.get(key);
			}
		}
		return sumProduct;
	}

	/**
	 * Calculate the distance via the method of cosine similarity.
	 * 
	 * Taking care of the problem when one of the mapsize is 0, the denominator
	 * will be zero.
	 * 
	 * Because of precision of {@code cosine}, we should also take care of the
	 * situation that the value of cosine is bigger than 1.
	 * 
	 * @param map
	 * @return distance of the two map
	 */
	public double distance(HashMap<String, Integer> map) {
		double cosine;
		double dist;
		if (map == null) {
			System.err.println("wrong argument: null");
			return 0.0;
		}

		if (freqOfWords.size() == 0) {
			if (map.size() == 0)
				return 0.0;
			else
				return Math.PI / 2;
		} else if (map.size() == 0) {
			return Math.PI / 2;
		} else {
			cosine = this.dotProduct(map)
					/ (countEuclideanNorm(freqOfWords) * countEuclideanNorm(map));
			if (cosine > 1)
				cosine = 1;
			dist = Math.acos(cosine);
			return dist;
		}
	}

	public String numOfWords() { // keep track of it when adding words
		return String.valueOf(numOfWords);
	}

	public String numOfWordsNoDups() { // this is mapsize()
		return String.valueOf(freqOfWords.size());
	}

	public HashMap<String, Integer> getMap() {
		return freqOfWords;
	}

	public String numberOfLines() {
		return String.valueOf(numberOfLines);
	}

}
