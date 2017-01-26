package com.datastructure.tree.hacker;

/**
 * Created by proshad on 1/26/17.
 */
public class Node {
    int data;
    Node left;
    Node right;

    public Node newNode(int data){
        this.data = data;
        this.left=null;
        this.right=null;
        return this;
    }
}
