package com.exercise.linked_list.classic_problems;

import com.exercise.linked_list.data_structure.Node;

/**
 * Both solutions are pretty fast(same runtime) but the recursion provides better memory usage.
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
}
