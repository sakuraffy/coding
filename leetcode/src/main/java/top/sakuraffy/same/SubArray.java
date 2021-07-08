package top.sakuraffy.same;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: coding
 * @description: 子数组
 * @author: zhangqiushi
 * @create: 2021/06/02 10:14
 */
public class SubArray {
    /**
     * Desc:Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
     *      Since the answer may be large, return the answer modulo 109 + 7.
     * 找出覆盖所有连续子数组的最小和
     * @param nums
     * @return
     */
    public int sumSubarrayMins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        final int mod = 1_000_000_007;
        // dp[i] 代表
        int[] dp = new int[nums.length + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // 递增栈
            while (stack.peek() != -1 && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            dp[i + 1] = (dp[stack.peek() + 1] + (i - stack.peek()) * nums[i]) % mod;
            stack.push(i);
            res = (res + dp[i + 1]) % mod;
        }

        return res;
    }

    /**
     * 子数组和为K的个数
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

}
