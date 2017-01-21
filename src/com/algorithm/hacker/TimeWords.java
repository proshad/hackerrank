package com.algorithm.hacker;

import java.util.Scanner;

/**
 * Created by proshad on 1/19/17.
 */
public class TimeWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
                "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "thirty",
                "thirty one", "thirty two", "thirty three", "thirty four", "thirty five", "thirty six", "thirty seven", "thirty eight", "thirty nine", "forty",
                "forty one", "forty two", "forty three", "forty four", "forty five", "forty six", "forty seven", "forty eight", "forty nine", "fifty",
                "fifty one", "fifty two", "fifty three", "fifty four", "fifty five", "fifty six", "fifty seven", "fifty eight", "fifty nine"};

        if(m==0){
            System.out.println(words[h-1] +" o' clock");
        }else if(m==30){
            System.out.println("half past "+words[h-1]);
        }else if(m==1){
            System.out.println("one minute past "+words[h-1]);
        }else if(m==15){
            System.out.println("quarter past "+words[h-1]);
        }else if(m==45){
            System.out.println("quarter to "+words[h]);
        }else if(m<30){
            System.out.println(words[m - 1]+" minutes past "+words[h-1]);
        }else {
            int remaining = 60-m;
            if (remaining==1){
                System.out.println("one minute to " + words[h]);
            }else {
                System.out.println(words[remaining - 1] + " minutes to " + words[h]);
            }
        }
    }
}
