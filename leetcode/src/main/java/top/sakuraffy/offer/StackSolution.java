package top.sakuraffy.offer;

import java.util.Objects;
import java.util.Stack;

/**
 * @author: zhangqiushi
 * @create: 2021/07/26 10:38
 */
public class StackSolution {
    /**
     * 栈的压入、弹出序列是否合法
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (Objects.isNull(pushed) || Objects.isNull(popped) || pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int idx = 0;

        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[idx]) {
                stack.pop();
                idx++;
            }
        }

        return stack.isEmpty();
    }
}
