
public class Solution2 {

public static void main(String[] args){
	
	String s = "a";
	System.out.println(isPalindrome(s));
}

	public static boolean isPalindrome(String s) {
        s = s.toLowerCase();

        s = s.replaceAll("\\W", "");
        char[] c = s.toCharArray();
        int head = 0;
        int tail = s.length() - 1;
        
        while (head <= s.length() - 1 && tail >= 0 && head <= tail){
            if(c[head] == c[tail]){
                head++;
                tail--;
                continue;
            }
            return false;
        }
        return true;
        Math.pow(a, b);
    }
	

}
