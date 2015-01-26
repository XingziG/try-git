import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A DataSet will hold an ArrayList of DataRow objects m that is an
 * ArrayList<DataRow>
 * 
 * @author xingzi
 *
 */
public class DataSet {
	private ArrayList<DataRow> dataset;
	
	public DataSet(String FileName) {
		this.setDataset(FileName); 
	}

	public ArrayList<DataRow> getDataset() {
		return dataset;
	}

	public void setDataset(String FileName) {		
		Scanner file = null;
		try {
        	file = new Scanner(new File(FileName));
        }
        catch (FileNotFoundException f) {
        	System.out.println("Sorry, couldn't find that file.");
        	System.exit(0);
        }	
		if (file.hasNextInt()) {
        	int xNum = file.nextInt();
            int capacity = file.nextInt();
        	//System.out.println(file.next());
            dataset = new ArrayList<DataRow>(capacity);
           
            for (int i = 0; i < capacity ; i++){
            	Double y = file.nextDouble();
            	ArrayList<Double> xset = new ArrayList<Double>(xNum);
            	for (int j = 0; j<xNum; j++){
            		xset.add(j, file.nextDouble());
            	}
            	DataRow row = new DataRow(y,xset);
            	dataset.add(row);
            }
        }
	}
	
	public void setDatarow(ArrayList<DataRow> dataset){
		this.dataset = dataset;
	}
}
