package top.sakuraffy.solution.dp;

import java.util.*;

/**
 * @author: zhangqiushi
 * @create: 2021/09/06 13:24
 */
public class ArraySolution {
    /**
     * 最大子数组和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (Objects.isNull(nums)) {
            return 0;
        }
        int len = nums.length;
        //dp[i]为已i结尾的最大子组数和
        int[] dp = new int[len];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 最大子数组乘积
     * @param nums
     * @return
     */
    public int maxSubArrayProduct(int[] nums) {
        if (Objects.isNull(nums)) {
            return 0;
        }
        int len = nums.length;
        //dpMax[i]为已i结尾的最大子组数积,dpMin[i]为已i结尾的最小子组数积
        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        int max = nums[0];
        dpMax[0] = dpMin[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(dpMin[i - 1] * nums[i], nums[i]));
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }

    /**
     * 杨辉三角
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        result.add(new ArrayList<>(Arrays.asList(1)));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }

    /**
     * 获取杨辉三角某一行
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                result.set(j,result.get(j) + result.get(j-1));
            }
            result.add(1);
        }
        return result;
    }

    /**
     * 跳跃楼梯最小代价（一次可跳一格或两格）
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if (Objects.isNull(cost) || cost.length < 2) {
            return 0;
        }
        int len = cost.length;
        // dp[i] 代表跳到第i格需要的最小代价
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = cost[i];
            if (i - 2 >= 0) {
                dp[i] += Math.min(dp[i - 1], dp[i - 2]);
            }
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }

    /**
     * 返回生成数组nums中的最大值(dp[i] = dp[i/2] i % 2 == 0, dp[i] = dp[i/2] + dp[i/2+1] i % 2 == 1)
     * @param n
     * @return
     */
    public int getMaximumGenerated(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        int max = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + dp[i / 2 + 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度,判断你是否能够到达最后一个下标
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 0) {
            return true;
        }
        int len = nums.length;
        // dp[i]代表是否可以到达第i个下标
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && nums[j] >= i - j;
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[len - 1];
    }

