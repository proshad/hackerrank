package com.datastructure.tree.hacker;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by proshad on 1/24/17.
 */
public class BasicTree {

    /*Tree: Preorder Traversal
Step 1 − Visit root node.
Step 2 − Recursively traverse left subtree.
Step 3 − Recursively traverse right subtree.
     */
    void preOrder(Node root) {

//        if(root !=  null) {
//            //Visit the node by Printing the node data
//            System.out.print(root.data +" ");
//            preOrder(root.left);
//            preOrder(root.right);
//        }


        // Base Case
        if (root == null) {
            return;
        }

        // Create an empty stack and push root to it
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(root);

        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (nodeStack.empty() == false) {

            // Pop the top item from stack and print it
            Node mynode = nodeStack.peek();
            System.out.print(mynode.data + " ");
            nodeStack.pop();

            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.push(mynode.left);
            }
        }
    }

/*
//Tree: Preorder Traversal
Step 1 − Recursively traverse left subtree.
Step 2 − Recursively traverse right subtree.
Step 3 − Visit root node
* */

    void postOrder(Node root) {

//        if(root !=  null) {
//            postOrder(root.left);
//            postOrder(root.right);
//            //Visit the node by Printing the node data
//            System.out.print(root.data +" ");
//        }

        // Base Case
        if (root == null)
            return;

        // Create two stacks
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        // push root to first stack
        s1.push(root);
        Node node;

        // Run while first stack is not empty
        while (!s1.empty()) {
            // Pop an item from s1 and push it to s2
            node = s1.pop();
            s2.push(node);

            // Push left and right children of removed item to s1
            if (node.left != null)
                s1.push(node.left);
            if (node.right != null)
                s1.push(node.right);
        }

        // Print all elements of second stack
        while (!s2.empty()) {
            node = s2.pop();
            System.out.print(node.data + " ");
        }

    }

    /* Tree: Inorder Traversal
    Step 1 − Recursively traverse left subtree.
    Step 2 − Visit root node.
    Step 3 − Recursively traverse right subtree.
    */
    void inOrder(Node root) {
//        if(root !=  null) {
//            inOrder(root.left);
//            //Visit the node by Printing the node data
//            System.out.print(root.data +" ");
//            inOrder(root.right);
//        }

        if (root == null)
            return;

        Stack<Node> s = new Stack<Node>();
        Node currentNode = root;

        while (!s.empty() || currentNode != null) {

            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                Node n = s.pop();
                System.out.print(n.data + " ");
                currentNode = n.right;
            }
        }


    }


    // get height of a tree. level of tree
    static int height(Node root) {
        if (root == null) {
            return -1;
        } else if (root.left == null) {
            return 1 + height(root.right);
        } else if (root.right == null) {
            return 1 + height(root.left);
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }

    }

    // print the top view
    void top_view(Node root) {
        if (root == null)
            return;
        Stack<Node> s = new Stack<Node>();
        Node currentNode = root;
        while (!s.empty() || currentNode != null) {
            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                Node n = s.pop();
                System.out.print(n.data + " ");

            }
        }
        currentNode = root.right;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.right;

        }

    }

    //Level order traversal
    void LevelOrder(Node root) {
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node tempNode=queue.poll();
            System.out.print(tempNode.data +" ");
            if(tempNode.left!=null)
                queue.add(tempNode.left);
            if(tempNode.right!=null)
                queue.add(tempNode.right);
        }

    }


    class Node {
        int data;
        Node left;
        Node right;
    }
}
