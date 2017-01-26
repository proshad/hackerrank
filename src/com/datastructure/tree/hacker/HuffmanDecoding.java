package com.datastructure.tree.hacker;

/**
 * Created by proshad on 1/26/17.
 */
public class HuffmanDecoding {

    class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }

    void decode(String S ,Node root)
    {
        StringBuilder restult = new StringBuilder();
        Node current = root;

        while (!S.isEmpty()){
            if (S.charAt(0) == '1'){
                current = current.right;
                S = S.substring(1);
            }
            else {
                current = current.left;
                S = S.substring(1);
            }
            if (current.left == null && current.right == null){
                restult.append(current.data);
                current = root;
            }

        }
        System.out.println(restult.toString());


    }
}
