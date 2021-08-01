package top.sakuraffy.offer.custom;

import top.sakuraffy.commom.TreeNode;

import java.util.*;

/**
 *  序列化二叉树
 * @author: zhangqiushi
 * @create: 2021/07/26 11:45
 */
public class TreeCodec {
    public static final String SPACE = " ";
    public static final String STRING_NULL = "null";

    public String serialize(TreeNode root) {
        if (Objects.isNull(root)) {
            return "";
        }
        List<Integer> list = new ArrayList<>();
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= idx; i++) {
            sb.append(list.get(i)).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public TreeNode deserialize(String data) {
        if (Objects.isNull(data) || data.length() == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (String str : data.split(SPACE)) {
            if (Objects.equals(str, STRING_NULL)) {
                list.add(null);
            } else {
                list.add(Integer.parseInt(str));
            }
        }

        return create(list);
    }

    /**
     * 创建二叉树
     * @param list
     * @return
     */
    private TreeNode create(List<Integer> list) {
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
}
