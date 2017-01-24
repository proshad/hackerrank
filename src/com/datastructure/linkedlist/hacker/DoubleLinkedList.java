package com.datastructure.linkedlist.hacker;

/**
 * Created by proshad on 1/24/17.
 */
public class DoubleLinkedList {

    //Inserting a Node Into a Sorted Doubly Linked List
    Node SortedInsert(Node head,int data) {

        Node new_node = new Node();
        new_node.data = data;
        Node current = head;

         /* Special case for head node */
        if (head == null)
        {
            head = new_node;
            head.next = head;
        }
        else {
            while (current.next != null && current.next.data < new_node.data)
                current = current.next;

            new_node.next = current.next;
            new_node.prev = current;
            current.next = new_node;
        }

        return head;

    }

//Reverse a doubly linked list
    Node Reverse(Node head) {
        Node temp = null;
        Node current = head;
        /* swap next and prev for all nodes of doubly linked list */
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        /* Before changing head, check for the cases like empty list and list with only one node */
        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }



    class Node {
        int data;
        Node next;
        Node prev;
    }
}
