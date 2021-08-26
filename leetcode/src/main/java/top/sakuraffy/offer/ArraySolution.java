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
        if (Objects.isNull(matrix) || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    /**
     * 机器人的运动范围
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) {
            return 0;
        }
        boolean[][] visit = new boolean[m][n];
        visit[0][0] = true;
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int i = 0; i < 2; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || visit[tx][ty] || sum(tx) + sum(ty) > k) {
                    continue;
                }
                visit[tx][ty] = true;
                queue.offer(new int[]{tx, ty});
                count++;
            }
        }

        return count;
    }

    /**
     * 计算各位之和
     * @param num
     * @return
     */
    private int sum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    /**
     * 青蛙跳上一个 n 级的台阶总共有多少种跳法
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    /**
     * 滑动窗口的最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (Objects.isNull(nums) || nums.length <= 0 || k <= 1 || k > nums.length) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (queue.peek() < i - k + 1) {
                queue.poll();
            }
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[queue.peek()];
            }
        }
        return result;
    }

    /**
     * 圆圈中最后剩下的数字
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        if (n <= 0 || m <= 0) {
            return 0;
        }
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result;
    }

    /**
     * 连续子数组的最大和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int result = nums[0], sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            result = Math.max(sum, result);
        }
        return result;
    }

    /**
     * 和为s的连续正数序列
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        if (target <= 0) {
            return new int[][]{};
        }
        int low = 1, high = 1, sum = 0;
        List<int[]> result = new ArrayList<>();
        while (high <= target) {
            if (sum < target) {
                sum += high;
                high++;
            } else {
                if (sum == target) {
                    int[] arr = new int[high - low];
                    for (int i = low; i < high; i++) {
                        arr[i - low] = i;
                    }
                    result.add(arr);
                }
                sum -= low;
                low++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    /**
     *  构建乘积数组
     * @param arr
     * @return
     */
    public int[] constructArr(int[] arr) {
        if (Objects.isNull(arr) || arr.length < 2) {
            return arr;
        }
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0] = right[arr.length - 1] = 1;
        for (int i = 1; i < arr.length; i++) {
            left[i] = left[i - 1] * arr[i - 1];
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * arr[i + 1];
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int leftValue = i - 1 >= 0 ? left[i] : 1;
            int rightValue = i + 1 < arr.length ? right[i] : 1;
            result[i] = leftValue * rightValue;
        }
        return result;
    }

    /**
     * n个骰子的点数
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        if (n <= 0) {
            return new double[]{};
        }
        double[] result = new double[6];
        Arrays.fill(result, 1.0 / 6);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < result.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[k + j] += result[j] / 6;
                }
            }
            result = temp;
        }
        return result;
    }

    /**
     * 调整数组顺序使奇数位于偶数前面
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return nums;
        }
        for (int i = 0, j = nums.length - 1; i < j;) {
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * 在排序数组中查找数字出现的次数
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
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
            return 0;
        }
        int leftIndex = left;

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

        return left - leftIndex + 1;
    }

    /**
     * 剪绳子使得乘积最大
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3, p = 1000000007;
        long remain = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) {
                remain = (remain * x) % p;
            }
            x = (x * x) % p;
        }
        if(b == 0) {
            return (int)(remain * 3 % p);
        }
        if(b == 1) {
            return (int)(remain * 4 % p);
        }
        return (int)(remain * 6 % p);
    }

    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return new int[]{};
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[]{target - num, num};
            }
            set.add(num);
        }
        return new int[]{};
    }

    /**
     *  扑克牌中的顺子
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 5) {
            return false;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                continue;
            }
            if (i == 0 || nums[i - 1] == 0) {
                continue;
            }
            if (nums[i] == nums[i - 1]) {
                return false;
            }
            count -= nums[i] - nums[i - 1] - 1;
        }
        return count >= 0;
    }

    /**
     * 0～n-1中缺失的数字
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low] == low ? low + 1 : low;
    }

    /**
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int p1 = 0, p2 = 0, p3 = 0;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int n2 = 2 * dp[p1], n3 = 3 * dp[p2], n5 = 5 * dp[p3];
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if (dp[i] == n2) {
                p1++;
            }
            if (dp[i] == n3) {
                p2++;
            }
            if (dp[i] == n5) {
                p3++;
            }
        }
        return dp[n - 1];
    }

    /**
     * 矩阵中的是否存在字符串路径
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (Objects.isNull(board) || Objects.isNull(word) || word.length() == 0
                || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, used)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 矩阵中的是否存在字符串路径
     * @param board
     * @param i
     * @param j
     * @param word
     * @param used
     * @return
     */
    private boolean exist(char[][] board, int i, int j, String word, boolean[][] used) {
        if (word.length() == 0) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j] || board[i][j] != word.charAt(0)) {
            return false;
        }

        used[i][j] = true;
        boolean result = false;
        result = result || exist(board, i - 1, j, word.substring(1), used);
        result = result || exist(board, i + 1, j, word.substring(1), used);
        result = result || exist(board, i, j - 1, word.substring(1), used);
        result = result || exist(board, i, j + 1, word.substring(1), used);
        used[i][j] = false;
        return result;
    }

    /**
     * 数组中出现次数超过一半的数字
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count = 1;
                continue;
            }
            if (result == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }

    /**
     * 礼物的最大价值(往右或下移动)
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        if (Objects.isNull(grid) || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j];
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    dp[i][j] += dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 旋转数组的最小值
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (Objects.isNull(numbers) || numbers.length == 0) {
            return 0;
        }
        int low = 0, high = numbers.length - 1;
        if (numbers[low] < numbers[high]) {
            return numbers[low];
        }
        while (low < high) {
            int mid = (low + high) / 2;
            if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else if (numbers[mid] < numbers[high]) {
                high = mid;
            } else {
                low += 1;
            }
        }
        return numbers[low];
    }

    /**
     * 数组中的逆序对
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }


    /**
     * 归并排序
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        return mergeSort(nums, low, mid) + mergeSort(nums, mid + 1, high) + merge(nums, low, mid, high);
    }

    /**
     * 有序数组的合并
     * @param nums
     * @param low
     * @param mid
     * @param high
     * @return
     */
    private int merge(int[] nums, int low, int mid, int high) {
        int[] arr = new int[high - low + 1];
        int i = low, j = mid + 1, idx = 0, count = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                arr[idx++] = nums[i++];
            } else {
                count += (mid - i + 1);
                arr[idx++] = nums[j++];
            }
        }
        while (i <= mid) {
            arr[idx++] = nums[i++];
        }
        while (j <= high) {
            arr[idx++] = nums[j++];
        }
        for (i = 0; i < arr.length; i++) {
            nums[low + i] = arr[i];
        }
        return count;
    }

    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[]{};
        }
        int num = (int) Math.pow(10, n);
        int[] res = new int[num - 1];
        for (int i = 1; i < num; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
