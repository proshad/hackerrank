package com.datastructure.tree.hacker;

/**
 * Created by proshad on 1/27/17.
 */
public class CheckBST {
    boolean checkBST(Node root) {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBinarySearchTree(Node root, int low, int high) {
        if(root == null) {
            return true;
        }
        if(root.data <= low || root.data >= high) {
            return false;
        }
        return isBinarySearchTree(root.left, low, root.data) &&
                isBinarySearchTree(root.right, root.data, high);
    }
}

