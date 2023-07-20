package com.playground.linked_list.data_structure;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LinkedList {
        private static final Logger LOGGER = Logger.getLogger(LinkedList.class.getName());
        public void run (){
                LinkedList obj = new LinkedList();
                obj.addAtHead(7);
                obj.addAtHead(2);
                obj.addAtHead(1);
                obj.addAtIndex(3,0);
                obj.deleteAtIndex(2);
                obj.addAtHead(6);
                obj.addAtTail(4);
                LOGGER.log(Level.INFO, String.valueOf(obj.get(4)));
                obj.addAtTail(4);
                obj.addAtIndex(5,0);
                obj.addAtHead(6);
        }

        public int length;
        public Node head;

        public LinkedList() {
                this.length = 0;
                this.head = null;
        }

        public int get(int index) {
                if(index < 0 || index >= this.length)
                        return -1;
                int counter = 0;
                Node curr = this.head;
                while(counter < index) {
                        curr = curr.next;
                        counter++;
                }
                return curr.val;
        }

        public Node getNode(int index) {
                if(index < 0 || index >= this.length)
                        return null;
                int counter = 0;
                Node curr = this.head;
                while(counter < index) {
                        curr = curr.next;
                        counter++;
                }
                return curr;
        }

        public void addAtHead(int val) {
                Node newHead = new Node(val);
                newHead.next = this.head;
                this.head = newHead;
                this.length++;
        }

        public void addAtTail(int val) {
                if(this.length == 0){
                        addAtHead(val);
                        return;
                }
                Node newNode = new Node(val);
                Node curr = this.head;
                while(Objects.nonNull(curr.next)) {
                        curr = curr.next;
                }
                curr.next = newNode;
                this.length++;
        }

        public void addAtIndex(int index, int val) {
                if(index > length) return;
                if(index == 0){
                        addAtHead(val);
                        return;
                }
                if(index == this.length) {
                        addAtTail(val);
                        return;
                }
                Node newNode = new Node(val);

                int counter = 0;
                Node prev = null;
                Node curr = this.head;
                while(counter < index) {
                        prev = curr;
                        curr = curr.next;
                        counter++;
                }
                newNode.next = prev.next;
                prev.next = newNode;
                this.length++;
        }

        public void deleteAtIndex(int index) {
                if(index < 0 || index >= this.length) {
                        return;
                }

                if(index == 0) {
                        this.length--;
                        this.head = this.head.next;
                        return;
                }

                Node prev = null;
                Node curr = this.head;
                int counter = 0;
                while(counter < index) {
                        prev = curr;
                        curr = curr.next;
                        counter++;
                }

                prev.next = curr.next;
                this.length--;
        }

}
