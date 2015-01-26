import java.math.BigInteger;


public class test {

	public static void main(String[] args) {
		String input = "cats";
		double numerator = 0;
		//double numerator2 = 0;
		int remain = 0;
		int hashValue;
		for (int i = 0; i < input.length(); i++) {
			int j;

			char c = input.charAt(i);
			if (c > 96 && c < 123){
				j = c - 96;
			System.out.println(j);
			}
			else {
				j = 0;
			}	
			numerator = 27 * numerator + j;	
		}
		hashValue = (int) (numerator % 10);
		
		System.out.println(hashValue);
		System.out.println(numerator);
	}
	

}
