package top.sakuraffy.offer;

import top.sakuraffy.commom.TreeNode;

import java.util.*;

/**
 * @author: zhangqiushi
 * @create: 2021/07/23 20:45
 */
public class TreeSolution {
    /**
     * 根据中序遍历和先序遍历重建树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreeWithPreAndIn(int[] preorder, int[] inorder) {
        if (Objects.isNull(preorder) || Objects.isNull(inorder) || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeWithPreAndIn(preorder, map, 0, preorder.length - 1, 0);
    }

    /**
     * 根据中序遍历和先序遍历重建树
     * @param preorder
     * @param map
     * @param preStart
     * @param preEnd
     * @param inStart
     * @return
     */
    private TreeNode buildTreeWithPreAndIn(int[] preorder, Map<Integer, Integer> map, int preStart,
                                           int preEnd, int inStart) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = map.get(preorder[preStart]);
        int leftSubTreeLength = idx - inStart;
        root.left = buildTreeWithPreAndIn(preorder, map, preStart + 1, preStart + leftSubTreeLength, inStart);
        root.right = buildTreeWithPreAndIn(preorder, map, preStart + leftSubTreeLength + 1, preEnd, idx + 1);
        return root;
    }

    /**
     * 根据中序遍历和后序遍历重建树
     * @param postorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreeWithPostAndIn(int[] postorder, int[] inorder) {
        if (Objects.isNull(postorder) || Objects.isNull(inorder) || postorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeWithPostAndIn(postorder, map, 0, postorder.length - 1, inorder.length - 1);
    }

    /**
     * 根据中序遍历和后序遍历重建树
     * @param postorder
     * @param map
     * @param postStart
     * @param postEnd
     * @param inEnd
     * @return
     */
    private TreeNode buildTreeWithPostAndIn(int[] postorder, Map<Integer, Integer> map, int postStart, int postEnd, int inEnd) {
        if (postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = map.get(postorder[postEnd]);
        int rightSubTreeLength = inEnd - idx;
        root.left = buildTreeWithPostAndIn(postorder, map, postStart, postEnd - rightSubTreeLength - 1, idx - 1);
        root.right = buildTreeWithPostAndIn(postorder, map, postEnd - rightSubTreeLength, postEnd - 1, inEnd);
        return root;
    }

    /**
     * 判断B是不是A的子结构
     * @param head1
     * @param head2
     * @return
     */
    public boolean isSubStructure(TreeNode head1, TreeNode head2) {
        if (Objects.isNull(head1) || Objects.isNull(head2)) {
            return false;
        }
        return doCheckSubStructure(head1, head2)|| isSubStructure(head1.left, head2) || isSubStructure(head1.right, head2);
    }

    /**
     * 判断B是不是A的子结构
     * @param node1
     * @param node2
     * @return
     */
    private boolean doCheckSubStructure(TreeNode node1, TreeNode node2) {
        if (Objects.isNull(node2)) {
            return true;
        }
        if (Objects.isNull(node1) || !Objects.equals(node1.val, node2.val)) {
            return false;
        }
        return doCheckSubStructure(node1.left, node2.left) && doCheckSubStructure(node1.right, node2.right);
    }

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (Objects.nonNull(node.left)) {
                queue.offer(node.left);
            }
            if (Objects.nonNull(node.right)) {
                queue.offer(node.right);
            }
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    /**
     * 二叉树中和为某一值的所有路径
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        pathSum(root, target, new Stack<Integer>(), result);
        return result;
    }

    /**
     * 二叉树中和为某一值的所有路径
     * @param node
     * @param target
     * @param stack
     * @param result
     */
    private void pathSum(TreeNode node, int target, Stack<Integer> stack, List<List<Integer>> result) {
        if (Objects.isNull(node)) {
            return;
        }
        if (Objects.isNull(node.left) && Objects.isNull(node.right) && node.val == target) {
            stack.push(node.val);
            result.add(new ArrayList<>(stack));
            stack.pop();
            return;
        }

        stack.push(node.val);
        pathSum(node.left, target - node.val, stack, result);
        pathSum(node.right, target - node.val, stack, result);
        stack.pop();
    }

    public TreeNode head, pre;
    /**
     * 将该二叉搜索树转换成一个排序的循环双向链表
     * @param root
     * @return
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        doTreeToDoublyList(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 将该二叉搜索树转换成一个排序的循环双向链表
     * @param curr
     */
    private void doTreeToDoublyList(TreeNode curr) {
        if (Objects.isNull(curr)) {
            return;
        }

        doTreeToDoublyList(curr.left);
        if (Objects.nonNull(pre)) {
            pre.right = curr;
        } else {
            head = curr;
        }
        curr.left = pre;
        pre = curr;
        doTreeToDoublyList(curr.right);
    }

    /**
     * 判断是否为平衡二叉树(自底向上)
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        return height(root) >= 0;
    }

    /**
     * 计算树的高度
     * @param root
     * @return
     */
    private int height(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    /**
     * 判断是否为平衡二叉树(自顶向下)
     * @param root
     * @return
     */
    public boolean isBalancedWithUpToDown(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        return isBalancedWithUpToDown(root.left) && isBalancedWithUpToDown(root.right)
                && Math.abs(maxDepth(root.left) - maxDepth(root.right)) < 2;
    }

    /**
     *  二叉搜索树的第k大节点
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        if (Objects.isNull(root)) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return k > 0 && k <= list.size() ? list.get(k - 1) : 0;
    }

    /**
     * 中序遍历
     * @param node
     * @param list
     */
    private void inorder(TreeNode node, List<Integer> list) {
        if (Objects.isNull(node)) {
            return;
        }
        inorder(node.left, list);
        list.add(0, node.val);
        inorder(node.right, list);
    }

    /**
     * 判断是否为对称的二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    /**
     * 判断是否为对称的二叉树
     * @param node1
     * @param node2
     * @return
     */
    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return Objects.equals(node1.val, node2.val) && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }

    /**
     * 二叉搜索树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (Objects.isNull(root) || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (Objects.nonNull(left) && Objects.nonNull(right)) {
            return root;
        }

        return Objects.isNull(left) ? right : left;
    }

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> realLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (Objects.nonNull(node.left)) {
                    queue.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                if (Objects.nonNull(node.left)) {
                    queue.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
            level++;
        }
        return result;
    }

    /**
     * 二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 二叉树的镜像
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        swap(root);
        return root;
    }

    /**
     * 交换树左右节点
     * @param node
     */
    private void swap(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        swap(node.left);
        swap(node.right);
    }

    /**
     * 判断该数组是不是某二叉搜索树的后序遍历结果
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if (Objects.isNull(postorder) || postorder.length == 0) {
            return false;
        }

        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    /**
     * 递归判断该数组是不是某二叉搜索树的后序遍历结果
     * @param postorder
     * @param low
     * @param high
     * @return
     */
    private boolean verifyPostorder(int[] postorder, int low, int high) {
        if (low > high) {
            return true;
        }
        int temp = postorder[high];
        int i = low;
        int j = high - 1;
        while (i <= high && postorder[i] < temp) {
            i++;
        }
        while (j >= 0 && postorder[j] > temp) {
            j--;
        }
        return i == j + 1 && verifyPostorder(postorder, low, j) && verifyPostorder(postorder, i, high - 1);
    }

    /**
     * 判断该数组是不是某二叉搜索树的后序遍历结果
     * @param postorder
     * @return
     */
    public boolean verifyPostorderWithStack(int[] postorder) {
        if (Objects.isNull(postorder) || postorder.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > max) {
                return false;
            }
            while (!stack.isEmpty() && postorder[i] < stack.peek()) {
                max = stack.pop();
            }
            stack.push(postorder[i]);
        }

        return true;
    }
}
