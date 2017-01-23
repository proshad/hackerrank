package com.datastructure.hacker;

import java.util.Scanner;

/**
 * Created by proshad on 1/23/17.
 */
public class SparseArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int lenght = sc.nextInt();
        String[] array = new String[lenght];
//        StringBuilder builder = new StringBuilder();
        for(int i=0;i<lenght;i++){
            String temp = sc.next();
            array[i]= temp;
//            builder.append(temp+" ");
        }
//        String original = builder.toString();
        int totalCompare = sc.nextInt();

        for(int k=0;k<totalCompare;k++){
            String compare =sc.next();
            int count=0;
            for(int i=0;i<lenght;i++){
                if(compare.equals(array[i]))
                    count++;
            }
            System.out.println(count);
        }

    }
}
