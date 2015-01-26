import java.util.Arrays;


public class dotequals {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int[] b = {1,2,3,4,5};
		System.out.println(a.equals(b));
		System.out.println(a.toString());
		System.out.println(Arrays.toString(a));
		
		String str1 = "Happpy";
		String str2 = "Happpy"; // String class has overrided the .equals() while arrays didn't, when use 
		                        // a.equals(b), only to compare the references of the arrays.
		System.out.print(str1.equals(str2));
	}

}
