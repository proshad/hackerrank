package com.hacker.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by proshad on 2/1/17.
 */
public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        sc.close();

        boolean flag = true;
        int counter = 0;
        while (flag==true){
            flag = false;
            int lastIndex = stack.size()-1;
            for(int i=lastIndex;i>0;i--){
                int top = stack.get(i);
                int previous = stack.get(i-1);
                if(top>previous){
                    stack.remove(i);
                    if(!flag){
                        flag = true;
                        counter++;
                    }
                }
            }

        }
        System.out.println((counter));
    }
}
