package com.hacker.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Proshad
 * Date: 1/29/17
 * Time: 10:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class TextEditor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = "";
        Stack<String> st = new Stack<String>();
        st.push(s);
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            if (t == 1) {
                String val = in.next();
                s = s + val;
                st.push(s);
            } else if (t == 2) {
                int k = in.nextInt();
                int len = s.length();
                s = s.substring(0, (len - k));
                st.push(s);
            } else if (t == 3) {
                int index = in.nextInt();
                System.out.println(s.charAt(index - 1));
            } else {
                st.pop();
                s = st.peek();
            }
        }
    }
}