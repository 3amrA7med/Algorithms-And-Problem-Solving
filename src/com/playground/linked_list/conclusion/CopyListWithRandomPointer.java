package com.playground.linked_list.conclusion;

import com.playground.linked_list.data_structure.RandomNode;

public class CopyListWithRandomPointer {

    public void run () {
        RandomNode seven = new RandomNode(7);
        RandomNode thirteen = new RandomNode(13);
        RandomNode eleven = new RandomNode(11);
        RandomNode ten = new RandomNode(10);
        RandomNode one = new RandomNode(1);

        seven.next = thirteen;
        thirteen.next = eleven;
        eleven.next = ten;
        ten.next = one;

        seven.random = null;
        thirteen.random = seven;
        eleven.random = one;
        ten.random = eleven;
        one.random = seven;

        RandomNode head = copyRandomList(seven);
        System.out.println(head);
    }

    /**
     *
     * Intuitive solution is to use hashmap to save oldNode -> CopyNode Mapping in it
     * Applying interweaving
     *
     * 100% faster
     * 77% better memory
     *
     * @param head pointer to the head of the linked list.
     * @return return copied head.
     */
    public RandomNode copyRandomList(RandomNode head) {
        if(head == null) return null;

        RandomNode curr = head;
        RandomNode temp;

        // Step 1: Loop on the list to apply interweaving technique.
        while(curr != null) {
            // Create new node
            temp = new RandomNode(curr.val);

            temp.next = curr.next;
            curr.next = temp;

            // Get next node in the original list.
            curr = temp.next;
        }

        curr = head;
        RandomNode copiedHead = head.next;

        while(curr != null) {
            // Step 2: assign random nodes in the copied list.
            temp = curr.random;
            curr.next.random = (temp != null)? temp.next: null;

            curr = curr.next.next;
        }

        curr = head;
        // Step 3: Restore original & copied list.
        while(curr != null) {
            temp = curr.next;
            curr.next = curr.next.next;
            temp.next = (temp.next != null)? temp.next.next: null;
            curr = curr.next;
        }
        return copiedHead;
    }
}
