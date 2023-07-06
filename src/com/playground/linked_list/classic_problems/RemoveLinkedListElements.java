package com.exercise.linked_list.classic_problems;

import com.exercise.linked_list.data_structure.Node;

/**
 * Both solutions are pretty fast(same runtime) but the recursion provides better memory usage.
 */
public class RemoveLinkedListElements {


    /**
     * Wrong solution. First attempt.
     * we must use fakeHead to avoid edge case [7, 7, 7, 7] val = 7
     * @param head
     * @param val
     * @return
     */
    public Node removeElements(Node head, int val) {
        Node prev = null;
        Node curr = head;
        Node temp;

        while(curr != null) {
            if(curr.val == val) {
                if(prev == null) {
                    temp = curr.next;
                    curr.next = null;
                    curr = temp;
                }
                else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
                continue;
            }
            prev = curr;
            curr = curr.next;
        }

        return head;
    }

    public Node removeElementsWithFakeHeadAndOnePointer(Node head, int val) {
        Node fakeHead = new Node(-1);
        fakeHead.next = head;
        Node prev = fakeHead;
        while(prev.next != null) {
            if(prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return fakeHead.next;
    }

    public Node removeElementsRecursion(Node head, int val) {
        if(head == null) return null;
        head.next = removeElementsRecursion(head.next, val);
        return (head.val == val) ? head.next : head;
    }
}
