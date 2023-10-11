package com.playground.linked_list.conclusion;

import com.playground.linked_list.data_structure.LinkedList;
import com.playground.linked_list.data_structure.Node;

/**
 * 2. Add Two Numbers
 * =====================
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * ============================
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public void run() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAtHead(2);
        linkedList.addAtTail(4);
        linkedList.addAtTail(3);
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAtHead(5);
        linkedList2.addAtTail(6);
        linkedList2.addAtTail(4);
        System.out.println(addTwoNumbers(linkedList.head, linkedList2.head));
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        Node newHead = new Node(0);
        Node resultList = newHead;
        Node l1Iterator = l1;
        Node l2Iterator = l2;
        int reminder = 0;
        int result;
        while(l1Iterator != null && l2Iterator != null) {
            result = l1Iterator.val + l2Iterator.val + reminder;
            reminder = 0;
            while(result >= 10) {
                reminder+=1;
                result-=10;
            }
            resultList.next = new Node(result);
            l1Iterator = l1Iterator.next;
            l2Iterator = l2Iterator.next;
            resultList = resultList.next;
        }

        // If l1 still has numbers.
        while(l1Iterator != null) {
            result = l1Iterator.val + reminder;
            reminder = 0;
            while(result >= 10) {
                reminder+=1;
                result-=10;
            }
            resultList.next = new Node(result);
            l1Iterator = l1Iterator.next;
            resultList = resultList.next;
        }

        // If l1 still has numbers.
        while(l2Iterator != null) {
            result = l2Iterator.val + reminder;
            reminder = 0;
            while(result >= 10) {
                reminder+=1;
                result-=10;
            }
            resultList.next = new Node(result);
            l2Iterator = l2Iterator.next;
            resultList = resultList.next;
        }

        // If there is reminder remaining left.
        if(reminder > 0) resultList.next = new Node(reminder);
        return newHead.next;
    }

    /**
     * LEttCode answer (I think we should leave 2 lists as it is)
     * @param l1
     * @param l2
     * @return
     */
    public Node addTwoNumbers2(Node l1, Node l2) {
        Node dummyHead = new Node(0);
        Node curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }
}
