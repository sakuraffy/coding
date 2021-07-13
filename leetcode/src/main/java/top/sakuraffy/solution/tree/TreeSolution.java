package top.sakuraffy.solution.tree;

import top.sakuraffy.commom.ListNode;
import top.sakuraffy.commom.TreeNode;

import java.util.*;

/**
 * @program: coding
 * @description: 树
 * @author: zhangqiushi
 * @create: 2021/06/03 19:09
 */
public class TreeSolution {

    /**
     * 判断是否为搜索二叉树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 判断是否为搜索二叉树
     * @param root
     * @param minValue
     * @param maxValue
     * @return
     */
    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }

        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

    /**
     * 最长同值路径
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] res = new int[1];
        longestUnivaluePath(root, -1, res);
        return res[0];
    }

    /**
     * 最长同值路径
     * @param curr
     * @param parentVal
     * @param res
     * @return
     */
    private int longestUnivaluePath(TreeNode curr, Integer parentVal, int[] res) {
        if (curr == null) {
            return 0;
        }

        int left = longestUnivaluePath(curr.left, curr.val, res);
        int right = longestUnivaluePath(curr.right, curr.val, res);

        res[0] = Math.max(res[0], left + right);

        return curr.val.equals(parentVal) ? 1 + Math.max(left, right) : 0;
    }

    /**
     * 分割树使其和之积最大
     * @param root
     * @return
     */
    public int maxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long[] res = new long[1];
        maxProduct(root, sum(root), res);
        return (int)(res[0] % 1_000_000_007);
    }

    /**
     * 分割树使其和之积最大
     * @param node
     * @param total
     * @param res
     */
    private long maxProduct(TreeNode node, long total, long[] res) {
        if (node == null) {
            return 0;
        }

        long left = maxProduct(node.left, total, res);
        long right = maxProduct(node.right, total, res);
        long sum = left + right + node.val;
        res[0] = Math.max(res[0], sum * (total - sum));

        return sum;
    }

    /**
     * 计算树之和
     * @param root
     * @return
     */
    private long sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }

    /**
     * 二叉树中是否存在包含链表的连续路径
     * @param head
     * @param root
     * @return
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }
        return isSubPathDFS(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    /**
     * 二叉树中是否存在包含链表的连续路径
     * @param head
     * @param node
     * @return
     */
    private boolean isSubPathDFS(ListNode head, TreeNode node) {
        if (head == null) {
            return true;
        }

        if (node == null) {
            return false;
        }

        return head.val.equals(node.val) && (isSubPathDFS(head.next, node.left) || isSubPathDFS(head.next, node.right));
    }

    /**
     * 从叶子到根结点的最小字符串
     * @param root
     * @return
     */
    public String smallestFromLeaf(TreeNode root) {
        Queue<String> queue = new PriorityQueue<>();
        smallestFromLeaf(root, "", queue);
        return queue.poll();
    }

    /**
     * 从叶子到根结点的最小字符串
     * @param node
     * @param pre
     * @param queue
     */
    private void smallestFromLeaf(TreeNode node, String pre, Queue<String> queue) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            // reverse string
            String str = new StringBuilder(pre + (char)('a' + node.val)).reverse().toString();
            queue.offer(str);
            return;
        }
        smallestFromLeaf(node.left, pre + (char)('a' + node.val), queue);
        smallestFromLeaf(node.right, pre + (char)('a' + node.val), queue);
    }

    /**
     * 生成节点数为n的所有排序树
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    /**
     * 生成节点数为n的所有排序树
     * @param left
     * @param right
     * @return
     */
    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            for (TreeNode l : generateTrees(left, i - 1)) {
                for (TreeNode r : generateTrees(i + 1, right)) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        return res;
    }

    /**
     * 生成节点数为n的所有排序树总数
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    /**
     * 拉链式层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            level++;
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    item.add(0, node.val);
                } else {
                    item.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(item);
        }

        return res;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return sortedListToBST(head, null);
    }

    public TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != tail && fast.next.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, tail);
        return root;
    }

    /**
     * 最大路径和
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
     * 最大路径和
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
}
