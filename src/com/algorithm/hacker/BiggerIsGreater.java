package com.algorithm.hacker;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Proshad
 * Date: 1/21/17
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class BiggerIsGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        Writer out = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int k = 0; k < testCase; k++) {
            String original = sc.next();
            int[] arr = new int[original.length()];
            for (int j = 0; j < original.length(); j++) {
                arr[j] = (int) original.charAt(j);
            }
            int i = arr.length - 1;
            while (i > 0 && arr[i - 1] >= arr[i])
                i--;
            // Now i is the head index of the suffix

            // Are we at the last permutation already?
            if (i <= 0) {
                System.out.println("no answer");
                continue;
            }

            // Let array[i - 1] be the pivot
            // Find rightmost element that exceeds the pivot
            int j = arr.length - 1;
            while (arr[j] <= arr[i - 1])
                j--;
            // Now the value array[j] will become the new pivot
            // Assertion: j >= i

            // Swap the pivot with j
            int temp = arr[i - 1];
            arr[i - 1] = arr[j];
            arr[j] = temp;

            // Reverse the suffix
            j = arr.length - 1;
            while (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }


            try {
                for (i = 0; i < arr.length; i++) {
                    out.write((char) arr[i]);
                }
                out.write("\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

}
