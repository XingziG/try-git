/**
 * @fileName Time.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 4-2 reflexive, symmetric and transitive
 * @date Last Modified: 09/27/2014
 * @description: 
 */
package homework4_3;

public class Time {
	private int hour;
	private int minute;
	private int second;

	Time() {// constructor
		setTime(0, 0, 0);
	}

	Time(int h) {// constructor
		setTime(h, 0, 0);
	}

	Time(int h, int m) { // constructor
		setTime(h, m, 0);
	}

	Time(int h, int m, int s) { // constructor
		setTime(h, m, s);
	}

	Time setTime(int h, int m, int s) {
		setHour(h);
		setMinute(m);
		setSecond(s);
		return this;
	}

	Time setHour(int h) {
		hour = ((h >= 0 && h < 24) ? h : 0);
		return this;
	}

	Time setMinute(int m) {
		minute = ((m >= 0 && m < 60) ? m : 0);
		return this;
	}

	Time setSecond(int s) {
		second = ((s >= 0 && s < 60) ? s : 0);
		return this;
	}

	int getHour() {
		return hour;
	}

	int getMinute() {
		return minute;
	}

	int getSecond() {
		return second;
	}

	public String toString() {
		return ("" + ((hour == 12 || hour == 0) ? 12 : hour % 12) + ":"
				+ (minute < 10 ? "0" : "") + minute + ":"
				+ (second < 10 ? "0" : "") + second + (hour < 12 ? " AM"
				: " PM"));
	}

	@Override
	public boolean equals(Object obj) { // the equals method
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hour != other.getHour())
			return false;
		if (minute != other.getMinute())
			return false;
		if (second != other.getSecond())
			return false;
		return true;
	}

}
