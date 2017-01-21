package com.algorithm.hacker;

import java.util.Scanner;

/**
 * Created by proshad on 1/19/17.
 */
public class BeautifulDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = sc.nextInt();
        int goodDaysCount = 0;
        for(int n=i;n<=j;n++){
            String reverse = new StringBuilder(n+"").reverse().toString();
            int reverseInt = Integer.parseInt(reverse);
            int diff = Math.abs(n-reverseInt);
            if(diff%k==0)
                goodDaysCount++;

        }
        System.out.println(goodDaysCount);
    }
}
