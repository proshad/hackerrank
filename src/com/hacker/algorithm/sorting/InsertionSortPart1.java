package com.hacker.algorithm.sorting;

import java.util.Scanner;

/**
 * Created by proshad on 1/20/17.
 */
public class InsertionSortPart1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        insertIntoSorted(a);
    }

    public static void insertIntoSorted(int[] ar) {
        int length = ar.length;
        int item = ar[length - 1];
        boolean bFlag = false;

        for (int i = length - 2; i > -1; i--) {
            int number = ar[i];
            if (number > item) {
                ar[i + 1] = number;
            } else {
                bFlag = true;
                ar[i + 1] = item;
            }
            printArray(ar);
            if (bFlag)
                break;
        }
        if (!bFlag) {
            int number = ar[0];

            if (number > item) {
                ar[1] = number;
                ar[0] = item;
            } else {
                ar[1] = item;
                ar[0] = number;
            }

            printArray(ar);
        }

    }

    public static void printArray(int[] ar) {
        String arrString = java.util.Arrays.toString(ar);
        arrString = arrString.replace(",", "");
        arrString = arrString.replace("[", "");
        arrString = arrString.replace("]", "");
        System.out.println(arrString);
    }

}
