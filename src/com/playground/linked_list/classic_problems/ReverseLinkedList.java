package com.playground.linked_list.classic_problems;

import com.playground.linked_list.data_structure.Node;

/**
 * Both solutions are pretty fast(same runtime) but the recursion provides better memory usage.
 * 206. Reverse Linked List
 * ============================
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * ===========================
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */
public class ReverseLinkedList {

    public Node reverseListLoop(Node head) {
        // Empty list.
        if(head == null) return head;

        Node prev = null;
        Node curr = head;
        // List of size one.
        if(curr.next == null)
            return head;

        // List of size 2 or more.
        Node next = head.next;
        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        // Reverse last node.
        curr.next = prev;
        prev = curr;
        return prev;
    }

    public Node reverseListRecursion(Node head) {
        if(head == null) return null;
        Node newHead = head;
        if(head.next != null) {
            newHead = reverseListRecursion(head.next);
            head.next.next = head;
        }
        head.next = null;
        return newHead;
    }

    Node newHead;

    public Node reverseList(Node head) {
        if(head == null) return null;
        reverseListRec(head);
        head.next = null;
        return newHead;
    }

    public Node reverseListRec(Node head) {
        if( head == null ) return null;

        Node node = reverseListRec(head.next);
        if(node != null)
            node.next = head;
        else
            newHead = head;
        return head;
    }
}
