import java.util.Stack;

/**
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it.
 * If you find more than one maximum elements, only remove the top-most one.
 * Example 1:
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * Note:
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 */
public class MaxStack {
    Stack<Integer> st;
    Stack<Integer> maxSt;
    /** initialize your data structure here. */
    public MaxStack() {
        st = new Stack<>();
        maxSt = new Stack<>();
    }

    public void push(int x) {
        int curMax = maxSt.isEmpty() ? x : Math.max(x, maxSt.peek());
        maxSt.push(curMax);
        st.push(x);
    }

    public int pop() {
        maxSt.pop();
        return st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int peekMax() {
        return maxSt.peek();
    }

    public int popMax() {
        int curMax = maxSt.peek();
        Stack<Integer> buffer = new Stack<>();
        while (top() != curMax) {
            buffer.push(pop());
        }
        pop();
        while(!buffer.isEmpty()) push(buffer.pop());
        return curMax;
    }
}
/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
