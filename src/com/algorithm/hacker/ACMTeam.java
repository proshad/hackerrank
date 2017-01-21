package com.algorithm.hacker;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by proshad on 1/18/17.
 */
public class ACMTeam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfPeople = scanner.nextInt();
        int numOfTopics = scanner.nextInt();
        BigInteger[] visitTopics = new BigInteger[numOfPeople];
        int maxTopicsCount = 0;
        int maxTeamCount = 0;
        BigInteger combine;


        for(int i=0; i<numOfPeople; i++) {
            visitTopics[i] = scanner.nextBigInteger(2);
        }
        // simply do a binary or of each combination of binary  e.g  100 | 001 == 101  then count the no of 1's
        for(int i=0; i<visitTopics.length-1; i++) {
            for(int j=i+1; j<=visitTopics.length-1; j++) {
                combine = visitTopics[i].or(visitTopics[j]);
                int bitCount = combine.bitCount();
                if(bitCount > maxTopicsCount) {
                    maxTopicsCount = bitCount;
                    maxTeamCount = 1;
                } else if(bitCount == maxTopicsCount) {
                    maxTeamCount++;
                }
            }
        }
        System.out.println(maxTopicsCount);
        System.out.println(maxTeamCount);

    }
}
