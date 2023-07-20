package com.playground.linked_list.classic_problems;

import com.playground.linked_list.data_structure.LinkedList;
import com.playground.linked_list.data_structure.Node;

public class OddEvenLinkedList {

        public void run() {
            // 1 2 3 4 5
            // [2,1,3,5,6,4,7]
            LinkedList linkedList = new LinkedList();
            linkedList.addAtHead(2);
            linkedList.addAtIndex(1, 1);
            linkedList.addAtIndex(2, 3);
            linkedList.addAtIndex(3, 5);
            linkedList.addAtTail(6);
            linkedList.addAtTail(4);
            linkedList.addAtTail(7);

            System.out.println(oddEvenList(linkedList.head));
        }

    /**
     * Designed for even odd values in the list.
     * @param head
     * @return
     */
    public Node oddEvenValuesList(Node head) {
            if(head == null || head.next == null) return head; // Base case.

            Node fakeEvenHead = new Node(-1); // Dummy value.
            Node currEven = fakeEvenHead; // Iterator for even list.

            Node prev = head;
            Node curr = head.next;

            // If even node is the first node.
            while(prev != null && prev.val % 2 == 0) {
                currEven.next = prev; // Set new even value.
                currEven = currEven.next; // Increment one step in even list.
                prev = prev.next; // Increment current only while leave prev at last odd.
                curr = curr.next; // Remove even value from original list.
                head = prev; // Change head of the new odd list.
            }

            while(curr != null) {
                if(curr.val % 2 == 0) { // Even value
                    currEven.next = curr; // Set new even value.
                    currEven = currEven.next; // Increment one step in even list.
                    curr = curr.next; // Increment current only while leave prev at last odd.
                    prev.next = curr; // Remove even value from original list.
                }
                else {
                    // Increment original list.
                    prev = curr;
                    curr = curr.next;
                }
            }
            currEven.next = null;
            // Set even list in the end of the original list.
            prev.next = fakeEvenHead.next;
            return head;
        }

    public Node oddEvenList(Node head) {
        if(head == null || head.next == null) return head; // Base case.
        Node currOdd = head;
        Node evenHead = head.next;
        Node currEven = head.next; // Iterator for even list.

        while(currEven != null && currEven.next != null) {
            currOdd.next = currEven.next;
            currOdd = currOdd.next;
            currEven.next = currEven.next.next;
            currEven = currEven.next;
        }
        currOdd.next = evenHead;
        return head;
    }
}
