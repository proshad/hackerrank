package com.hacker.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

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
        for (int h1_i = 0; h1_i < n1; h1_i++) {
            h1[h1_i] = in.nextInt();
            if(h1_i>0){
                sum1[h1_i] = sum1[h1_i-1]+h1[h1_i];
            }else {
                sum1[h1_i] = h1[h1_i];
            }
        }
        int h2[] = new int[n2];
        for (int h2_i = 0; h2_i < n2; h2_i++) {
            h2[h2_i] = in.nextInt();
            if(h2_i>0){
                sum2[h2_i] = sum2[h2_i-1]+h2[h2_i];
            }else {
                sum2[h2_i] = h2[h2_i];
            }
        }
        int h3[] = new int[n3];
        for (int h3_i = 0; h3_i < n3; h3_i++) {
            h3[h3_i] = in.nextInt();
            if(h3_i>0){
                sum3[h3_i] = sum3[h3_i-1]+h3[h3_i];
            }else {
                sum3[h3_i] = h3[h3_i];
            }
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
        System.out.println(st.size()+" : "+st.peek());
        System.out.println(sum1[n1-1]+" : "+sum2[n2-1]+" : "+sum3[n3-1]);

        in.close();
    }
}
