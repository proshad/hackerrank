package com.hacker.datastructure.tree;

import java.util.Scanner;

/**
 * Created by proshad on 2/25/17.
 */
public class MedianUpdates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        int lastIndex = 0;
        for (int i = 0; i < n; i++) {
            char query = sc.next().charAt(0);
            int val = sc.nextInt();
            if (query == 'a') {
                sortArray(list, val, lastIndex);
                lastIndex++;
                printMedian(list, lastIndex);
            } else {
//                delete the item from array
                int pos = 0;
                boolean bFound = false;
                for (int j = 0; j < lastIndex; j++) {
                    if (list[j] == val) {
                        bFound = true;
                        pos = j;
                        break;
                    }
                }
                if (bFound) {
                    for (int k = pos; k < lastIndex - 1; k++) {
                        list[k] = list[k + 1];
                    }
                    lastIndex--;
                    printMedian(list, lastIndex);
                } else {
                    System.out.println("Wrong!");
                }

            }
        }
    }

    private static int[] sortArray(int[] arr, int val, int last) {
        int i = last;
        while ((i > 0) && (val < arr[i - 1])) {
            arr[i] = arr[i - 1];
            i = i - 1;
        }
        arr[i] = val;
        return arr;
    }

    private static void printMedian(int[] list, int i) {
        if (i == 0) {
            System.out.println("Wrong!");
            return;
        }
        if (i % 2 == 0) {
            int mid = i / 2;
            long sum = (long)(list[mid]) + (long)(list[mid - 1]);
            if ((sum) % 2 == 0) {
                System.out.println(sum / 2);
            } else {

                System.out.println(""+(sum/2)+".5");
            }
        } else {
            System.out.println(list[i / 2]);
        }

    }
}
