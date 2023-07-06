package com.exercise.linked_list.data_structure;

public class MultiLevelNode {

        public int val;
        public MultiLevelNode prev;
        public MultiLevelNode next;
        public MultiLevelNode child;

        public MultiLevelNode(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
            this.child = null;
        }

}
