package com.hacker.algorithm.basic;

import java.util.*;

/**
 * Created by proshad on 1/17/17.
 */
public class SockMerchant {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        HashSet<Integer> hashSet = new HashSet();
        int pair = 0;
        for(int i=0; i < n; i++){
            c[i] = in.nextInt();
        }

        for(int i=0; i < n; i++){
           if(!hashSet.add(c[i])){
               pair++;
               hashSet.remove(c[i]);
           }
        }
        System.out.println(pair);

    }
}
