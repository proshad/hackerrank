package com.hacker.datastructure.tree;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by proshad on 1/26/17.
 */
public class SwapNodes2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final int N = s.nextInt();

        TreeNode root = new TreeNode(1);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode currentNode;
        for (int i = 0; i < N; i++) {
            currentNode = queue.poll();
            int left = s.nextInt();
            int right = s.nextInt();
            if (left > -1) {
                currentNode.insertLeft(left);
                queue.add(currentNode.left);
            }
            if (right > -1) {
                currentNode.insertRight(right);
                queue.add(currentNode.right);
            }
        }

        int[] T = new int[s.nextInt()];

        for (int i = 0; i < T.length; i++) {
            root.swap(root, s.nextInt(), 1);
            root.inorder(root);
            System.out.println();
        }


    }
}
