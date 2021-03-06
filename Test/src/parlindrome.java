import java.util.ArrayList;
import java.util.List;




public class parlindrome {
	
	public static int count = 0;

		public List<List<String>> partition(String s) {
	        ArrayList<List<String>> result = new ArrayList<List<String>>();
	        if (s == null){
	            return result;
	        }
	        
	        ArrayList<String> subResult = new ArrayList<String>();
	        dfs(result, subResult, 0, s);
	        return result;
	    }
	    
	    private void dfs(ArrayList<List<String>> result, ArrayList<String> subResult, int pos, String s){
	        if (pos == s.length()){
	            result.add(new ArrayList<String>(subResult));
	            return;
	        }
	        
	        for (int i = pos + 1; i <= s.length(); i++){
	        	count++;
	            String wantedParld = s.substring(pos,i);
	            if (!isParlindrome(wantedParld)){
	                continue;
	            }
	            
	            subResult.add(wantedParld);
	            dfs(result, subResult, i, s);
	            subResult.remove(subResult.size() - 1);
	        }
	    }
	    
	    private boolean isParlindrome(String s){
	        int begin = 0;
	        int end = s.length() - 1;
	        while (begin < end){
	            if (s.charAt(begin) != s.charAt(end)){
	                return false;
	            }
	            begin++;
	            end--;
	        }
	        return true;
	    }
	    
	    
	public static void main(String[] args) {
		new parlindrome().partition("aaaa");
		
		System.out.println(count);
	}

}
