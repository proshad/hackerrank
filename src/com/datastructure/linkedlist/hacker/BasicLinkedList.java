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
        if (position == 0){
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

}

class Node {
    int data;
    Node next;
}
