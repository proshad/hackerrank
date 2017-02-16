package com.hacker.datastructure.heap;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by proshad on 2/16/17.
 */
public class JesseCookies {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        MinHeap m = new MinHeap(n);
        for (int i = 0; i < n; i++) {
            m.insert(sc.nextInt());
        }
        int step = 0;
        int root = m.extractMin();
        while (root<k){
            step++;
            int nextItem = m.extractMin();
            m.insert(root + 2*nextItem);
            root = m.extractMin();
            if(m.getPosition()==1 && root<k){
                step=-1;
                break;
            }
        }
        System.out.println(step);

    }

    public static class MinHeap {
        public int size;
        public int[] mH;
        public int position;

        public MinHeap(int size) {
            this.size = size;
            mH = new int[size + 1];
            position = 0;
        }

        public void insert(int x) {
            if (position == 0) {
                mH[position + 1] = x;
                position = 2;
            } else {
                mH[position++] = x;
                bubbleUp();
            }
        }

        public int getPosition(){
            return position;
        }

        public void bubbleUp() {
            int pos = position - 1;
            while (pos > 0 && mH[pos / 2] > mH[pos]) {
                int y = mH[pos];
                mH[pos] = mH[pos / 2];
                mH[pos / 2] = y;
                pos = pos / 2;
            }
        }

        public int extractMin() {
            int min = mH[1];
            mH[1]=mH[position-1];
            mH[position-1]=0;
            position--;
            sinkDown(1);
            return min;
        }

        public void sinkDown(int k) {
            int a = mH[k];
            int smallest = k;
            if (2 * k < position && mH[smallest] > mH[2 * k]) {
                smallest = 2 * k;
            }
            if (2 * k + 1 < position && mH[smallest] > mH[2 * k + 1]) {
                smallest = 2 * k + 1;
            }
            if (smallest != k) {
                swap(k, smallest);
                sinkDown(smallest);
            }

        }

        public void swap(int a, int b) {
            int temp = mH[a];
            mH[a] = mH[b];
            mH[b] = temp;
        }

    }
}