    /**
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度,到达最后一个下标的最小跳跃次数
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 1) {
            return 0;
        }
        int len = nums.length;
        // dp[i]代表可以到达第i个下标的最小跳跃次数
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            dp[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= i - j) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }

    /**
     * 最大路径和
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (Objects.isNull(grid) || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 带有障碍物的不同路径
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (Objects.isNull(obstacleGrid) || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 最小的三角路径和
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (Objects.isNull(triangle) || Objects.isNull(triangle.get(0))) {
            return 0;
        }
        int len = triangle.size();
        int[] dp = new int[len];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                int num = triangle.get(i).get(j);
                if (j == i) {
                    dp[j] = num + dp[j - 1];
                } else if (j - 1 < 0) {
                    dp[j] = num + dp[j];
                } else {
                    dp[j] = num + Math.min(dp[j], dp[j - 1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }

    /**
     * 能偷到的最大金额(两间相邻的房屋不能同时被偷)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        // dp[i]代表偷前i家获得的最大金额
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], (i > 1 ? dp[i - 2] : 0) + nums[i]);
        }

        return dp[len - 1];
    }

    /**
     * 能偷到的最大金额(两间相邻(环形)的房屋不能同时被偷)
     * @param nums
     * @return
     */
    public int robWithCircle(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                rob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    /**
     * 最长递增子序列长度
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        // dp[i]代表以i结尾最长递增子序列长度
        int[] dp = new int[len];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * 只包含 '1' 的最大正方形面积
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (Objects.isNull(matrix) || matrix.length == 0 || Objects.isNull(matrix[0]) || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        // dp[i][j]代表以(i,j)为右下角，且只包含'1'的正方形的边长最大值
        int[][] dp = new int[m][n];
        int maxSide = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }

        return maxSide * maxSide;
    }

    /**
     * 超级丑数是一个正整数,并满足其所有质因数都出现在质数数组primes中，求第n个超级丑数
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0 || Objects.isNull(primes) || primes.length == 0) {
            return 0;
        }
        // pointer[i]用来记录第i个质因数在超级丑数数组中所处的位置
        int[] pointer = new int[primes.length];
        Arrays.fill(pointer, 1);
        // dp[i]代表第i个超级丑数
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int len = primes.length;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                dp[i] = Math.min(dp[i], dp[pointer[j]] * primes[j]);
            }
            for (int j = 0; j < len; j++) {
                if (dp[i] == dp[pointer[j]] * primes[j]) {
                    pointer[j]++;
                }
            }
        }
        return dp[n];
    }

    /**
     * 计算可以凑成总金额所需的最少的硬币个数
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (Objects.isNull(coins) || coins.length == 0 || amount <= 0) {
            return 0;
        }
        //dp[i]表示总金额为i所需要的最小硬币数
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]]!= Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * 计算可以凑成总金额的最大方案数
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        if (Objects.isNull(coins) || coins.length == 0 || amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // (1,1,2)和(2,1,1)为一种方案
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[amount];
    }

    /**
     * 和为目标值的所有组合数
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0 || target <= 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // (1,1,2)和(2,1,1)为两种方案
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }

    /**
     * 最大整除子集
     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(nums) || nums.length == 0) {
            return result;
        }
        int len = nums.length;
        // dp[i]代表以第i个元素结尾的最大整除子集数
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        int maxSize = 0, maxValue = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (maxSize < dp[i]) {
                maxSize = dp[i];
                maxValue = nums[i];
            }
        }

        // 寻找结果集
        for (int i = len - 1; i >= 0; i--) {
            if (dp[i] == maxSize && maxValue % nums[i] == 0) {
                result.add(0, nums[i]);
                maxValue = nums[i];
                if (--maxSize <= 0) {
                    break;
                }
            }
        }

        return result;
    }

    /**
     * 最长摆动序列长度
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 0) {
            return 0;
        }
        int len = nums.length;
        // up[i]表示第i个元素为上升的最长摆动序列长度
        // down[i]表示第i个元素为下降的最长摆动序列长度
        int[] up = new int[len], down = new int[len];
        down[0] = up[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(down[len - 1], up[len - 1]);
    }

    /**
     * 最大等差序列子数组个数
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 3) {
            return 0;
        }
        int len = nums.length, result = 0;
        // dp[i]表示以i结尾的等差序列子数组个数
        int[] dp = new int[len];
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                result += dp[i];
            }
        }
        return result;
    }

    /**
     * 最大等差序列子序列长度(公差一定)
     * @param nums
     * @param difference
     * @return
     */
    public int longestSubsequence(int[] nums, int difference) {
        if (Objects.isNull(nums) || nums.length <= 0) {
            return 0;
        }
        int len = nums.length, max = Integer.MIN_VALUE;
        //dp[i][j]代表 前i个元素公差为j的最大子序列长度
        int[] dp = new int[len];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int idx : map.getOrDefault(nums[i] - difference, new ArrayList<>())) {
                if (idx < i) {
                    dp[i] = Math.max(dp[idx] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 最大等差序列子序列长度
     * @param nums
     * @return
     */
    public int longestArithmeticSeqLength(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 0) {
            return 0;
        }
        int len = nums.length, max = Integer.MIN_VALUE, offset = 10000;
        //dp[i][j]代表 前i个元素公差为j的最大子序列长度
        int[][] dp = new int[len][2 * offset];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[j] - nums[i] + offset;
                // Math.max(dp[j][diff], 1) 避免初始化整个数组为1
                dp[i][diff] = Math.max(dp[j][diff], 1) + 1;
                max = Math.max(max, dp[i][diff]);
            }
        }
        return max;
    }

    /**
     * 是否可以将数组分为两个和相同的数组
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2, len = nums.length;
        // dp[i][j]代表前i个元素是否能组成和为j
        boolean[][] dp = new boolean[len][target + 1];
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < len; j++) {
                if (nums[j] == i) {
                    dp[j][i] = true;
                    continue;
                }
                if (j >= 1) {
                    dp[j][i] = dp[j - 1][i];
                    if (i >= nums[j]) {
                        dp[j][i] |= dp[j - 1][i - nums[j]];
                    }
                }
            }
        }
        return dp[len - 1][target];
    }

    /**
     * 满足指定个数的0和1的最大子集数
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        if (Objects.isNull(strs) || strs.length <= 0 || m <= 0 || n <= 0) {
            return 0;
        }
        int len = strs.length;
        // dp[i][j][k]代表前i个元素最多有j个0，k个1的最大元素个数
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            int[] cnt = getZeroAndOneCount(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= cnt[0] && k >= cnt[1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - cnt[0]][k - cnt[1]] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    /**
     * 计算字符串中0和1出现的次数
     * @param str
     * @return
     */
    private int[] getZeroAndOneCount(String str) {
        if (Objects.isNull(str) || str.length() <= 0) {
            return new int[]{0, 0};
        }
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }

    /**
     *
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 0) {
            return false;
        }
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {

            }
        }
        return false;
    }
}
