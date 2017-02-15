package com.hacker.datastructure.heap;

import java.util.Scanner;

/**
 * Created by proshad on 2/15/17.
 * http://algorithms.tutorialhorizon.com/binary-min-max-heap/
 */
public class QHeap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MinHeap m = new MinHeap(n);
        for (int i = 0; i < n; i++) {
            int q = sc.nextInt();
            if (q == 1) {   // add element
                int x = sc.nextInt();
                m.insert(x);

            } else if (q == 2) {  // delete element
                m.delete(sc.nextInt());
            } else {   // print element
                System.out.println(m.extractMin());

            }
        }
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
            return mH[1];
        }

        public void delete(int val) {
            for (int i = 1; i < mH.length; i++) {
                if (mH[i] == val) {
                    mH[i] = mH[position - 1];
                    mH[position - 1] = 0;
                    position--;
                    sinkDown(i);
                    return;
                }

            }
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
