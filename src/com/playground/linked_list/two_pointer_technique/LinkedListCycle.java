package com.playground.linked_list.two_pointer_technique;

import com.playground.linked_list.data_structure.LinkedList;
import com.playground.linked_list.data_structure.Node;

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
     * @param head
     * @return
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
     * @param head
     * @return
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
