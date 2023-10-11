package com.playground.linked_list.classic_problems;

import com.playground.linked_list.data_structure.LinkedList;
import com.playground.linked_list.data_structure.Node;

import java.util.Stack;

/**
 * 234. Palindrome Linked List
 * ===============================
 * Given the head of a singly linked list, return true if it is a
 * palindrome or false otherwise.
 * ==================================
 * Input: head = [1,2,2,1]
 * Output: true
 * ==================================
 * optimal will be using floyd algorithm (slow & fast pointers)
 */
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
     * Runtime 3ms Beats 99.99%
     * Memory 56.16MB Beats 81.55%
     */
    public boolean isPalindrome4(Node head) {
        if(head == null || head.next == null)
            return true;

        Node prevSlow = null;
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next !=null)
        {
            fast = fast.next.next;

            Node nextSlow = slow.next;
            slow.next = prevSlow;
            prevSlow = slow;
            slow = nextSlow;
        }

        if(fast!=null)
        {
            slow = slow.next;
        }

        while(prevSlow!=null && slow!=null)
        {
            if(prevSlow.val != slow.val){
                return false;
            }
            prevSlow = prevSlow.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * Better solution, Faster also lower memory consumption.
     * Runtime 20 ms Beats 6.44%
     * Memory 57.4 MB Beats 42.68%
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

    /**
     * Runtime 33 ms Beats 5.5%
     * Memory 104.3 MB Beats 5.25%
     */
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


    /**
     * Runtime 10 ms Beats 19.11%
     * Memory 63.5 MB Beats 5.25%
     */
    boolean res = true;
    public boolean isPalindrome3(Node head) {
        isPalindromeRec2(head, head);
        return res;
    }

    public Node isPalindromeRec2(Node curr, Node head) {
        if(curr == null) return head;

        Node palindromeNode = isPalindromeRec2(curr.next, head);
        if(palindromeNode.val != curr.val) res = false;
        return palindromeNode.next;
    }
}
