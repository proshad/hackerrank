package com.hacker.algorithm.basic;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Proshad
 * Date: 1/21/17
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class DesignerPDF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 26;
        int h[] = new int[n];
        for(int h_i=0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int wordLength = word.length();
        int max=0;
        int area=1;
        for(int i=0;i<wordLength;i++){
            int ascii = (int) word.charAt(i);
            int index = ascii -97;
            int height = h[index];
            if(height>max)
                max = height;
        }
        area = wordLength*max;
        System.out.println(area);
    }
}
