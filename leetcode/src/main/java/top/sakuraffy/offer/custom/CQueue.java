package top.sakuraffy.offer.custom;

import java.util.Stack;

/**
 * @author: zhangqiushi
 * @create: 2021/07/29 12:54
 */
public class CQueue {
    Stack<Integer> stack;
    Stack<Integer> temp;

    public CQueue() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        if (temp.isEmpty()) {
            return -1;
        }

        int value = temp.pop();
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return value;
    }
}
