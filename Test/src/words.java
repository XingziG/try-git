
public class words {
	
	public static void main(String[] args) {
	int[] a = {1,2,3,4,5};
	int[] b = {1,1,1,1,1,1,1,1,1,1};
	System.arraycopy(a, 0, b, 0, 5);
	a = b;
	System.out.println(a[5]);
	}

}
