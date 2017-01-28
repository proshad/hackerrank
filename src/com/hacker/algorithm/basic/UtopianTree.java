package com.hacker.algorithm.basic;

import java.util.Scanner;

/**
 * Created by proshad on 1/20/17.
 */
public class UtopianTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int initialHeight = 1;

        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            if (n == 0) {
                System.out.println(initialHeight);
            } else if (n == 1) {
                System.out.println(initialHeight * 2);

            } else {
                int height = 1;
                for (int i = 1; i <= n; i += 2) {

                    if ((i + 1) <= n) {
                        height = height * 2 + 1;
                    } else {
                        height = height * 2;
                    }
                }
                System.out.println(height);
            }

        }
    }
}
