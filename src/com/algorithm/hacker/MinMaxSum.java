package com.algorithm.hacker;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by proshad on 1/17/17.
 */
public class MinMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();

        SortedSet<Long> sortedSet = new TreeSet();
        sortedSet.add(a + b + c + d);
        sortedSet.add(a + b + c + e);
        sortedSet.add(a + c + d + e);
        sortedSet.add(a + b + d + e);
        sortedSet.add(b + c + d + e);
        System.out.println(sortedSet.first() + " " + sortedSet.last());
    }

}
