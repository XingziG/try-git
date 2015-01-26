public class removedup {
	public static void main(String[] args) {
		String[] words = {"s","happy","boy","s","what","hi","s"};
		if (words.length > 0) {
			for (int i = 1; i < words.length; i++) {
				String check = words[i];
				for (int j = 0; j < i; j++) {
					if(words[j] == null) continue;
					
					if (words[j].equals(check))
						
				}
			}
		}
		int view, seat, n;
		n = view = seat = words.length;
		while (view > 0) {
			String temp = words[--view];
			if (temp != null) {
				words[--seat] = temp;
			}
		}
		//System.arraycopy(words, seat, words, 0, );
		for (String wo : words)
		System.out.println(wo);
	}
}
