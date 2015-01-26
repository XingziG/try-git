import java.util.*;

public class tryContinue {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int sum = 0, goal = 10;
		int n = 0;
		while (sum<goal){
			System.out.print(sum);
			System.out.print("enter a number:");
			n = in.nextInt();
			if(n<0) continue;
			sum += n;			
		}

	}

}
