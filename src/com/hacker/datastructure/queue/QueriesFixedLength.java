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
            LinkedList<Integer> queue = new LinkedList<Integer>();
            LinkedList<Integer> maxQueue = new LinkedList<Integer>();
            int len =  Math.min(d+t,n);
            int initial = t%n;
            int max = arr[initial];
            for (int i = initial; i < len; i++) {
                int item = arr[i];
                queue.add(item);
                if (maxQueue.size() < 1) {
                    maxQueue.add(item);
                } else {
                    int tail = maxQueue.peekLast();
                    if (tail < item) {
                        maxQueue.add(item);
                    } else {
                        // delete until tail is greater than element or queue becomes empty
                        while (tail > item && maxQueue.size() > 0) {
                            maxQueue.poll();
                        }
                        maxQueue.add(item);
                    }
                }


                if (maxQueue.size() > d) {
                    int deletedItem = queue.poll();
                    if (deletedItem == maxQueue.peek()) {
                        maxQueue.poll();
                    }
                }

            }
            System.out.println(maxQueue.peek());
        }
    }

}
