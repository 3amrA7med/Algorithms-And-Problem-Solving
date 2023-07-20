package com.playground.linked_list.two_pointer_technique;

import com.playground.linked_list.data_structure.LinkedList;
import com.playground.linked_list.data_structure.Node;

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
