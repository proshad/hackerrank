package com.datastructure.hacker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by proshad on 1/24/17.
 */
public class DynamicArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lastAns = 0;
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int tag, x, y, index;

        ArrayList<Integer>[] list = new ArrayList[N];

        while (Q-- > 0) {
            tag = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            index = (x ^ lastAns) % N;

            if (tag == 1) {
                if (list[index] == null) {
                    ArrayList<Integer> myList = new ArrayList<Integer>();
                    myList.add(y);
                    list[index] = myList;
                } else
                    list[index].add(y);
            } else if (tag == 2) {
                int ind = y % list[index].size();
                lastAns = list[index].get(ind);
                System.out.println(lastAns);
            } else {
                System.out.println();
            }

        }
    }

}

