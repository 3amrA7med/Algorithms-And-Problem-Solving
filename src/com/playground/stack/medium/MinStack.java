package com.playground.stack.medium;

import java.util.*;

/**
 * 155. Min Stack
 * ====================
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 * ===================================
 * Example 1:
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 */
class MinStack {

    /**
     * Runtime 5ms Beats 66.07%
     * Memory 47.42MB Beats 11.18%
     */
    static class StackNode {
        public int val;
        public int minVal;

        StackNode(int v, int mv) {
            val = v;
            minVal = mv;
        }
    }

    Deque<StackNode> stack;
    Integer currMin;

    public MinStack() {
        stack = new ArrayDeque<>();
        currMin = null;
    }

    public void push(int val) {
        if(currMin == null || currMin > val) currMin = val;
        stack.push(new StackNode(val, currMin));
    }

    public void pop() {
        stack.pop();
        if(stack.size() != 0) currMin = stack.peek().minVal;
        else currMin = null;
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return currMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
