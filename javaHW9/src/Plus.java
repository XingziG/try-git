/**
 * @fileName Plus.java
 * @author Xingzi Guo (xingzig@andrew.cmu.edu)
 * @Andrew ID: xingzig
 * @Assignment: Homework 9-1 genetic programming
 * @date Last Modified: 11/17/2014
 * @description: In this assignment, we will generate 500 GPTrees and evolve 5 generation of trees. 
 */

/* Generated by Together */

public class Plus extends Binop {
    public Plus() {}
    public Plus(Node l, Node r) {
        super(l, r);
    }
    public double eval(double[] data) {
        return lChild.eval(data) + rChild.eval(data);
    }
    public String toString() {
        String s = new String();
        s += "(" + lChild.toString() + " + " + rChild.toString() + ")";
        return s;
    }
    public Node duplicate() {
        Plus alterEgo = new Plus();
        alterEgo.lChild = lChild.duplicate();
        alterEgo.rChild = rChild.duplicate();
        return alterEgo;
    }
}