import java.util.ArrayList;
import java.util.Arrays;


public class sortArrayOfString {
	
	public static int count = 0;

	public static void main(String[] args) {
		String string = "ABCDEFGHIJKLM";
		ArrayList<String> resultArrayList = new ArrayList<String>();
		StringBuffer res = new StringBuffer();
		char[] characterOfString = string.toCharArray();
		Arrays.sort(characterOfString);
		boolean[] added = new boolean[characterOfString.length];
		
		dfs(resultArrayList, res, characterOfString, added);
		System.out.println("dfs total call: " + count);
		//System.out.print(resultArrayList);
	}



	private static void dfs(ArrayList<String> result, StringBuffer res, char[] character, boolean[] added){
		if (res.length() == character.length){
			result.add(new String(res.toString()));
			return;
		}
		
		for (int i = 0; i < character.length; i++){
			count++;
			if (added[i] || i > 0 && character[i] == character[i - 1] && added[i - 1] == false){
				continue;
			}
			
			added[i] = true;
			res.append(character[i]);
			dfs(result, res, character, added);
			res.deleteCharAt(res.length() - 1);
			added[i] = false;
		}	
	}
}
