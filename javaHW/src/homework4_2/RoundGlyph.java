/**
 * @fileName RoundGlyph.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 4-1 Arithmetic example
 * @date Last Modified: 09/27/2014
 * @description: To check whether the value of the member variable radius ever assume the value 1
 */

package homework4_2;
class RoundGlyph extends Glyph {
    int radius = 1;
    RoundGlyph(int r) {
    	
    	System.out.println("After the initiation, before given the value of 5, radius=" + radius);
        radius = r;
        System.out.println("RoundGlyph(), radius=" + radius);
    }
    void draw() {
        System.out.println("RoundGlyph.draw(), radius=" + radius);
    }
}