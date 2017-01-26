package com.datastructure.tree.hacker;

import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by proshad on 1/26/17.
 */
public class LCA {
    public static void main(String[] args){
        Node  root = new Node().newNode(1);
        root.left = new Node().newNode(2);
        root.right = new Node().newNode(3);
        root.left.left = new Node().newNode(4);
        root.left.right = new Node().newNode(5);
        root.right.left = new Node().newNode(6);
        root.right.right = new Node().newNode(7);

        System.out.println("LCA(4, 5) = " + lca(root, 4, 5).data);
        System.out.println("LCA(4, 6) = " + lca(root, 4, 6).data);
        System.out.println("LCA(3, 4) = " + lca(root, 3, 4).data);
        System.out.println("LCA(2, 4) = " + lca(root, 2, 4).data);
    }


    // Lowest Common Ancestor
    static Node lca(Node root, int v1, int v2) {

        // to store paths to n1 and n2 from the root
        Vector<Node> path1 = new Vector<Node>();
        Vector<Node> path2 = new Vector<Node>();

        // Find paths from root to v1 and root to v2. If either v1 or v2 is not present, return -1
        if (!findPath(root, path1, v1) || !findPath(root, path2, v2))
            return null;
    /* Compare the paths to get the first different value */
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++){
            Node node1 = path1.get(i);
            Node node2 = path2.get(i);
            if(node1.data != node2.data)
                break;
        }

        return path1.get(i - 1);

    }

    // Finds the path from root node to given root of the tree, Stores the
// path in a vector path[], returns true if path exists otherwise false
    public static boolean findPath(Node root, Vector<Node> path, int k) {
        // base case
        if (root == null)
            return false;

        // Store this node in path vector. The node will be removed if
        // not in path from root to k
        path.add(root);

        // See if the k is same as root's key
        if (root.data == k)
            return true;

        // Check if k is found in left or right sub-tree
        if ((root.left != null && findPath(root.left, path, k)) || (root.right != null && findPath(root.right, path, k)))
            return true;

        // If not present in subtree rooted with root, remove root from
        // path[] and return false
        path.remove(path.size()-1);
        return false;
    }
}

