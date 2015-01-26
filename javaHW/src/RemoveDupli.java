
public class RemoveDupli {

	public static void main(String[] args) {
				int[] a = { 1, 2, 3, 4, 4, 5 };
				int[] b = removeDuplicates(a);
				for (int i = 0; i < b.length; i++) {
					System.out.print(b[i] + " ");
				}
			}

			public static int[] removeDuplicates(int[] a) {
				int bFlag = 0;
				int[] b = new int[a.length];
				b[0] = a[0];
				for (int i = 1; i < a.length; i++) {
					if (a[i - 1] != a[i]) {
						b[++bFlag] = a[i];
					}
				}
				return b;
	}

}
