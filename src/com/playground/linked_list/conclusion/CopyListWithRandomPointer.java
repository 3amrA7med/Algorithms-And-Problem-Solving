package com.playground.linked_list.conclusion;

import com.playground.linked_list.data_structure.RandomNode;

/**
 * 138. Copy List with Random Pointer
 * ====================================
 * interweaving
 * ========================
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list
 * such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y,
 * then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * Return the head of the copied linked list.
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented
 * as a pair of [val, random_index] where:
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 * ===============
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
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
