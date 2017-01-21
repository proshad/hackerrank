package com.algorithm.hacker;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by proshad on 1/20/17.
 */
public class TwoSets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int min = 1, max = 1, totalCount = 0;
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
            if (min > a[a_i])
                min = a[a_i];
        }
        int[] b = new int[m];
        for (int b_i = 0; b_i < m; b_i++) {
            b[b_i] = in.nextInt();
            if (max < b[b_i])
                max = b[b_i];
        }
        for (int i = min; i <= max; i++) {
            if (areFactors(i, a) && isFactor(i, b)) {
                totalCount++;
            }
        }
        System.out.println(totalCount);
    }

    private static boolean areFactors(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (num % arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFactor(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % num != 0) {
                return false;
            }
        }
        return true;
    }
}
