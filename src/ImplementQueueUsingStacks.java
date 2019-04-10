import java.util.Stack;

/*
232. Implement Queue using Stacks
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false

 */
public class ImplementQueueUsingStacks {
    private Stack<Integer> stack;
    private Stack<Integer> cache;
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        stack = new Stack<>();
        cache = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack.isEmpty()) stack.push(x);
        else {
            while (!stack.isEmpty()) {
                cache.push(stack.pop());
            }
            stack.push(x);
            while (!cache.isEmpty()) {
                stack.push(cache.pop());
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

