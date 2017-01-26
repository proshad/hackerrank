package com.datastructure.tree.hacker;

import java.util.Scanner;

/**
 * Created by proshad on 1/26/17.
 */
public class SwapNodes2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final int N = s.nextInt();
        int[][] leafs = new int[N][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                leafs[i][j] = s.nextInt();
            }
        }

        int[] depths = new int[s.nextInt()];

        for (int i = 0; i < depths.length; i++) {
            depths[i] = s.nextInt();
        }

        TreeNode left = null;
        TreeNode right = null;
        if (leafs[0][0] > -1) {
            left = new TreeNode(leafs[0][0]);
            left.mapChildNodes(left, leafs, 1 , 0, N);
        }
        if (leafs[0][1] > -1) {
            right = new TreeNode(leafs[0][1]);
            right.mapChildNodes(right, leafs, 2 , 0, N);
        }
        TreeNode mainTree = new TreeNode(1, left, right);
        for (int d : depths) {
            mainTree.swap(mainTree, d, 1);
            mainTree.inOrder(mainTree);
            System.out.println();
        }
    }
}
