package com.playground.linked_list.two_pointer_technique;

import com.playground.linked_list.data_structure.LinkedList;
import com.playground.linked_list.data_structure.Node;

/**
 * 160. Intersection of Two Linked Lists
 * =========================
 * Given the heads of two singly linked-lists headA and headB, return the node
 * at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * For example, the following two linked lists begin to intersect at node c1:
 *      a1 - a2
 *               \
 *                c1 - c2 - c3
 * b1 - b2 - b3  /
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * Note that the linked lists must retain their original structure after the function returns.
 * Custom Judge:
 * The inputs to the judge are given as follows (your program is not given these inputs):
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
 */
public class IntersectionOfTwoLinkedLists {

    public void run() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAtHead(4);
        linkedList.addAtIndex(1, 1);
        linkedList.addAtIndex(2, 8);
        linkedList.addAtIndex(3, 4);
        linkedList.addAtTail(5);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAtHead(5);
        linkedList2.addAtIndex(1, 6);
        linkedList2.addAtIndex(2, 1);

        Node nodeToLinkWithIntersectionNode = linkedList2.getNode(2);
        nodeToLinkWithIntersectionNode.next = linkedList.getNode(2);

        System.out.println(getIntersectionNode(linkedList.head, linkedList2.head));
    }

    public Node getIntersectionNode(Node headA, Node headB) {
        Node pointerOne = headA;
        Node pointerTwo = headB;
        // Max 3 times, as we want to find intersection if we didn't we will continue until
        // each pointer started with the head of the other list.
        for(int i = 0; i < 3; i++) {
            while (pointerOne != null && pointerTwo != null){
                if(pointerOne == pointerTwo)
                    return pointerOne;
                pointerOne = pointerOne.next;
                pointerTwo = pointerTwo.next;
            }
            if(pointerOne == null && pointerTwo != null) {
                pointerOne = headB;
                pointerTwo = pointerTwo.next;
            }
            else if(pointerOne != null) {
                pointerTwo = headA;
                pointerOne = pointerOne.next;
            }
            else
                return null;
        }
        return null;
    }

    /**
     * Memory optimization only.
     * @param headA
     * @param headB
     * @return
     */
    public Node getIntersectionNodeOptimization(Node headA, Node headB) {
        Node pointerOne = headA;
        Node pointerTwo = headB;

        while (pointerOne != pointerTwo) {
            pointerOne = (pointerOne != null)?  pointerOne.next : headB;
            pointerTwo = (pointerTwo != null)?  pointerTwo.next : headA;
        }
        return pointerOne;
    }
}
