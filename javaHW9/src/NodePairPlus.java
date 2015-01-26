/**
 * @fileName NodePairPlus.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 9-1 genetic programming
 * @date Last Modified: 11/17/2014
 * @description: In this assignment, we will generate 500 GPTrees and evolve 5 generation of trees. 
 */


/* Generated by Together */
/** Holds a "clip point". A clip point is the place in a GPTree
where crossover will occur.
* @see GPTree
* @see TestGPTree
*/

public class NodePairPlus {
    /** The node above the clip point. */
    public Node parent;
    /** The node below the clip point. */
    public Node child;
    /** the count of number of nodes so far tested in the process
    * of searching for the clip point. */
    int counter;
}