package com.playground.linked_list.two_pointer_technique;

import com.playground.linked_list.data_structure.LinkedList;
import com.playground.linked_list.data_structure.Node;

/**
 * 141. Linked List Cycle
 * ===========================
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached
 * again by continuously following the next pointer. Internally, pos is used to denote the index
 * of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * ==========================
 * 3 - 2 - 0 -> -4
 *     |         |
 *     -  -  -  -
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 */
public class LinkedListCycle {

    public void run() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAtHead(3);
        linkedList.addAtIndex(1, 2);
        linkedList.addAtIndex(2, 0);
        linkedList.addAtTail(-4);
        Node node2 = linkedList.getNode(1);
        Node nodeTail = linkedList.getNode(3);
        nodeTail.next = node2;

        detectCycle(linkedList.head);
    }

    /**
     * This function just identify that there is a cycle.
     */
    public boolean hasCycle(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while(slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next; // Move by one step.
            fastPointer = fastPointer.next.next; // Move by steps.
            if(slowPointer == fastPointer) // Compare object itself.
                return true;
        }

        return false;
    }

    /**
     * This function identify the node in which the cycle begins at. Apply Floyd's algorithm.
     */
    public Node detectCycle(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        boolean cycleFound = false;
        // Detects if there is a cycle.
        while(slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next; // Move by one step.
            fastPointer = fastPointer.next.next; // Move by steps.
            if(slowPointer == fastPointer) // Compare object itself.
            {
                cycleFound = true;
                break;
            }
        }
        if(!cycleFound) return null;
        // We are done with fast pointer, and now we want another slow pointer at the head.
        Node slowPointer2 = head;
        // Detect which node the cycle begun at.
        while(slowPointer != slowPointer2) {
            slowPointer = slowPointer.next;
            slowPointer2 = slowPointer2.next;
        }

        return slowPointer;
    }
}
