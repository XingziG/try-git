


public class Solution {
    public static void main(String[] args){
    	String a = new String("a b c      ");
    	String b = new String("abc");
    	if (a.equals(b)) System.out.println("true");
    	if (!a.equals(b)) System.out.println("false");
    	a = a.replace(" ", "%20");
    	System.out.println(a);
    
    }
}
