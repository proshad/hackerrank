package com.hacker.algorithm.basic;

import java.util.Scanner;

/**
 * Created by proshad on 1/19/17.
 */
public class BonAppetit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int items = sc.nextInt();
        int declineItem = sc.nextInt();
        int[] cost = new int[items];
        int totalCost = 0;
        for(int i=0;i<items;i++){
            int price = sc.nextInt();
            cost[i] = price;
            totalCost+=price;
        }
        int annaCharged = sc.nextInt();
        int sharedCost = totalCost - cost[declineItem];
        int sharedAmount = sharedCost/2;
        if (annaCharged==sharedAmount){
            System.out.println("Bon Appetit");
        }else {
            System.out.println(Math.abs((annaCharged-sharedAmount)));
        }
    }
}
