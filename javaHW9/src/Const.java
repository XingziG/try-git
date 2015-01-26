/**
 * @fileName Const.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 9-1 genetic programming
 * @date Last Modified: 11/17/2014
 * @description: In this assignment, we will generate 500 GPTrees and evolve 5 generation of trees 
 * @description: Const class is used to generate and hold constant numbers in the program 
 */

import java.util.*;
import java.text.*;

/** A Node wrapper for a constant in an algebraic expression. */
public class Const extends Node {
    private double value;
    public Const(double d) {value = d; }
    public void setChild(int position, Node n) {}
    public double eval(double[] data) { return value; }
    public String toString() {
        String s = new String();
        s += NumberFormat.getInstance().format(value);
        return s;
    }
    public void addRandomKids(OperatorFactory o, TerminalFactory t,
                              int maxDepth, Random rand) {}

    public Node duplicate() {
        Const alterEgo = new Const(value);
        return alterEgo;
    }

    /** Returns a NodePairPlus object whose parent and child are null,
    * and whose counter equals the incoming nodeNumber. */
    public NodePairPlus traceTree(int nodeNumber, int clipNumber) {
        NodePairPlus p = new NodePairPlus();
        p.parent = null;
        p.child = null;
        p.counter = nodeNumber;
        return p;
    }

    /** Should never be called, since constants have no children. */
    public void changeChild(Node oldChild, Node newChild) {
        System.out.println("Const.changeChild() should never be called!");
    }
}
