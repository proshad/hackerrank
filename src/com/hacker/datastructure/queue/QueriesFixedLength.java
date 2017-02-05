package com.hacker.datastructure.queue;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by proshad on 2/3/17.
 */
public class QueriesFixedLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int t = 0; t < q; t++) {
            int d = sc.nextInt();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i <= n-d; i++) {
                int max = arr[i];
                for(int j = 1;j<d;j++){
                    if (arr[i+j] > max)
                        max = arr[i+j];
                }
                if(min>max){
                    min = max;
                }
            }
            System.out.println(min);
        }
    }

}
