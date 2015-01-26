import java.util.*;

public class typeQuickly {

	public static void main(String[] args) {
		System.out.println("Your job is to type the sentence \"I type very quickly \"as fast as you can.");
		System.out.println("When you are ready, press enter, type the sentence, and press enter again.");
		
		//get input from keyboard
		Scanner in = new Scanner(System.in);
			while(in.hasNextLine() == true) {
				String getline = in.nextLine();
				//the first press must be Enter
				if (getline.equals("")) {
					long start = System.currentTimeMillis(); //get system time
					String stence = "I type very quickly";
					getline = in.nextLine();
					
						//type the sentence and test if it is correct
						if (stence.equals(getline)) {
							long end = System.currentTimeMillis();
							long timelag = end-start;
							System.out.println("Good job! Your typing time is " + timelag + " millionseconds.");
							System.out.println("You can press enter to try again.");
						}
						//if the sentence is not correct
						else {
							System.out.println("You typed the wrong sentence, please try again.");
						}	
						
							System.out.println("When you are ready, press enter, type the sentence, and press enter again.");
				}
				//if you didn't press Enter
				else					
					System.out.println("Error, when you are ready, press ENTER, type the sentence, and press enter again.");
			}
	}
}
