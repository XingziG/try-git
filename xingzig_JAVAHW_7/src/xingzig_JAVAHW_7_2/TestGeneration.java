package xingzig_JAVAHW_7_2;

import java.util.Random;
import java.util.Scanner;

public class TestGeneration {
	static int numIndepVars;
	static int maxDepth = 3;
	static int numTrees = 500; //TODO generate 500 trees
	static Random rand = new Random();

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the name of a file and press Enter to start calculation: ");
		String FileName = keyboard.nextLine();
		DataSet data = new DataSet(FileName);
		numIndepVars = data.getxNum();

		Node[] ops = { new Plus(), new Minus(), new Mult(), new Divide() };
		OperatorFactory o = new OperatorFactory(ops);
		TerminalFactory t = new TerminalFactory(numIndepVars);

		Generation gen = new Generation(numTrees, o, t, maxDepth, rand);
		gen.evalAll(data);
		gen.printBestTree();
	}
}
