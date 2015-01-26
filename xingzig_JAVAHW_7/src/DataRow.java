/**
 * @fileName DataRow.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 7-1 TestAlgebra
 * @date Last Modified: 10/29/2014
 * @description: In this assignment, we will read and store a data file. We will find out how close the tree value, for each x0 value, is to the given y value in the data.  
 * @description: DataRow class is used to store each row of the dataset
 */

import java.util.ArrayList;


/**
 * A DataRow object will hold a y value and an ArrayList of x values.
 * @author xingzi
 *
 */
public class DataRow {
	private Double yval;
	private ArrayList<Double> xval;
	
	
	public DataRow(Double yval, ArrayList<Double> xval) {
		setXval(xval);
		this.yval = yval;
	}
	
	
	public Double getYval() {
		return yval;
	}
	public void setYval(Double yval) {
		this.yval = yval;
	}
	
	
	public ArrayList<Double> getXval() {
		return xval;
	}
	
	public void setXval(ArrayList<Double> xset) {
		this.xval = xset;
	}
	
	
}
