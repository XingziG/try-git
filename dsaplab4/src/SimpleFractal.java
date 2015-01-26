/**************************************************************
 * 
 * 95-772 Data Structures for Application Programmers 
 * 
 * Lab 4 Number of Collisions Comparison and 
 * Drawing a simple fractal of N squares with recursion
 * 
 * Andrew ID: xingzig
 * Name: Xingzi Guo
 * 
 **************************************************************/

public class SimpleFractal {

	public static void main(String[] args) {
		/*
		 * canvas width and height are both 1.0 
		 * initial call to create 10 squares
		 * please use the following initial call for consistency
		 */
		fractal(10, 0, 0, 0.5);
	}

	/**
	 *  recursive method to draw a fractal of n number of squares
	 */
	public static void fractal(int n, double x, double y, double length) { 
		if(n == 0) 
			return;
			StdDraw.filledSquare( x+length/2, y+length/2, length/2);
			fractal(n-1, x+length, y+length, length/2);
		// TODO implement this method
		/*
		 * use filledSquare method in StdDraw class 
		 * which draws a filled square of side length 2r, centered on (x, y).
		 */
	}

}