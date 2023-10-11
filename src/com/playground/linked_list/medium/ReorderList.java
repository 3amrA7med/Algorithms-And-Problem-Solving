package com.playground.linked_list.medium;

import com.playground.linked_list.data_structure.LinkedList;
import com.playground.linked_list.data_structure.Node;

/**
 * 143. Reorder List
 * Beats 31.36%, 2ms
 * Beats 52.52%, 46mb, best 44
 * ====================
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * ============================
 * a better idea would be using floyds algorithm to iterate and get the middle of the list,
 * - slow pointer at first element
 * - fast pointer at the next
 * - stop when fast == null or fast.next == null
 */
public class ReorderList {

    public void run() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAtHead(1);
//        linkedList.addAtTail(2);
//        linkedList.addAtTail(3);
//        linkedList.addAtTail(4);
//        linkedList.addAtTail(5);
        reorderList(linkedList.head);
        System.out.println(linkedList.head);
    }

    public void reorderList(Node head) {
        if(head == null) return;
        Node curr = head;

        int size = 0;
        while(curr != null) {
            curr = curr.next;
            size++;
        }

        int firstHalf = size/2;

        int i = 0;
        curr = head;
        while(i<firstHalf) {
            curr = curr.next;
            i++;
        }
        Node reversedList = reverseList(curr.next);
        curr.next = null;

        curr = head;
        while(reversedList != null) {
            Node temp = curr.next;
            curr.next = reversedList;
            reversedList = reversedList.next;
            curr.next.next = temp;
            curr = temp;
        }
    }

    Node newHead;

    public Node reverseList(Node head) {
        if(head == null) return null;
        Node node = reverseListRec(head);
        node.next = null;
        return newHead;
    }

    public Node reverseListRec(Node head) {
        if(head == null) return null;
        Node node = reverseListRec(head.next);
        if(node == null) {
            newHead = head;
            return head;
        }
        node.next = head;
        return head;
    }
}
