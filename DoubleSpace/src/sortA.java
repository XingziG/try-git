import java.util.Arrays;
import java.util.Date;

public class sortA {

	public static void main(String[] args) {
		int x = -12345;
		int s = 0;
		//if (x <= 65535 && x > 0) {
			while ( x !=0 ){
				s = s * 10;
				s = s + x % 10;
				x = x / 10;
			}

			//else if (-65536 <= x && x<0){

			// }
			// else s=0;

			System.out.print(s);
		}
	//}
}
