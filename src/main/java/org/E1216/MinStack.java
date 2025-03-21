package org.E1216;

import java.util.Stack;

public class MinStack {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<int[]> minStack = new Stack<>();

    public MinStack() {}

    public void push(int x) {
        // We always put the number onto the main stack.
        stack.push(x);
        // If the min stack is empty, or this number is smaller than
        // the top of the min stack, put it on with a count of 1.
        if (minStack.isEmpty() || x < minStack.peek()[0]) {
            minStack.push(new int[] { x, 1 });
        }
        // Else if this number is equal to what's currently at the top
        // of the min stack, then increment the count at the top by 1.
        else if (x == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
    }

    public Integer pop() {
        // If the top of min stack is the same as the top of stack
        // then we need to decrement the count at the top by 1.
        if (stack.peek().equals(minStack.peek()[0])) {
            minStack.peek()[1]--;
        }
        // If the count at the top of min stack is now 0, then remove that value as we're done with it.
        if (minStack.peek()[1] == 0) {
            minStack.pop();
        }
        // And like before, pop the top of the main stack.
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek()[0];
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        /*obj.push(-2);obj.push(0);obj.push(-3);
        System.out.println(obj.getMin());
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj = new MinStack();
        obj.push(2);obj.push(0);obj.push(3);
        System.out.println(obj.getMin());
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.getMin());*/
        //Ex : 3
        obj = new MinStack();
        obj.push(12);obj.push(30);obj.push(40);obj.push(7);obj.push(6);obj.push(13);obj.push(7);
        System.out.println(obj.pop());System.out.println(obj.pop());System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.push(2);obj.push(12);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
