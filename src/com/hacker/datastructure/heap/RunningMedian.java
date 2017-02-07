package com.hacker.datastructure.heap;

import java.util.*;

/**
 * Created by proshad on 2/7/17.
 */
public class RunningMedian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<Integer>();
        double median = 0.0;
        for (int i = 1; i <= n; i++) {
            int val = sc.nextInt();

            // sort the list
            if (list.size() == 0) {
                list.add(val);
            } else if (list.get(0) > val) {
                list.add(0, val);
            } else if (list.get(list.size() - 1) < val) {
                list.add(list.size(), val);
            } else {
                int j = 0;
                while (list.get(j) < val) {
                    j++;
                }
                list.add(j, val);
            }

            if(list.size()%2==0){
                int mid = list.size()/2;
                median = (double)(list.get(mid - 1) + list.get(mid))/2;
            }else {
                median = list.get(list.size()/2);
            }
            System.out.println(median);

        }
    }
}
