package top.sakuraffy.bean.commom;

import java.util.*;

/**
 * @program: coding
 * @description: 树节点
 * @author: zhangqiushi
 * @create: 2021/06/03 18:00
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 创建二叉树
     * @param list
     * @return
     */
    public static TreeNode create(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(list.get(0));
        queue.offer(root);
        for (int i = 1; i < list.size(); i = i + 2) {
            TreeNode node = queue.poll();
            while (!queue.isEmpty() && node == null) {
                node = queue.poll();
            }
            node.left = list.get(i) == null ? null : new TreeNode(list.get(i));
            queue.offer(node.left);
            if (i + 1 < list.size()) {
                node.right = list.get(i + 1) == null ? null : new TreeNode(list.get(i + 1));
                queue.offer(node.right);
            }
        }

        return root;
    }

    /**
     * 创建搜索二叉树
     * @param list
     * @return
     */
    public static TreeNode createBST(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }

        TreeNode root = null;
        for (Integer num : list) {
            root = insertBST(root, num);
        }

        return root;
    }

    /**
     * 创建搜索二叉树
     * @param root
     * @param num
     * @return
     */
    private static TreeNode insertBST(TreeNode root, Integer num) {
        if (num == null) {
            return null;
        }
        if (root == null) {
            return new TreeNode(num);
        }

        if (num < root.val) {
            root.left = insertBST(root.left, num);
        } else {
            root.right = insertBST(root.right, num);
        }

        return root;
    }

    /**
     * 先序遍历
     * @return
     */
    public List<Integer> preorder() {
        List<Integer> list = new ArrayList<>();
        preorder(this, list);
        return list;
    }

    /**
     * 先序遍历
     * @param node
     * @param list
     */
    private void preorder(TreeNode node, List<Integer> list) {
        if (node ==  null){
            return;
        }
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    /**
     * 中序遍历
     * @return
     */
    public List<Integer> inorder() {
        List<Integer> list = new ArrayList<>();
        inorder(this, list);
        return list;
    }

    /**
     * 中序遍历
     * @param node
     * @param list
     */
    private void inorder(TreeNode node, List<Integer> list) {
        if (node ==  null){
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    /**
     * 后序遍历
     * @return
     */
    public List<Integer> postorder() {
        List<Integer> list = new ArrayList<>();
        postorder(this, list);
        return list;
    }

    /**
     * 后序遍历
     * @param node
     * @param list
     */
    private void postorder(TreeNode node, List<Integer> list) {
        if (node ==  null){
            return;
        }
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
    }

    /**
     * 层次遍历
     * @return
     */
    public List<Integer> levelOrder() {
        List<Integer> list = new ArrayList<>();
        TreeNode root = this;
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
        }
        return list;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        TreeNode root = this;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node == null ? null : node.val);
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        // remove last null
        int idx = list.size() - 1;
        while (idx >= 0 && list.get(idx) == null) {
            idx--;
        }
        return list.subList(0, idx + 1).toString();
    }
}
