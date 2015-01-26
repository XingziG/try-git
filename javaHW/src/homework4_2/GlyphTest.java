/**
 * @fileName GlyphTest.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 4-2 Glyph/RoundGlyph example
 * @date Last Modified: 09/27/2014
 * @description: To check whether the value of the member variable radius ever assume the value 1
 */

package homework4_2;


/**
 * @author xingzi
 * Conclusion: The radius equals 1 when the object of RoundGlyph is constructed.
 */
public class GlyphTest {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
