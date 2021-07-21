package top.sakuraffy.commom;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: coding
 * @description: 链表
 * @author: zhangqiushi
 * @create: 2021/06/09 18:35
 */
public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode(Integer val) {
        this.val = val;
    }

    /**
     * 创建单链表
     * @param list
     * @return
     */
    public static ListNode create(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ListNode head = null;
        ListNode tail = null;

        for (Integer num : list) {
            ListNode node = new ListNode(num);
            if (head == null) {
                head = node;
                tail = node;
            }

            tail.next = node;
            tail = node;
        }

        return head;
    }

    /**
     * 链表遍历
     * @return
     */
    public List<Integer> print() {
        List<Integer> list = new ArrayList<>();
        ListNode node = this;
        while (node != null) {
            list.add(node.val);
        }
        return list;
    }
}
