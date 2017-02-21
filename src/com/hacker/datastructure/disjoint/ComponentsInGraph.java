package com.hacker.datastructure.disjoint;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by proshad on 2/21/17.
 */
public class ComponentsInGraph {
    private Map<Integer, Node> map = new HashMap();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ComponentsInGraph solution = new ComponentsInGraph();
        int[] arr = new int[2*n];
        int k=0;
        for(int i=0;i<n;i++){
            arr[k++] = sc.nextInt();
            arr[k++] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            solution.makeSet(arr[i*2]);
            solution.makeSet(arr[i*2+1]);
        }

        for(int i=0;i<n;i++){
            solution.union(arr[i*2],arr[i*2+1]);
        }

        for(int i=0;i<n;i++){
            System.out.println(solution.findSet(arr[i*2]));
            System.out.println(solution.findSet(arr[i*2+1]));
        }

    }

    public  int findSet(int data){
        return findSet(map.get(data)).data;
    }

    // create set with only one element
    public void makeSet(int data) {
        Node node = new Node();
        node.data = data;
        node.rank = 0;
        node.parent = node;
        map.put(data, node);
    }

    // combine two sets together to one. Does union by rank
    public void union(int data1, int data2) {
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

    public Node findSet(Node node) {
        Node parent = node.parent;
        if (node == parent) {
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    class Node {
        int data;
        int rank;
        Node parent;
    }
}
