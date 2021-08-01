package top.sakuraffy.offer.custom;

import java.util.Objects;
import java.util.Stack;

/**
 * @author: zhangqiushi
 * @create: 2021/07/26 12:50
 */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        if (Objects.equals(stack.pop(),min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
