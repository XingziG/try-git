import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;


public class question2 {

	public static void main(String[] args) {
		TreeMap<String, Integer> bagOfWords = new TreeMap<String, Integer>();
		splitText(args[0], bagOfWords);
		int i = 0;
		for (String key : bagOfWords.keySet()) {
			System.out.print(key + ":" + bagOfWords.get(key));
		
			if (i == bagOfWords.keySet().size() - 1){
				continue;
			}
			else{
				System.out.print(",");
				i++;
			}
		}
	}

	private static void splitText(String fileName, TreeMap<String, Integer> bagOfWords) {
		Scanner scanner = null;
		try {
			File file = new File(fileName);
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().toLowerCase();
			String[] wordsFromText = line.split(" ");

			for (String nextWord : wordsFromText) {
				if (nextWord == null
						|| !(nextWord.matches("^[a-zA-Z]+$"))) {
					continue;
				}
				
				if (bagOfWords.containsKey(nextWord)) {
					Integer frequency = bagOfWords.get(nextWord) + 1;
					bagOfWords.put(nextWord, frequency);
				}
				else{
					bagOfWords.put(nextWord, 1);
				}
			}
		}
	}
}