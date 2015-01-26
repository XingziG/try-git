package tests;

public class testtostring {
	public static void main(String[] arg){
	String content = new String("whatisthedatetoday?");
	char[] getchar = content.toCharArray();
	java.util.Arrays.sort(getchar);
	System.out.println(getchar);
	}
	
}
