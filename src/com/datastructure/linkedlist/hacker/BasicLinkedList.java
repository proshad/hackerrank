package com.datastructure.linkedlist.hacker;

/**
 * Created by proshad on 1/24/17.
 */
public class BasicLinkedList {
    // Print the Elements of a Linked List

    void Print(Node head) {
        if (head != null) {
            System.out.println(head.data);
            Print(head.next);
        }
    }

    //Insert a Node at the Tail of a Linked List
    Node Insert(Node head, int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;

        if (head == null) {
            head = temp;
            return head;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
            return head;
        }


    }

    //Insert a node at the head of a linked list
    Node InsertAtHead(Node head, int x) {
        Node n = new Node();
        n.data = x;
        n.next = head;
        return n;

    }


    //Insert a node at a specific position in a linked list
    Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node existing = head;
        Node newNode = new Node();
        newNode.data = data;
        if (head == null)
            return newNode;
        if (position == 0) {
            newNode.next = head;
            return newNode;
        }

        int currentPosition = 0;
        while (currentPosition < position - 1 && head.next != null) {
            head = head.next;
            currentPosition++;
        }

        Node nextNode = head.next;
        head.next = newNode;
        head = head.next;
        head.next = nextNode;
        return existing;
    }

    //Delete a Node
    Node Delete(Node head, int position) {
        // Complete this method
        if (position == 0) {
            return head.next;
        }
        Node currentNode = head;
        Node prevNode = head;
        for (int i = 0; i < position; i++) {
            prevNode = currentNode;
            if (currentNode.next == null) {
                break;
            }
            currentNode = currentNode.next;
        }

        prevNode.next = currentNode.next;
        return head;

    }

    // Print in Reverse
    void ReversePrint(Node head) {

        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    //Compare two linked lists
    int CompareLists(Node headA, Node headB) {
//        int lengthA = 0;
//        int lengthB = 0;
//        Node tempA = headA;
//        Node tempB = headB;
//        while (tempA != null) {
//            lengthA++;
//            tempA = tempA.next;
//        }
//        while (tempB != null) {
//            lengthB++;
//            tempB = tempB.next;
//        }
//        if (lengthA != lengthB)
//            return 0;
//        boolean flag = true;
//        while (headA != null) {
//            int data1 = headA.data;
//            int data2 = headB.data;
//            if (data1 != data2) {
//                flag = false;
//                break;
//            }
//            headA = headA.next;
//            headB = headB.next;
//        }
//        if(!flag)
//            return 0;
//        return 1;




        while (headA!=null && headB!=null && (headA.data == headB.data)) {
            headA = headA.next;
            headB =headB.next;
        }
        boolean flag = headA == headB;
        if (!flag)
            return 0;
        return 1;
    }

}

class Node {
    int data;
    Node next;
}
