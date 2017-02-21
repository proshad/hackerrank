package com.hacker.datastructure.disjoint;

import java.util.*;

/**
 * Created by proshad on 2/21/17.
 */
public class ComponentsInGraph {
    private static Map<Integer, Node> map = new HashMap();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[2 * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            arr[k++] = sc.nextInt();
            arr[k++] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            makeSet(arr[i * 2]);
            makeSet(arr[i * 2 + 1]);
        }

        for (int i = 0; i < n; i++) {
            union(arr[i * 2], arr[i * 2 + 1]);
        }

        Map<Integer, Integer> occurences = new HashMap<Integer, Integer>();

        Set<Integer> uniqVal = new TreeSet<Integer>();
        uniqVal.addAll(Arrays.asList(arr));

        Iterator<Integer> itr = uniqVal.iterator();
        while (itr.hasNext()) {
            int key = findSet(itr.next());
            if (occurences.containsKey(key)) {
                int occurrence = occurences.get(key);
                occurrence++;
                occurences.put(key, occurrence);
            } else {
                occurences.put(key, 1);
            }
        }

        Iterator iterator = occurences.keySet().iterator();
        int max = 0;
        int min = 0;
        while (iterator.hasNext()) {
            int key = (Integer) iterator.next();
            int occurrence = occurences.get(key);
            if(max==0 && min==0){
                max = occurrence;
                min = occurrence;
            }
            if (max < occurrence) {
                max = occurrence;
            }
            if (min > occurrence) {
                min = occurrence;
            }
        }
        System.out.println(min + " " + max);

    }

    public static int findSet(int data) {
        return findSet(map.get(data)).data;
    }

    // create set with only one element
    public static void makeSet(int data) {
        Node node = new Node();
        node.data = data;
        node.rank = 0;
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
        } else {
            parent1.parent = parent2;
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
        Node parent;
    }
}
