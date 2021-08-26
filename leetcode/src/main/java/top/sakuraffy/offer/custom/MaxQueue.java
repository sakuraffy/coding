package top.sakuraffy.offer.custom;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * @author: zhangqiushi
 * @create: 2021/07/26 11:37
 */
public class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> maxValue;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxValue = new LinkedList<>();
    }

    public int max_value() {
        if (maxValue.isEmpty()) {
            return -1;
        }
        return maxValue.peekFirst();
    }

    public void push_back(int value) {
        while (!maxValue.isEmpty() && maxValue.peekLast() < value) {
            maxValue.pollLast();
        }
        maxValue.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }

        int val = queue.poll();
        while (!maxValue.isEmpty() && val == maxValue.peekFirst()) {
            maxValue.poll();
        }

        return val;
    }
}
