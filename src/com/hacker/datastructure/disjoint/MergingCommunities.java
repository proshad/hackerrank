package com.hacker.datastructure.disjoint;

import java.util.*;

/**
 * Created by proshad on 2/21/17.
 */
public class MergingCommunities {
    private static Map<Integer, Node> map = new HashMap();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> ds = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            char query = sc.next().charAt(0);
            if (query == 'Q') {
                int a = sc.nextInt();
                System.out.println(findSet(a));
            } else if (query == 'M') {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (a <= n && b <= n) {
                    if (!ds.contains(a)) {
                        ds.add(a);
                        makeSet(a);
                    }
                    if (!ds.contains(b)) {
                        ds.add(b);
                        makeSet(b);
                    }
                    union(a, b);
                }
            }
        }

    }

    public static int findSet(int data) {
        Node node = map.get(data);
        if (node != null) {
            return findSet(node).noOfMembers;
        }
        return 1;
    }

    // create set with only one element
    public static void makeSet(int data) {
        Node node = new Node();
        node.data = data;
        node.rank = 0;
        node.noOfMembers = 1;
        node.parent = node;
        map.put(data, node);
    }

    // combine two sets together to one. Does union by rank
    public static void union(int data1, int data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        // if both are same set, do nothing
        if (parent1.data == parent2.data) {
            return;
        }

        // else whoever rank is higher becomes parent of others
        if (parent1.rank >= parent2.rank) {
            // increment rank only if both rank have same rank
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
            parent1.noOfMembers += parent2.noOfMembers;
        } else {
            parent1.parent = parent2;
            parent2.noOfMembers += parent1.noOfMembers;
        }

    }

    public static Node findSet(Node node) {
        Node parent = node.parent;
        if (node == parent) {
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    static class Node {
        int data;
        int rank;
        int noOfMembers;
        Node parent;
    }
}
