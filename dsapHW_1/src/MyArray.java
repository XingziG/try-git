public class MyArray {
	private String[] words;
	private int initialCapacity;
	private int size = 0;
	private static int defaultcapacity = 10;

	/**
	 * Constructs an empty list with the specified initial capacity.
	 *
	 * @param i
	 */
	public MyArray(int i) {
		initialCapacity = i;
		words = new String[initialCapacity];
	}

	/**
	 * Constructs an empty list with an default initial capacity of ten.
	 */
	public MyArray() {
		this(defaultcapacity);
	}

	/**
	 * Add string into MyArray
	 * 
	 * @param lowerCase is the string to be added
	 */
	public void add(String lowerCase) {

		String lc = lowerCase.toLowerCase();
		if (words.length == 0) { //if the length of  MyArray is 0, then set the capacity to be 1.
			words = new String[1];
		}

		if (lc.matches("^[a-zA-Z]+$")) {
			words[size] = lc;
			if (size == words.length - 1) {
				String[] newwords = new String[words.length * 2]; // already full, double up
				System.arraycopy(words, 0, newwords, 0, words.length);
				words = newwords;
			}
			size++;
		}
	}

	/**
	 * Search for the specific string
	 * 
	 * @param string
	 * @return boolean whether we find the string or not
	 */
	public boolean search(String string) {
		if (string == "")
			return false;
		for (int i = 0; i < size; i++) {
			if (words[i].equals(string)) {
				return true;
			} else
				continue;
		}
		return false;
	}

	/**
	 * Returns the number of elements in MyArray.
	 * 
	 * @return Returns the number of elements in MyArray.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns the capacity of the array
	 * 
	 * @return Returns the capacity of the array
	 */
	public int getCapacity() {
		return words.length;
	}

	/**
	 * Display every element in MyArray
	 */
	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.print(words[i] + " ");
		}
	}

	/**
	 * Remove dupicate words in the array
	 */
	public void removeDups() {
		if (words.length > 0) {
			for (int i = 1; i < size; i++) {
				String check = words[i];
				if (checkDup(check, i)) {
					shift(i);
					i = i - 1;
				}
			}
		}
	}

	/**
	 * Private method to check whether there is a duplicate of the string
	 * 
	 * @param check is the string to be checked for duplication
	 * @param i is the index of the check string
	 * @return boolean whether we find a duplicate
	 */
	private boolean checkDup(String check, int i) {
		for (int j = 0; j < i; j++) {
			if (words[j].equals(check))
				return true;
		}
		return false;
	}

	/**
	 * When we find a duplicate, we have to delete the duplication 
	 * and shift all the strings behind forward 1 position.
	 * 
	 * @param i is the string we need to delete
	 */
	private void shift(int i) {
		System.arraycopy(words, i + 1, words, i, size - i - 1);
		words[size - 1] = null;
		size--;
	}
}