package com.datastructure.tree.hacker;

/**
 * Created by proshad on 1/26/17.
 */
public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void insertLeft(int data) {
        if (this.left == null) {
            this.left = new TreeNode(data);
        } else {
            this.left.insertLeft(data);
        }
    }

    public void insertRight(int data) {
        if (this.right == null) {
            this.right = new TreeNode(data);
        } else {
            this.right.insertRight(data);
        }
    }

    public void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.toString());
        inorder(node.right);
    }

    public void swap(TreeNode node, int targetDepth, int depth) {
        if (node == null) return;

        if (depth % targetDepth == 0) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        swap(node.left, targetDepth, depth + 1);
        swap(node.right, targetDepth, depth + 1);

    }

    @Override
    public String toString() {
        return this.data + " ";
    }
}
