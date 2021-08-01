package top.sakuraffy.commom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: zhangqiushi
 * @create: 2021/07/26 11:17
 */
public class RandomListNode {
    public Integer val;
    public RandomListNode next;
    public RandomListNode random;

    public RandomListNode(Integer val) {
        this.val = val;
    }

    public RandomListNode(Integer val, RandomListNode random) {
        this.val = val;
        this.random = random;
    }

    /**
     * 创建单链表
     * @param list
     * @return
     */
    public static RandomListNode create(List<Integer[]> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        RandomListNode head = null;
        RandomListNode tail = null;

        List<RandomListNode> nodes = new ArrayList<>();

        for (Integer[] num : list) {
            RandomListNode node = new RandomListNode(num[0]);
            nodes.add(node);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).random = list.get(i)[1] != null ? nodes.get(list.get(i)[1]) : null;
        }

        return head;
    }

    @Override
    public String toString() {
        List<Integer[]> list = new ArrayList<>();
        for (RandomListNode node = this; node != null; node = node.next) {
            list.add(new Integer[]{node.val, node.random.val});
        }
        return list.toString();
    }

    @Override
    public boolean equals(Object o) {
        RandomListNode node1 = this;
        RandomListNode node2 = (RandomListNode) o;
        while (node1 != null && node2 != null) {
            if (!Objects.equals(node1.val, node2.val)) {
                return false;
            }
            if (node1.next != null && node2.next != null && !Objects.equals(node1.next.val, node2.next.val)) {
                return false;
            }
            if (node1.random != null && node2.random != null && !Objects.equals(node1.random.val, node2.random.val)) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1 == null && node2 == null;
    }
}
