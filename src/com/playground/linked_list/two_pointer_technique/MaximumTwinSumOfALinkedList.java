package com.playground.linked_list.two_pointer_technique;

import com.playground.linked_list.data_structure.Node;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2130. Maximum Twin Sum of a Linked List
 * LeetCode 75
 * =================================
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of
 * the (n-1-i)th node, if 0 <= i <= (n / 2) - 1. For example, if n = 4, then node 0 is the twin of node 3,
 * and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 * =======================================
 * Example 1:
 * Input: head = [5,4,2,1]
 * Output: 6
 * Explanation:
 * Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
 * There are no other nodes with twins in the linked list.
 * Thus, the maximum twin sum of the linked list is 6.
 * Example 2:
 * Input: head = [4,2,2,3]
 * Output: 7
 * Explanation:
 * The nodes with twins present in this linked list are:
 * - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
 * - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
 * Thus, the maximum twin sum of the linked list is max(7, 4) = 7.
 * Example 3:
 * Input: head = [1,100000]
 * Output: 100001
 * Explanation:
 * There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
 * =======================================
 * Constraints:
 * The number of nodes in the list is an even integer in the range [2, 105].
 * 1 <= Node.val <= 105
 */
public class MaximumTwinSumOfALinkedList {

    /**
     * Runtime 4 ms Beats 95.32%
     * Memory 66.1 MB Beats 28.34%
     */
    public int pairSum1(Node head) {
        Node prev = null;
        Node next;
        Node firstIterator = head;
        Node secondIterator = head.next;

        // Reverse first part of the linked list.
        while(secondIterator != null && secondIterator.next != null) {
            next = firstIterator.next;
            firstIterator.next = prev;
            prev = firstIterator;
            firstIterator = next;
            secondIterator = secondIterator.next.next;
        }

        secondIterator = firstIterator.next;
        firstIterator.next = prev;

        int maxSum = 0;
        while(firstIterator != null && secondIterator != null) {
            int currSum = firstIterator.val + secondIterator.val;
            maxSum = Math.max(maxSum, currSum);
            firstIterator = firstIterator.next;
            secondIterator = secondIterator.next;
        }

        return maxSum;
    }

    /**
     * Runtime 11 ms Beats 26.97%
     * Memory 62.2 MB Beats 71.85%
     */
    public int pairSum2(Node head) {
        Node slow = head;
        Node fast = head.next;
        Deque<Integer> stack = new ArrayDeque<>();

        while(fast != null && fast.next != null) {
            stack.addLast(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        stack.addLast(slow.val);

        int maxSum = 0;
        slow = slow.next;
        while(slow != null) {
            int currSum = slow.val + stack.removeLast();
            maxSum = Math.max(maxSum, currSum);
            slow = slow.next;
        }

        return maxSum;
    }
}
