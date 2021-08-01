package top.sakuraffy.company.mayi;

import java.util.*;

/**
 * @author: zhangqiushi
 * @create: 2021/07/22 18:55
 */
public class ArraySolution {
    /**
     * 蛇形矩阵打印
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        int i = 0;
        int j = 0;
        while (result.size() < matrix.length * matrix[0].length) {
            // right
            for (; j < matrix[0].length && !used[i][j]; j++) {
                used[i][j] = true;
                result.add(matrix[i][j]);
            }
            j--;
            i++;

            // down
            for (; i < matrix.length && !used[i][j]; i++) {
                used[i][j] = true;
                result.add(matrix[i][j]);
            }
            i--;
            j--;

            // left
            for (; j >= 0 && !used[i][j]; j--) {
                used[i][j] = true;
                result.add(matrix[i][j]);
            }
            j++;
            i--;

            // up
            for (; i >= 0 && !used[i][j]; i--) {
                used[i][j] = true;
                result.add(matrix[i][j]);
            }
            i++;
            j++;
        }

        return result;
    }

    /**
     * 全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        doPermute(nums, new Stack<>(), result, new boolean[nums.length]);
        return result;
    }

    /**
     * 全排列
     * @param nums
     * @param stack
     * @param result
     * @param used
     */
    private void doPermute(int[] nums, Stack<Integer> stack, List<List<Integer>> result, boolean[] used) {
        if (stack.size() == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                stack.push(nums[i]);
                used[i] = true;
                doPermute(nums, stack, result, used);
                used[i] = false;
                stack.pop();
            }
        }
    }

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] != target) {
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        result[0] = left;

        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        result[1] = left;

        return result;
    }

    /**
     * 数组中的第K个最大元素
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue queue = new PriorityQueue<Integer>(k + 1);
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return (int)queue.poll();
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
     * 最大k个数
     * @param nums
     * @param k
     * @return
     */
    public int[] biggestK(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, nums.length - k);
        return Arrays.copyOfRange(nums, nums.length - k, nums.length);
    }

    /**
     * 快速排序
     * @param nums
     * @param low
     * @param high
     * @param k
     */
    private void quickSort(int[] nums, int low, int high, int k) {
        if (low < high) {
            int pos = partition(nums, low, high);
            if (pos == k) {
                return;
            } else if (pos < k) {
                quickSort(nums, pos + 1, high, k);
            } else {
                quickSort(nums, low, pos - 1, k);
            }
        }
    }

    /**
     * 寻找中枢位置
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }

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
     * 盛最多水的容器
     * @param heights
     * @return
     */
    public int maxArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int left = 0;
        int right = heights.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(heights[right], heights[left]));
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    /**
     * 接雨水
     * @param heights
     * @return
     */
    public int trap(int[] heights) {
        return 0;
    }

    /**
     * 找到数组中消失的数字
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        return null;
    }
}
