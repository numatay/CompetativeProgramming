package leetcode.problem232;

import java.util.Stack;

/**
 * Created by Nurgissa on 5/12/2016.
 */
class MyQueue {
    // Push element x to the back of queue.
    private Stack<Integer> st1 = new Stack<>();
    private Stack<Integer> st2 = new Stack<>();
    public void push(int x) {
        st1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!st1.empty()) {
            st2.push(st1.pop());
        }
        st2.pop();
        while(!st2.empty()) {
            st1.push(st2.pop());
        }
    }

    // Get the front element.
    public int peek() {
        while(!st1.empty()) {
            st2.push(st1.pop());
        }
        int ret = st2.peek();

        while(!st2.empty()) {
            st1.push(st2.pop());
        }

        return ret;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return st1.empty();
    }
}