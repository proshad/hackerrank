package com.hacker.datastructure.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by proshad on 1/31/17.
 */
/*
Get the algorithm from youtube Maximum Rectangular Area in Histogram
https://www.youtube.com/watch?v=ZmnqCZp9bBs&list=PLrmLmBdmIlptv-uwAgP8k5pGdlHedncq1
*/

public class LargestRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        sc.close();

        int i, area = 0, maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (i = 0; i < height.length; ) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = height[top] * i;
                } else {
                    area = height[top] * (i - stack.peek() - 1);
                }
                if (area > maxArea)
                    maxArea = area;
            }
        }

        while (!stack.isEmpty()){
            int top = stack.pop();
            if (stack.isEmpty()) {
                area = height[top] * i;
            } else {
                area = height[top] * (i - stack.peek() - 1);
            }
            if (area > maxArea)
                maxArea = area;
        }

        System.out.println(maxArea);

    }

}
