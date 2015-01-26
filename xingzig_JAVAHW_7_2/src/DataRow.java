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
