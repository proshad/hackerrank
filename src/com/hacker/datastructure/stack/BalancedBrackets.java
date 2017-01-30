package com.hacker.datastructure.stack;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by proshad on 1/30/17.
 */
public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            String s = in.next();
            char[] chars = s.toCharArray();
            int len = chars.length;
            if(len%2!=0){
                System.out.println("NO");
                continue;
            }
            int i = 0;
            LinkedList<Character> listC = new LinkedList<Character>();
            while (i < len) {
                listC.add(chars[i++]);
            }
            int length = listC.size();
            int num = 0;
            while (num<length)
            {
                if(num==length-1){
                    break;
                }
                char first = listC.get(num);
                char second = listC.get(num+1);
                if(matched(first,second)){
                    listC.remove(num);  // remove first and second element
                    listC.remove(num);
                    length=listC.size();
                    num = Math.max(num-1,0);
//                    num =0;
                }else {
                    num++;
                }
            }
            if (!listC.isEmpty())
                System.out.println("NO");
            else
                System.out.println("YES");

        }
        in.close();
    }

    private static boolean matched(char a, char b) {
        boolean flag = false;
        if (a == '(' && b == ')') {
            flag = true;
        } else if (a == '{' && b == '}') {
            flag = true;
        } else if (a == '[' && b == ']') {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
}
