package com.playground.linked_list.conclusion;

import com.playground.linked_list.data_structure.Node;

/**
 * 61. Rotate List
 * ================================
 * Given the head of a linked list, rotate the list to the right by k places.
 * ========================
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 */
public class RotateList {

    /**
     * 84.8% faster
     * 63.6% better memory
     */
    public Node rotateRight(Node head, int k) {
        if(head == null || head.next == null) return head;
        // Get list size.
        int size = 0;
        Node slowIterator = head;
        Node fastIterator = head;

        while(slowIterator != null){
            slowIterator = slowIterator.next;
            size++;
        }

        // Get actual number of rotations needed.
        k = k%size;

        if(k == 0 ) return head;

        slowIterator = head;
        while(fastIterator.next != null && k != 0) {
            fastIterator = fastIterator.next;
            k--;
        }

        // Place the sub list at the beginning.
        while(fastIterator.next != null) {
            fastIterator = fastIterator.next;
            slowIterator = slowIterator.next;
        }
        Node newHead = slowIterator.next;
        slowIterator.next = null;
        fastIterator.next = head;

        return newHead;
    }
}
