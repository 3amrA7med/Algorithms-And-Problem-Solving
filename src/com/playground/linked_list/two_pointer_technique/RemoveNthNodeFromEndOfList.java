package com.playground.linked_list.two_pointer_technique;

import com.playground.linked_list.data_structure.Node;

public class RemoveNthNodeFromEndOfList {

    public Node removeNthFromEnd(Node head, int n) {
        Node iterator = head;
        Node prev = null;
        Node curr = head;

        // Advance iterator with the count of n.
        while(n-- != 0) {
            iterator = iterator.next;
        }
        while(iterator != null) {
            iterator = iterator.next;
            prev = curr;
            curr = curr.next;
        }
        if(prev == null)
            head = (head != null)? head.next: null; // Deleting first node.
        else
            prev.next = curr.next;
        return head;
    }
}
