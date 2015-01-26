/*********************************************************
 * 
 * 95-772 Data Structures for Application Programmers
 * 
 * Homework 4 HashTable Implementation
 * 
 * Andrew ID: xingzig Name: Xingzi Guo
 * 
 *********************************************************/

public class MyHashTable implements MyHTInterface {
	/**
	 * use DataItem array as an hashTable
	 */
	private DataItem[] myhashArray;

	/**
	 * This is the array length
	 */
	private int arrayLength;

	/**
	 * if the capacity is not given by the user, the default capacity is 10
	 */
	private static int DEFAULT_CAPACITY = 10;

	private float loadFactor = 0.5f;

	/**
	 * the value of threshold is (int)(arrayLength * loadFactor)
	 */
	private int threshold;

	/**
	 * the number of items in the hashTable
	 */
	private int count = 0;

	/**
	 * keep track of the number of collisions in the hashTable
	 */
	private int numOfCollision = 0;

	private DataItem nonItem = new DataItem("#DEL#"); // mark the deleted item

	/**
	 * implement constructor with no initial arrayLength The default arrayLength
	 * is 10, which is not a prime number...
	 */
	public MyHashTable() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * user pass the initial capacity to the constructor
	 * 
	 * the passCapacity must not be <= 0 or bigger than the maximun value of
	 * integer
	 * 
	 * @param passCapacity
	 */
	public MyHashTable(int passCapacity) {
		if (passCapacity <= 0 || passCapacity >= Integer.MAX_VALUE) {
			System.err.println("Illegal Capacity: " + passCapacity);
			System.exit(passCapacity);
		}

		else {
			arrayLength = passCapacity;
			myhashArray = new DataItem[arrayLength];
		}
	}

	/**
	 * Inserts a new String value (word). Frequency of each word be stored too.
	 * 
	 * @param value
	 *            String value to be added.
	 */
	@Override
	public void insert(String value) {
		if (value == null
				|| !(value.matches("^[a-zA-Z]+$") || value.equals(" "))) {
			return;
		}
		

		DataItem Item = new DataItem(value);
		int currhashVal = hashFunc(value);
		int hashVal = currhashVal;
		boolean collision = false;

		if (contains(value)) {
			for (int i = 0; i < myhashArray.length; i++) {
				if (myhashArray[i] == null
						|| !myhashArray[i].value.equals(value)) {
					continue;
				} else {
					myhashArray[i].frequency += 1;
				}
			}
		}

		else {
			while (myhashArray[hashVal] != null
					&& !myhashArray[hashVal].value.equals("#DEL#")) {
				// find an empty or available bucket
				if (currhashVal == hashValue(myhashArray[hashVal].value))
					collision = true;
				hashVal++;
				hashVal = hashVal % arrayLength;
			}
			myhashArray[hashVal] = Item;
			count++;
			if (collision) {
				numOfCollision++;
			}
		}

		threshold = (int) (arrayLength * loadFactor);
		if (size() > threshold) { // threshold = (int)(arrayLength * loadFactor)
			rehash();
		}

	}

	/**
	 * Returns the size, number of items, of the hashTable
	 * 
	 * @return the number of items in the table.
	 */
	@Override
	public int size() {
		return count;
	}

	/**
	 * Displays the values of the table If an index is empty, it shows ** If
	 * previously existed dataitem is deleted, then it should show #DEL#
	 */
	@Override
	public void display() {
		System.out.print("Table: ");
		for (int i = 0; i < myhashArray.length; i++) {
			if (myhashArray[i] == null)
				System.out.print("** ");
			else if (myhashArray[i].value.equals("#DEL#")) {
				System.out.print("#DEL# ");
			} else {
				System.out.print("[" + myhashArray[i] + "] ");
			}
		}
		System.out.println();
	}

	/**
	 * Returns true if value is contained in the table
	 * 
	 * @param key
	 *            String key value to be searched
	 * @return true if found, false if not found.
	 */
	@Override
	public boolean contains(String key) {
		if (key == null) {
			return false;
		}

		else if (key.matches("^[a-zA-Z]+$") || key.equals(" ")) {
			int hashVal = hashFunc(key);
			while (myhashArray[hashVal] != null) {
				if (myhashArray[hashVal].value.equals(key))
					return true;
				hashVal++;
				hashVal = hashVal % arrayLength;
			}
			return false;
		}
		return false;
	}

	/**
	 * Returns the number of collisions in relation to insert and rehash.
	 * 
	 * When rehashing process happens, the number of collisions should be
	 * properly updated.
	 * 
	 * The definition of collision is
	 * "two different keys map to the same hash value." Be careful with the
	 * situation where you could over count. Try to think as if you are using
	 * separate chaining! "How would you count the number of collisions?"
	 * 
	 * @return number of collisions
	 */
	@Override
	public int numOfCollisions() {
		return numOfCollision;
	}

	/**
	 * Returns the hash value of a String
	 * 
	 * @param value
	 *            value for which the hash value should be calculated
	 * @return int hash value of a String.
	 */
	@Override
	public int hashValue(String value) {
		return hashFunc(value);
	}

