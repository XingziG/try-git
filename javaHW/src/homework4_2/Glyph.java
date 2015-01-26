/**
 * @fileName Glyph.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 4-2 Glyph/RoundGlyph example
 * @date Last Modified: 09/27/2014
 * @description: To check whether the value of the member variable radius ever assume the value 1
 */

package homework4_2;

abstract class Glyph {
	abstract void draw();

	Glyph() {
		System.out.println("Glyph() before draw");
		draw();
		System.out.println("Glyph() after draw");
	}
}
