import edu.princeton.cs.algs4.Stack;

import java.util.PriorityQueue;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

 */
public class MinStack {
    Stack<Long> st;
    long min;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
    }

    public void push(int x) {
        if (st.isEmpty()) {
            st.push(0l);
            min = x;
        } else {
            st.push(x - min);
            if (x < min) min = x;
        }
    }

    public void pop() {
        if (st.isEmpty()) return;
        long item = st.pop();
        if (item < 0) {
            min = min - item;
        }
    }

    public int top() {
        if (st.peek() < 0) return (int)min;
        else return (int)(st.peek() + min);
    }

    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
