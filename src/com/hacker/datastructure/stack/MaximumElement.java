package com.hacker.datastructure.stack;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by proshad on 1/30/17.
 */
public class MaximumElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            if (t == 1) {
                int val = in.nextInt();
                st.push(val);
            } else if (t == 2) {
                st.pop();
            } else {
                System.out.println(Collections.max(st));

            }
        }
        in.close();
    }
}
