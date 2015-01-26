package MethodPointerTest;

import java.lang.reflect.*;
import java.text.*;
public class MethodPointerTest {
    public static void main(String[] args) throws Exception {

    	    // get method pointers to the square and sqrt methods
    	    Method square = MethodPointerTest.class.getMethod("square",
    	        double.class);
    	    Method sqrt = java.lang.Math.class.getMethod("sqrt",
    	        new Class[]{double.class});

    	    // print tables of x- and y-values
    	    printTable(1, 10, 10, square);
    	    printTable(1, 10, 10, sqrt);
    	}
    
    public static double square(double x) {
        return x*x;
    }
    public static void printTable(double from, double to,
        int n, Method f) {
    	 System.out.println(f);

    	    // construct formatter to print with 4 digit precision
    	    NumberFormat formatter = NumberFormat.getInstance();
    	    formatter.setMinimumFractionDigits(4);
    	    formatter.setMaximumFractionDigits(4);
    	    double dx = (to - from) / (n-1);
    	    for (double x = from; x <= to; x += dx) {
    	        // print x-value
    	        String output = formatter.format(x);
    	        // pad with spaces to field width of 10
    	        for (int i = 10 - output.length(); i > 0; i--)
    	            System.out.print(" ");
    	        System.out.print(output + " |");
    	        try {
    	            // invoke method and print y-value
    	            Object[] args = {new Double(x)};
    	            Double d = (Double)f.invoke(null, args);
    	            double y = d.doubleValue();
    	            output = formatter.format(y);
    	            // pad with spaces to field with of 10
    	            for (int i = 10 - output.length(); i > 0; i--)
    	                System.out.print(" ");

    	            System.out.println(output);
    	        }
    	        catch (Exception e) { e.printStackTrace(); }

    }
    }
}

