/**
 * @fileName TestTime.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 4-3 reflexive, symmetric and transitive
 * @date Last Modified: 09/27/2014
 * @description: 
 */

package homework4_3;
public class TestTime {
	public static void main(String[] args) {
		Time t1 = new Time(); // initial time1
		Time t2 = new Time(20, 3, 45); // initial time2
		Time t3 = new Time(); // initial time3
		
		System.out.println("reflexive:");
		t1.setHour(20).setMinute(3).setSecond(45); 
		System.out.println("t1 is " + t1);
		System.out.println("t1.equals(t1): " + t1.equals(t1) + "\n");
		
		System.out.println("symmetric:");
		t1.setHour(20).setMinute(3).setSecond(45);
		System.out.println("t1 is " + t1);
		System.out.println("t2 is " + t2);
		System.out.println("t1.equals(t2): " + t1.equals(t2));
		System.out.println("t2.equals(t1): " + t2.equals(t1) + "\n");

		System.out.println("transitive:");
		t1.setHour(20).setMinute(3).setSecond(45);
		t3.setHour(20).setMinute(3).setSecond(45);
		System.out.println("t1 is " + t1);
		System.out.println("t2 is " + t2);
		System.out.println("t3 is " + t3);
		System.out.println("t1.equals(t2): " + t1.equals(t2));
		System.out.println("t2.equals(t3): " + t2.equals(t3));
		System.out.println("t3.equals(t1): " + t3.equals(t1) + "\n");

		System.out.println("t1 and t2 are different in hours:");
		t1.setHour(5);
		System.out.println("t1 is " + t1);
		System.out.println("t2 is " + t2);
		System.out.println("t1.equals(t2): " + t1.equals(t2) + "\n");

		System.out.println("t1 and t2 are different in minutes:");
		t1.setHour(20).setMinute(35);
		System.out.println("t1 is " + t1);
		System.out.println("t2 is " + t2);
		System.out.println("t1.equals(t2): " + t1.equals(t2) + "\n");

		System.out.println("t1 and t2 are different in seconds:");
		t1.setMinute(3).setSecond(55);
		System.out.println("t1 is " + t1);
		System.out.println("t2 is " + t2);
		System.out.println("t1.equals(t2): " + t1.equals(t2) + "\n");
	}
}
