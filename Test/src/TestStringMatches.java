

	public class TestStringMatches{
	   public static void main(String args[]){
	      String Str = "Welcome";
	      String s = "";

	      System.out.print("Return Value :" );
	      System.out.println(Str.matches("^[a-zA-Z]*$"));

	      System.out.print("Return Value :" );
	      System.out.println(Str.matches("Tutorials"));

	      System.out.print("Return Value :" );
	      System.out.println(Str.matches("Welcome(.*)"));
	      
	      System.out.print("Return Value :" );
	      System.out.println(s.matches("^\\s*$"));
	      
	   }
	}
