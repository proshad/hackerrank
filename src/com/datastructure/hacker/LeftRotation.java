package com.datastructure.hacker;

import java.util.Scanner;

/**
 * Created by proshad on 1/23/17.
 */
public class LeftRotation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<n;i++){
            int item = a[d%n];
            builder.append(item+" ");
            d++;
        }
        System.out.println(builder.toString());
    }
}
