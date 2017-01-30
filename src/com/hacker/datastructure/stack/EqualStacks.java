package com.hacker.datastructure.stack;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Proshad
 * Date: 1/30/17
 * Time: 8:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class EqualStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        int sum1[] = new int[n1];
        int sum2[] = new int[n2];
        int sum3[] = new int[n3];
        for (int i = 0; i < n1; i++) {
            h1[i] = in.nextInt();
        }
        int h2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            h2[i] = in.nextInt();
        }
        int h3[] = new int[n3];
        for (int i = 0; i < n3; i++) {
            h3[i] = in.nextInt();
        }
        int a = 0, b = 0, c = 0;
        for (int i=n1-1;i>-1;i--) {
            if (a == 0) {
                sum1[a] = h1[i];
            } else {
                sum1[a] = (h1[i] + sum1[a - 1]);
            }
            a++;
        }
        for (int i=n2-1;i>-1;i--) {
            if (b == 0) {
                sum2[b] = h2[i];
            } else {
                sum2[b] = h2[i] + sum2[b - 1];
            }
            b++;
        }
        for (int i=n3-1;i>-1;i--) {
            if (c == 0) {
                sum3[c] = h3[i];
            } else {
                sum3[c] = h3[i] + sum3[c - 1];
            }
            c++;
        }

        int i = 0, j = 0, k = 0;
        Stack<Integer> st = new Stack<Integer>();
        // Iterate through three arrays while all arrays have elements
        while (i < sum1.length && j < sum2.length && k < sum3.length) {
            if (sum1[i] == sum2[j] && sum2[j] == sum3[k]) {
                st.push(sum1[i]);
                i++;
                j++;
                k++;
            } else if (sum1[i] < sum2[j])
                i++;
            else if (sum2[j] < sum3[k])
                j++;
            else
                k++;
        }
        System.out.println(st.peek());

        in.close();
    }
}
