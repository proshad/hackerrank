package com.hacker.datastructure.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by proshad on 2/3/17.
 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
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
            int k = sc.nextInt();
            Deque<Integer> queue = new LinkedList<Integer>();
            int i;
            for (i = 0; i < k; ++i) {
                // For very element, the previous smaller elements are useless so remove them from Qi
                while ((!queue.isEmpty()) && arr[i] >= arr[queue.peekLast()])
                    queue.removeLast();  // Remove from tail

                // Add new element at tail of queue
                queue.add(i);
            }
            int min = arr[queue.peek()];

            // Process rest of the elements, i.e., from arr[k] to arr[n-1]
            for (i=k; i < n; ++i) {
                // Remove the elements which are out of this window
                while ((!queue.isEmpty()) && queue.peek() <= i - k)
                    queue.poll();  // Remove from front of queue

                // Remove all elements smaller than the currently added element (remove useless elements)
                while ((!queue.isEmpty()) && arr[i] >= arr[queue.peekLast()])
                    queue.removeLast();

                // Add current element at the rear of Qi
                queue.add(i);
                int max = arr[queue.peek()];
                if (min > max) {
                    min = max;
                }
            }
            System.out.println(min);
        }
    }

}
