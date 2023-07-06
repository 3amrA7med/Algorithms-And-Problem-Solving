package com.exercise.linked_list.conclusion;

import com.exercise.linked_list.data_structure.LinkedList;
import com.exercise.linked_list.data_structure.Node;

public class MergeTwoSortedLists {

    public void run() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(4);
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAtHead(1);
        linkedList2.addAtTail(3);
        linkedList2.addAtTail(4);
        System.out.println(mergeTwoLists(linkedList.head, linkedList2.head));
    }

    public Node mergeTwoLists(Node list1, Node list2) {
        Node fakeHead = new Node(-200); // Dummy node.
        Node iterator = fakeHead; // Dummy node.

        while(list1!=null && list2!=null) {
            if(list1.val <= list2.val) {
                iterator.next = list1;
                list1 = list1.next;
            }
            else {
                iterator.next = list2;
                list2 = list2.next;
            }
            iterator = iterator.next;
        }

        // If any remaining nodes in list1 add them.
        while(list1 != null) {
            iterator.next = list1;
            list1 = list1.next;
            iterator = iterator.next;
        }

        // If any remaining nodes in list2 add them.
        while(list2 != null) {
            iterator.next = list2;
            list2 = list2.next;
            iterator = iterator.next;
        }

        return fakeHead.next;
    }

    /**
     * not prefered if solution could be found in O(N)
     * Because in real life, the length of a linked list could be much longer than we expected, in which case the recursive approach is likely to introduce a stack overflow. (Imagine a file system)
     * But anyway, as long as we communicate this concerning properly with the interviewer, I don't think it's a big deal here.
     * @param l1
     * @param l2
     * @return
     */
    public Node mergeTwoLists2(Node l1, Node l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
