package com.hacker.datastructure.stack;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by proshad on 1/30/17.
 */
public class MaximumElement2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = 0;
        Stack<MaxNode> st = new Stack<MaxNode>();
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            if (t == 1) {
                int val = in.nextInt();
                max = Math.max(max, val);
                st.push(new MaxNode(max,val));
            } else if (t == 2) {
                st.pop();
                if(st.empty()){
                    max = 0;
                }else {
                    max = st.peek().max;
                }
            } else {
                System.out.println(st.peek().max);
            }
        }
        in.close();
    }

    private static class MaxNode{
        int max;
        int val;
        public MaxNode(int max, int val){
            this.max = max;
            this.val = val;
        }
    }
}
