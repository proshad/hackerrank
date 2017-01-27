package com.datastructure.tree.hacker;

import java.util.Scanner;

/**
 * Created by proshad on 1/26/17.
 */
public class SwapNodes2 {
    public static void main(String[] args){
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


        TreeNode leftTree = (leafs[0][0] > -1) ? new TreeNode(leafs[0][0]) : null;
        TreeNode rightTree = (leafs[0][1] > -1) ? new TreeNode(leafs[0][1]) : null;

        if (leafs[0][0] > -1)
            leftTree.mapChildNodes(leftTree, leafs, (leafs[0][0] > -1) ? 1 : 2, 0, N);
        if (leafs[0][1] > -1)
            rightTree.mapChildNodes(rightTree, leafs, (leafs[0][0] > -1) ? 2 : 1, 0, N);

        TreeNode mainTree = new TreeNode(1, leftTree, rightTree);

        for(int d : depths) {
            mainTree.swap(mainTree, d, 1);
            mainTree.inorder(mainTree);
            System.out.println();
        }
    }
}
