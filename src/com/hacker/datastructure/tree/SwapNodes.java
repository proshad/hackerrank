package com.hacker.datastructure.tree;

import java.util.Scanner;

/**
 * Created by proshad on 1/26/17.
 */
public class SwapNodes {
    public static final int ROOT_NODE = 1;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final int N = s.nextInt();
        int[][] tree = new int[N + ROOT_NODE][2];

        for (int i = ROOT_NODE; i < N + ROOT_NODE; i++) {
            for (int j = 0; j < 2; j++) {
                tree[i][j] = s.nextInt();
            }
        }

        int numDepths = s.nextInt();
        for (int i = 0; i < numDepths; i++) {
            swap(tree, ROOT_NODE, s.nextInt(), 1);
            System.out.println();
        }
    }

    public static void swap(int[][] tree, int node, int targetDepth, int depth) {
        if (node == -1)
            return;

        if (depth % targetDepth == 0) {
            int temp = tree[node][0];
            tree[node][0] = tree[node][1];
            tree[node][1] = temp;
        }
        swap(tree, tree[node][0], targetDepth, depth + 1);
        System.out.print(Integer.toString(node) + " ");
        swap(tree, tree[node][1], targetDepth, depth + 1);
    }
}
