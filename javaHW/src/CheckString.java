import java.util.*;
import java.io.*;

public class CheckString {

	public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //get file name
        System.out.println("Enter the name of a file to checkstring: ");
        String fileName = keyboard.nextLine();
        Scanner file = null;
        //get string to find
        Scanner str =  new Scanner(System.in);
    	System.out.println("What string do you want to find?");
    	String toFind = str.nextLine();
        
        try {
        	file = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException f) {
        	System.out.println("Sorry, couldn't find that file.");
        	System.exit(0);
        }
        while(file.hasNextLine() == true) {
        	String line = file.nextLine();
        		if(line.contains(toFind))   //if this line contains the string that we want to find, print this line.
        			System.out.println(line);      			
        		
        }
        
    }
      
}
