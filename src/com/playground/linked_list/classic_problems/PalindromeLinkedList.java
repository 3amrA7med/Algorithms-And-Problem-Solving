package com.exercise.linked_list.classic_problems;

import com.exercise.linked_list.data_structure.LinkedList;
import com.exercise.linked_list.data_structure.Node;

import java.util.Stack;

public class PalindromeLinkedList {

    public void run() {
        // 1 2 3 4 5
        // [2,1,3,5,6,4,7]
        LinkedList linkedList = new LinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(2);
        linkedList.addAtTail(1);
        System.out.println(isPalindrome2(linkedList.head));
    }

    /**
     * Better solution, Faster also lower memory consumption.
     * @param head
     * @return
     */
    public boolean isPalindrome(Node head) {
        if(head.next == null) return true;
        int count = 0;
        int index = 0;

        Node curr = head;
        Stack<Integer> stack = new Stack<>();
        // Find out the total number of the nodes.
        while(curr != null) {
            count ++;
            curr = curr.next;
        }
        curr = head;
        // Push the first half in the stack(to invert it while comparing it with the second half)
        while(index < (count/2)) {
            stack.push(curr.val);
            curr = curr.next;
            index ++;
        }
        if(count%2!=0) curr = curr.next; // If number of nodes is odd then skip the middle node.

        while(!stack.empty()) {
            if(stack.pop() != curr.val) return false;
            curr = curr.next;
        }
        return true;
    }

    Node firstIterator;
    public boolean isPalindrome2(Node head) {
        firstIterator = head;
        return isPalindromeRecursion(head);
    }

    public boolean isPalindromeRecursion(Node curr) {
        if(curr == null) return true;
        boolean accumulatedAnswerFlag = isPalindromeRecursion(curr.next);
        boolean isEqualFlag = curr.val == firstIterator.val;
        firstIterator = firstIterator.next;
        return accumulatedAnswerFlag && isEqualFlag;
    }
}
