package com.hacker.datastructure.heap;

import java.util.*;

/**
 * Created by proshad on 2/7/17.
 */
public class RunningMedian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        double median = 0.0;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (i == 0) {
                list[i] = val;
                median = val;
            } else if (i == 1) {
                if (val > list[0]) {
                    list[i] = val;
                } else {
                    int temp = list[0];
                    list[0] = val;
                    list[i] = temp;
                }
                median = (double) (list[0] + list[1]) / 2;
            } else {
                sortArray(list, val, i);
                if (i % 2 != 0) {
                    int mid = i / 2;
                    median = (double) (list[mid] + list[mid + 1]) / 2;
                } else {
                    median = list[i / 2];
                }
            }
            System.out.println(median);
        }
    }

    private static int[] sortArray(int[] arr, int val, int last) {
        int i = last;
        while ((i > 0) && (val < arr[i-1]))
        {
            arr[i] = arr[i-1];
            i = i - 1;
        }
        arr[i] = val;
        return arr;
    }
}
