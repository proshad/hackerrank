package com.hacker.algorithm.basic;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Proshad
 * Date: 1/21/17
 * Time: 11:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class Encryption {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int row = (int) Math.floor(Math.pow(s.length(), 0.5));
        int col = (int) Math.ceil(Math.pow(s.length(), 0.5));
        String ans = "";
        for (int i = 0; i < col; i++) {
            int j = 0;
            do {
                ans = ans + s.substring(i + j, i + j + 1);
                j = j + col;
            } while (i + j < s.length());
            ans = ans + " ";
        }
        System.out.println(ans);
    }
}
