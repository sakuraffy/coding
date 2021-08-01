package top.sakuraffy.offer;

import java.util.*;

/**
 * @author: zhangqiushi
 * @create: 2021/07/23 20:38
 */
public class ArraySolution {
    /**
     * 最大收益（当前值减去它之前出现的值）
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int max = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            maxProfit = Math.max(maxProfit, max - prices[i]);
        }

        return maxProfit;
    }

    /**
     * 最小k个数（PriorityQueue默认为小顶堆）
     * @param nums
     * @param k
     * @return
     */
    public int[] smallestK(int[] nums, int k) {
        PriorityQueue queue = new PriorityQueue<Integer>(k + 1, (o1, o2) -> o2.compareTo(o1));
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = (int)queue.poll();
        }
        return result;
    }

    /**
     * 蛇形矩阵打印
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int num = matrix.length * matrix[0].length;
        int[] result = new int[num];
        int count = 0;
        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        int i = 0;
        int j = 0;
        while (count < num) {
            // right
            for (; j < matrix[0].length && !used[i][j]; j++) {
                used[i][j] = true;
                result[count++] = matrix[i][j];
            }
            j--;
            i++;

            // down
            for (; i < matrix.length && !used[i][j]; i++) {
                used[i][j] = true;
                result[count++] = matrix[i][j];
            }
            i--;
            j--;

            // left
            for (; j >= 0 && !used[i][j]; j--) {
                used[i][j] = true;
                result[count++] = matrix[i][j];
            }
            j++;
            i--;

            // up
            for (; i >= 0 && !used[i][j]; i--) {
                used[i][j] = true;
                result[count++] = matrix[i][j];
            }
            i++;
            j++;
        }

        return result;
    }

    /**
     * 找出数组中的重复数字
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return 0;
    }

    /**
     * 找出旋转数组中最小数字
     * @param numbers
     * @return
     */
    public int minNumberInRotateArray(int[] numbers) {
        return 0;
    }

    /**
     * 二维数组中查找数字是否出现
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        return false;
    }

    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public int fib(int n) {
        return 0;
    }

    /**
     * 机器人的运动范围
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        return 0;
    }

    /**
     * 青蛙跳上一个 n 级的台阶总共有多少种跳法
     * @param n
     * @return
     */
    public int numWays(int n) {
        return 0;
    }

    /**
     * 滑动窗口的最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        return null;
    }

    /**
     * 圆圈中最后剩下的数字
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        return 0;
    }

    /**
     * 连续子数组的最大和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        return 0;
    }

    /**
     * 把数字翻译成字符串
     * @param num
     * @return
     */
    public int translateNum(int num) {
        return 0;
    }

    /**
     * 和为s的连续正数序列
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        return null;
    }

    /**
     *  构建乘积数组
     * @param arr
     * @return
     */
    public int[] constructArr(int[] arr) {
        return null;
    }

    /**
     * n个骰子的点数
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        return null;
    }

    /**
     * 调整数组顺序使奇数位于偶数前面
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        return null;
    }

    /**
     * 在排序数组中查找数字
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return 0;
    }

    /**
     * 剪绳子使得乘积最大
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        return 0;
    }

    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        return null;
    }

    /**
     *  扑克牌中的顺子
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        return false;
    }

    /**
     * 0～n-1中缺失的数字
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        return 0;
    }

    /**
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        return 0;
    }

    /**
     * 矩阵中的是否存在字符串路径
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        return false;
    }

    /**
     * 数组中出现次数超过一半的数字
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        return 0;
    }

    /**
     * 礼物的最大价值(往右或下移动)
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        return 0;
    }
}
