package top.sakuraffy.offer;

import top.sakuraffy.commom.ListNode;
import top.sakuraffy.commom.RandomListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangqiushi
 * @create: 2021/07/23 20:35
 */
public class LinkedListSolution {
    /**
     * 链表反转
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }

        return dummy.next;
    }

    /**
     * 链表中倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /**
     * 反转打印列表
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        int len = 0;
        for (ListNode item = head; item != null; item = item.next) {
            len++;
        }

        int[] result = new int[len];
        int idx = len - 1;
        for (ListNode item = head; item != null; item = item.next) {
            result[idx--] = item.val;
        }

        return result;
    }

    /**
     * 复杂链表的复制
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        // 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        for (RandomListNode curr = head; curr != null; curr = curr.next) {
            map.put(curr, new RandomListNode(curr.val));
        }
        // 构建新链表的 next 和 random 指向
        for (RandomListNode curr = head; curr != null; curr = curr.next) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
        }
        // 返回新链表的头节点
        return map.get(head);
    }

    /**
     * 两个链表的第一个公共节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /**
     * 删除链表的节点
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (ListNode item = dummy; item.next != null;) {
            if (item.next.val == val) {
                ListNode next = item.next;
                item.next = next.next;
                next = null;
            } else {
                item = item.next;
            }
        }

        return dummy.next;
    }
}
