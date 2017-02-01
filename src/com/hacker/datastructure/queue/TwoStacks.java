package com.hacker.datastructure.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by proshad on 2/1/17.
 */
public class TwoStacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList queue = new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            int type = sc.nextInt();
            if(type==1){
                queue.add(sc.nextInt());
            }else if(type==2){
                queue.poll();
            }else if(type==3){
                System.out.println(queue.peek());
            }else {
                return;
            }
        }
        sc.close();
    }
}