	/**
	 * Returns the frequency of a key String
	 * 
	 * @param key
	 *            key string value to find its frequency
	 * @return frequency value if found. If not found, return 0
	 */
	@Override
	public int showFrequency(String key) {
		if (key != null && (key.matches("^[a-zA-Z]+$") || key.equals(" "))) {
			int hashVal = hashFunc(key);
			while (myhashArray[hashVal] != null) {
				if (myhashArray[hashVal].value.equals(key)) {
					DataItem result = myhashArray[hashVal];
					return result.frequency;
				}
				hashVal++;
				hashVal = hashVal % arrayLength;
			}
			return 0;
		}
		return 0;
	}

	/**
	 * Removes and returns removed value
	 * 
	 * @param value
	 *            String value to be removed
	 * @return value that is removed
	 */
	@Override
	public String remove(String key) {
		if (key != null && (key.matches("^[a-zA-Z]+$") || key.equals(" "))) {
			int hashVal = hashFunc(key);
			while (myhashArray[hashVal] != null) {
				if (myhashArray[hashVal].value.equals(key)) {
					DataItem result = myhashArray[hashVal];
					myhashArray[hashVal] = nonItem; // mark the deleted item
					count--;
					return result.value;
				}
				hashVal++;
				hashVal = hashVal % arrayLength;
			}
			return null;
		}
		return null;
	}

	/**
	 * Instead of using String's hashCode, you are to implement your own here,
	 * taking the table length into your account.
	 * 
	 * In other words, you are to combine the following two steps into one step
	 * here. 1. converting Object into integer value 2. compress into the table
	 * using modular hashing
	 * 
	 * Helper method to hash a string for English lowercase alphabet and blank,
	 * we have 27 total.
	 * 
	 * For example, "cats" : 3*27^3 + 1*27^2 + 20*27^1 + 19*27^0 = 60,337
	 * 
	 * But, to make the hash process faster, Horner's method should be applied
	 * as follows;
	 * 
	 * var4*n^4 + var3*n^3 + var2*n^2 + var1*n^1 + var0*n^0 can be rewritten as
	 * (((var4*n + var3)*n + var2)*n + var1)*n + var0
	 * 
	 * Note: You must use 27 for this homework. However, if you have time, I
	 * would encourage you to try with other constant values other than 27. And
	 * compare the results but it is not required.
	 */
	private int hashFunc(String input) {
		double key = 0;
		int hashValue;
		if (input != null
				&& (input.matches("^[a-zA-Z]+$") || input.equals(" "))) {
			for (int i = 0; i < input.length(); i++) {
				int j;

				char c = input.charAt(i);
				if (c >= 'a' && c <= 'z')
					j = c - 96;
				else if (c >= 'A' && c <= 'Z') {
					j = c - 64 + 26;
				} else {
					j = 0;
				}

				key = (27 * key + j) % arrayLength;
			}
			hashValue = (int) (key % arrayLength);

			return hashValue;
		}
		System.err.println("arguments should be lower case words");
		return -1;
	}

	// doubles array length and rehash items whenever the load factor is reached
	private void rehash() {
		boolean collision = false;
		numOfCollision = 0; // set back to 0
		count = 0;
		arrayLength = myhashArray.length * 2; // to update arrayLength =
												// myhashArray.length * 2
		while (!isPrime(arrayLength)) {
			arrayLength++;
		}

		if (arrayLength >= Integer.MAX_VALUE / 2)
			return;

		DataItem[] oldhashArray = new DataItem[myhashArray.length]; // store the
																	// old hash
																	// table
		System.arraycopy(myhashArray, 0, oldhashArray, 0, myhashArray.length); // copy
																				// from
																				// the
																				// old
																				// hashtable
		myhashArray = new DataItem[arrayLength]; // become the new hash table

		for (int i = 0; i < oldhashArray.length; i++) {
			DataItem item = oldhashArray[i];
			if (item != null && !item.value.equals("#DEL#")) {
				int currhashVal = hashFunc(item.value);
				int hashVal = currhashVal;

				while (myhashArray[hashVal] != null) {
					if (currhashVal == hashValue(myhashArray[hashVal].value))
						collision = true;
					hashVal++;
					hashVal = hashVal % arrayLength;
				}
				myhashArray[hashVal] = item; // insert into myhashArray
				count++;
			}
		}
		if (collision)
			numOfCollision++;
		System.out.println("Rehashing " + count + " items, new size is "
				+ arrayLength);
	}

	/**
	 * check the number is a prime number or not
	 * 
	 * @param number
	 * @return
	 */
	private boolean isPrime(int number) {
		if (number >= 2) {
			if (number == 2)
				return true;
			else {
				for (int i = 2; i < number / 2; i++) {
					if (number % i == 0)
						return false;
				}
				return true;
			}
		}
		return false;
	}

	// private static data item nested class
	private static class DataItem {
		private String value; // the value of the item
		private int frequency = 1; // when construct, set frequency = 1

		/**
		 * constructor of DataItem class
		 * 
		 * @param value
		 */
		public DataItem(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value + ", " + frequency;
		}

	}

}