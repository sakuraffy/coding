package top.sakuraffy.same;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import top.sakuraffy.commom.TreeNode;

import java.util.*;

/**
 * @program: coding
 * @description: 路径问题
 * @author: zhangqiushi
 * @create: 2021/07/07 09:07
 */
public class Path {
    /**
     * 二叉树中是否存在路径和与目标值相同
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, targetSum, 0);
    }

    /**
     * 二叉树中是否存在路径和与目标值相同
     * @param node
     * @param sum
     * @return
     */
    private boolean hasPathSum(TreeNode node, int target, int sum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null && node.val + sum == target) {
            return true;
        }
        return hasPathSum(node.left, target, sum + node.val) || hasPathSum(node.right, target, sum + node.val);
    }

    /**
     * 找出二叉树中路径和与目标值相同的所有组合
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        pathSum(root, targetSum, 0, new Stack<>(), res);
        return res;
    }

    /**
     * 找出二叉树中路径和与目标值相同的所有组合
     * @param node
     * @param targetSum
     * @param sum
     * @param stack
     * @param res
     */
    private void pathSum(TreeNode node, int targetSum, int sum, Stack<Integer> stack, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (node.val + sum == targetSum) {
                stack.push(node.val);
                res.add(new ArrayList<>(stack));
                stack.pop();
            }
            return;
        }
        stack.add(node.val);
        pathSum(node.left, targetSum, sum + node.val, stack, res);
        pathSum(node.right, targetSum, sum + node.val, stack, res);
        stack.pop();
    }

    /**
     * 找出二叉树中所有路径和与目标值相同的组合数(路径不需要在叶子节点结束)
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSumCount(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        return pathSumCount(root, targetSum, 0) + pathSumCount(root.left, targetSum) + pathSumCount(root.right, targetSum);
    }

    /**
     * 找出二叉树中所有路径和与目标值相同的组合数(路径不需要在叶子节点结束)
     * @param node
     * @param targetSum
     * @param sum
     * @return
     */
    private int pathSumCount(TreeNode node, int targetSum, int sum) {
        if (node == null) {
            return 0;
        }

        int left = pathSumCount(node.left, targetSum, sum + node.val);
        int right = pathSumCount(node.right, targetSum, sum + node.val);

        return left + right + (sum + node.val == targetSum ? 1 : 0);
    }

    /**
     * 找出二叉树中所有路径和与目标值相同的组合数(路径不需要在叶子节点结束)
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSumCountWithMap(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return pathSumCountWithMap(root, targetSum, 0, map);
    }

    /**
     * 找出二叉树中所有路径和与目标值相同的组合数(路径不需要在叶子节点结束)
     * @param node
     * @param targetSum
     * @param sum
     * @param map
     * @return
     */
    private int pathSumCountWithMap(TreeNode node, int targetSum, int sum, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        sum += node.val;
        int res = map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        int left = pathSumCountWithMap(node.left, targetSum, sum, map);
        int right = pathSumCountWithMap(node.right, targetSum, sum, map);
        map.put(sum, map.get(sum) - 1);
        return res + left + right;
    }

    /**
     * 二叉树最大路径和
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[]{Integer.MIN_VALUE};
        maxPathSum(root, res);
        return res[0];
    }

    /**
     * 二叉树最大路径和
     * @param node
     * @param res
     */
    private int maxPathSum(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSum(node.left, res));
        int right = Math.max(0, maxPathSum(node.right, res));
        res[0] = Math.max(res[0], node.val + left + right);
        return node.val + Math.max(left, right);
    }

    /**
     * 考虑网格中有障碍物，从左上角到右下角的路径条数（只能向下或向右）
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
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

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    /**
     * 网格中最小路径和（只能向下或向右）
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
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

        return dp[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 网格中最小下降路径和（只能走与上一格相邻的格子）
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    if (j - 1 < 0) {
                        dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                    } else if (j + 1 >= matrix[0].length) {
                        dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < dp[0].length; j++) {
            res = Math.min(res, dp[dp.length - 1][j]);
        }
        return res;
    }

    /**
     * 考虑网格中有障碍物，从起点到终点的路径条数（可以上下左右移动，同一个无障碍方格有且只能通过一次）
     * @param grid
     * @return
     */
    public int uniquePathsIII(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int x = 0, y = 0, empty = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j< grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }

        return uniquePathsIII(grid, x, y, empty);
    }

    /**
     * 考虑网格中有障碍物，从起点到终点的路径条数（可以上下左右移动，同一个无障碍方格有且只能通过一次）
     * @param grid
     * @param i
     * @param j
     * @param empty
     * @return
     */
    private int uniquePathsIII(int[][] grid, int i, int j, int empty) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] < 0 || empty < 0) {
            return 0;
        }

        if (grid[i][j] == 2) {
            return empty == 0 ? 1 : 0;
        }

        empty--;
        grid[i][j] = -2;

        int up = uniquePathsIII(grid, i, j - 1, empty);
        int down = uniquePathsIII(grid, i, j + 1, empty);
        int left = uniquePathsIII(grid, i - 1, j, empty);
        int right = uniquePathsIII(grid, i + 1, j, empty);

        empty++;
        grid[i][j] = 0;

        return up + down + left + right;
    }

    /**
     * 最大同值路径
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(longestUnivaluePath(root, -1),
                Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)));
    }

    private int longestUnivaluePath(TreeNode node, Integer parentValue) {
        if (node == null) {
            return 0;
        }
        int left = longestUnivaluePath(node.left, node.val);
        int right = longestUnivaluePath(node.right, node.val);

        return left + right + node.val == parentValue ? 1 : 0;
    }

    /**
     * 二进制矩阵中的最短路径(八个方向)
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int[] res = new int[]{Integer.MAX_VALUE};
        shortestPathBinaryMatrix(grid, 0, 0, 0, res);
        return res[0] == Integer.MAX_VALUE ? -1 : res[0];
    }

    /**
     * 二进制矩阵中的最短路径(八个方向)
     * @param grid
     * @param i
     * @param j
     * @param depth
     * @param res
     */
    private void shortestPathBinaryMatrix(int[][] grid, int i, int j, int depth, int[] res) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 0) {
            return;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            res[0] = Math.min(res[0], depth);
            return;
        }

        grid[i][j] = -1;

        shortestPathBinaryMatrix(grid, i, j - 1, depth + 1, res);
        shortestPathBinaryMatrix(grid, i, j + 1, depth + 1, res);
        shortestPathBinaryMatrix(grid, i - 1, j, depth + 1, res);
        shortestPathBinaryMatrix(grid, i + 1, j, depth + 1, res);
        shortestPathBinaryMatrix(grid, i - 1, j - 1, depth + 1, res);
        shortestPathBinaryMatrix(grid, i - 1, j + 1, depth + 1, res);
        shortestPathBinaryMatrix(grid, i + 1, j - 1, depth + 1, res);
        shortestPathBinaryMatrix(grid, i + 1, j + 1, depth + 1, res);
        grid[i][j] = 1;
    }

    /**
     * 矩阵中的最长递增路径
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        return 0;
    }
}
