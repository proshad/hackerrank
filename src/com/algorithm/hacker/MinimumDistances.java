package com.algorithm.hacker;

import java.util.*;

/**
 * Created by proshad on 1/19/17.
 */
public class MinimumDistances {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int array[] = new int[n];
        int min = 100000;
        HashSet<Integer> hashSet = new HashSet();
        HashSet<Integer> duplicateSet = new HashSet();
        SortedSet<Integer> sortedSet = new TreeSet();
        for (int A_i = 0; A_i < n; A_i++) {
            int number = in.nextInt();
            array[A_i] = number;
            if (!hashSet.add(number)) {
                duplicateSet.add(number);
            }
        }

        for (int number : duplicateSet) {
            int occurence = 0;
            int previous_index = 0;
            for (int i = 0; i < n; i++) {
                if (number == array[i]) {
                    occurence++;
                    if (occurence == 2) {
                        int pathDiff = i - previous_index;
                        sortedSet.add(pathDiff);
                        break;
                    } else {
                        previous_index = i;
                    }
                }
            }
        }
        if (sortedSet.size() < 1)
            System.out.println("-1");
        else
            System.out.println(sortedSet.first());
    }
}
