import java.util.*;
import java.io.*;

public class DoubleSpace {
	public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of a file to doublespace: ");
        String fName = keyboard.nextLine();
        Scanner file = null;
        try {
        	file = new Scanner(new File(fName));
        }
        catch (FileNotFoundException f) {
        	System.out.println("Sorry, couldn't find that file.");
        	System.exit(0);
        }
        while(file.hasNextLine() == true) {
            System.out.println(file.nextLine());
            System.out.println();
        }
        System.out.println("We're done.");
	}
}
