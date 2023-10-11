package com.playground.linked_list.conclusion;

import com.playground.linked_list.data_structure.MultiLevelNode;

/**
 * 430. Flatten a Multilevel Doubly Linked List
 * ===================================
 * You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer,
 * and an additional child pointer. This child pointer may or may not point to a separate doubly linked list,
 * also containing these special nodes. These child lists may have one or more children of their own,
 * and so on, to produce a multilevel data structure as shown in the example below.
 * Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level,
 * doubly linked list. Let curr be a node with a child list.
 * The nodes in the child list should appear after curr and before curr.next in the flattened list.
 * Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
 * ========================
 * 1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * Explanation: The multilevel linked list in the input is shown.
 */
public class FlattenAMultilevelDoublyLinkedList {

    public void run() {
        MultiLevelNode one = new MultiLevelNode(1);
        MultiLevelNode two = new MultiLevelNode(2);
        MultiLevelNode three = new MultiLevelNode(3);
        MultiLevelNode four = new MultiLevelNode(4);
        MultiLevelNode five = new MultiLevelNode(5);
        MultiLevelNode six = new MultiLevelNode(6);
        MultiLevelNode seven = new MultiLevelNode(7);
        MultiLevelNode eight = new MultiLevelNode(8);
        MultiLevelNode nine = new MultiLevelNode(9);
        MultiLevelNode ten = new MultiLevelNode(10);
        MultiLevelNode eleven = new MultiLevelNode(11);
        MultiLevelNode twelve = new MultiLevelNode(12);

        one.next = two;
        two.prev = one;

        two.next = three;
        three.prev = two;
        three.next = four;
        three.child = seven;

        four.prev = three;
        four.next = five;
        five.prev = four;
        five.next = six;
        six.prev = five;

        seven.next = eight;
        eight.prev = seven;
        eight.next = nine;
        eight.child = eleven;

        nine.prev = eight;
        nine.next = ten;
        ten.prev = nine;

        eleven.next = twelve;
        twelve.prev = eleven;

        flatten(one);
    }

    /**
     * Accepted solution but with 5% faster than other answers and 0% better than anyone in memory.
     * @param head
     * @return
     */
    public MultiLevelNode flatten(MultiLevelNode head) {
        recursionFlatten(head);
        return head;
    }

    /**
     *  1---2---3---4---5---6--NULL
     *          |
     *          7---8---9---10--NULL
     *              |
     *              11--12--NULL
     *
     * [1,2,3,7,4,5,6]
     * [1,2,3,7,8,11,12,9,10,4,5,6]
     * @param head
     * @return
     */
    public MultiLevelNode recursionFlatten(MultiLevelNode head) {
        MultiLevelNode curr = head;
        MultiLevelNode prev = head;
        while(curr != null) {
            prev = curr;
            if(curr.child != null) {
                MultiLevelNode lastNodeInChildList = recursionFlatten(curr.child);
                // Link last node in child with current next node.
                lastNodeInChildList.next = curr.next;
                if(curr.next != null)
                    curr.next.prev = lastNodeInChildList;
                // Link current node with the child.
                curr.child.prev = curr;
                curr.next = curr.child;
                // Remove child.
                curr.child = null;
            }
            curr = curr.next;
        }
        return prev;
    }

    /**
     * 100% Faster than other solutions
     * 50% Better in memory
     */
    public MultiLevelNode flatten2(MultiLevelNode head) {
        MultiLevelNode curr = head; // pointer to the start of the list in the first level
        MultiLevelNode nextLevelIterator;
        MultiLevelNode lastNodeInTheNextLevel;
        // Loop and flatten level by level.
        while(curr != null) {
            // If there is a child. flatten the next level into the current one
            if (curr.child != null) {
                nextLevelIterator = curr.child;
                lastNodeInTheNextLevel = curr.child;
                // Loop to get the last node in the next level.
                while (nextLevelIterator != null) {
                    lastNodeInTheNextLevel = nextLevelIterator;
                    nextLevelIterator = nextLevelIterator.next;
                }
                // If last node found place the next level list in its correct position.
                // Link last node in child with current next node.
                lastNodeInTheNextLevel.next = curr.next;
                if(curr.next != null)
                    curr.next.prev = lastNodeInTheNextLevel;
                // Link current node with the child.
                curr.child.prev = curr;
                curr.next = curr.child;
                // Remove child.
                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }

    /**
     * 100% Faster than other solutions
     * 80% Better in memory
     */
    public MultiLevelNode flatten3(MultiLevelNode head) {
        MultiLevelNode curr = head; // pointer to the start of the list in the first level
        MultiLevelNode lastNodeInTheNextLevel;
        // Loop and flatten level by level.
        while(curr != null) {
            // If there is a child. flatten the next level into the current one
            if (curr.child != null) {
                lastNodeInTheNextLevel = curr.child;
                // Loop to get the last node in the next level.
                while (lastNodeInTheNextLevel.next != null) {
                    lastNodeInTheNextLevel = lastNodeInTheNextLevel.next;
                }
                // If last node found place the next level list in its correct position.
                // Link last node in child with current next node.
                lastNodeInTheNextLevel.next = curr.next;
                if(curr.next != null)
                    curr.next.prev = lastNodeInTheNextLevel;
                // Link current node with the child.
                curr.child.prev = curr;
                curr.next = curr.child;
                // Remove child.
                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }
}