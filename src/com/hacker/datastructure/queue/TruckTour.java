package com.hacker.datastructure.queue;

import java.util.Scanner;

/**
 * Created by proshad on 2/3/17.
 */
public class TruckTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int petrol = sc.nextInt();
            int distance = sc.nextInt();
            a[i] = petrol - distance;
        }


        int counter = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            int i = counter;
            int sum = 0;
            while (i < n) {
                sum += a[i%n];
                if (sum < 0) {
                    flag = true;
                    counter++;
                    break;
                }
                i++;
            }
        }
        System.out.println(counter%n);
    }
}
