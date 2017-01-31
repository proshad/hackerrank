package com.hacker.datastructure.stack;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by proshad on 1/31/17.
 */
public class MyWaiter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] prime = new int[Q];
        // generate required prime number
        int count = 0;
        while (count < Q) {
            for (int i = 2; i < Integer.MAX_VALUE; i++) {
                boolean isPrimeNumber = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrimeNumber = false;
                        break;
                    }
                }
                if (isPrimeNumber) {
                    prime[count] = i;
                    count++;
                    if (count == Q)
                        break;
                }

            }
        }

        LinkedList<Stack<Integer>> A = new LinkedList<Stack<Integer>>();
        LinkedList<Stack<Integer>> B = new LinkedList<Stack<Integer>>();
        // initialize all stack
        for (int i = 0; i <= Q; i++) {
            A.add(new Stack<Integer>());
            B.add(new Stack<Integer>());
        }

        // add in first stack A
        for (int i = 0; i < N; i++) {
            A.get(0).push(sc.nextInt());
        }
        sc.close();

        for (int i = 1; i <= Q; i++) {
            Stack<Integer> current = A.get(i - 1);
            Stack<Integer> aStack = A.get(i);
            Stack<Integer> bStack = B.get(i);
            int primeNo = prime[i - 1];
            while (!current.empty()) {
                int num = current.pop();
                if (num % primeNo == 0) {
                    bStack.push(num);
                } else {
                    aStack.push(num);
                }
            }

        }

        // **** display the contents of the B stack(s) ****

        for (int i = 0; i < B.size(); i++) {
            Stack<Integer> bStack = B.get(i);
            while (!bStack.isEmpty())
                System.out.println(bStack.pop());
        }

        // **** display the contents of the A stack(s) ****

        for (int i = 0; i < A.size(); i++) {
            Stack<Integer> aStack = A.get(i);
            while (!aStack.isEmpty())
                System.out.println(aStack.pop());

        }

    }

}
