package com.hacker.datastructure.tree;

/**
 * Created by proshad on 1/27/17.
 */
public class SelfBalancingTree {
    Node root;

    class Node {
        int val;   //Value
        int ht;      //Height
        Node left;   //Left child
        Node right;   //Right child
    }

    // A utility function to get height of the tree
    static int getHeight(Node N) {
        if (N == null)
            return 0;
        return N.ht;
    }

    // A utility function to get maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        // Perform rotation
        x.right = y;
        y.left = T2;
        // Update heights
        y.ht = max(getHeight(y.left), getHeight(y.right)) + 1;
        x.ht = max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        // Perform rotation
        y.left = x;
        x.right = T2;
        x.ht = max(getHeight(x.left), getHeight(x.right)) + 1;
        y.ht = max(getHeight(y.left), getHeight(y.right)) + 1;
        return y;
    }

    // Get Balance factor of node N
    static int getBalanceFactor(Node N) {
        if (N == null)
            return 0;
        return (getHeight(N.left) - getHeight(N.right));
    }

    static Node insert(Node root, int val) {

        /* 1.  Perform the normal BST insertion */
//        if (root == null) {
//            Node temp = new Node();
//            temp.val = val;
//            return (temp);
//        }


        if (val < root.val)
            root.left = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val);
        else // Duplicate keys not allowed
            return root;

        /* 2. Update height of this ancestor node */
        root.ht = 1 + max(getHeight(root.left), getHeight(root.right));
        int balance = getBalanceFactor(root);

        if (balance > 1 && val < root.left.val)
            return rightRotate(root);

        if (balance < -1 && val > root.right.val)
            return leftRotate(root);

        // Left Right Case
        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            //Visit the node by Printing the node data
            System.out.print(root.val + "(BF=" + getBalanceFactor(root) + ")");
            inOrder(root.right);
        }
    }

    void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.val + "(BF=" + getBalanceFactor(root) + ")");
            preOrder(root.left);
            preOrder(root.right);
        }
    }


    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
//        tree.root = tree.insert(tree.root, 14);
//        tree.root = tree.insert(tree.root, 25);
//        tree.root = tree.insert(tree.root, 21);
//        tree.root = tree.insert(tree.root, 10);
//        tree.root = tree.insert(tree.root, 23);
//        tree.root = tree.insert(tree.root, 7);
//        tree.root = tree.insert(tree.root, 26);
//        tree.root = tree.insert(tree.root, 12);
//        tree.root = tree.insert(tree.root, 30);
//        tree.root = tree.insert(tree.root, 16);
//        tree.root = tree.insert(tree.root, 19);


        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 1);


        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.inOrder(tree.root);
        System.out.println();
        tree.preOrder(tree.root);
    }
}