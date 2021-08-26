package top.sakuraffy.solution;

import top.sakuraffy.commom.ListNode;

import java.util.List;
import java.util.Objects;

/**
 * @author: zhangqiushi
 * @create: 2021/07/21 20:47
 */
public class LinkedListSolution {

    /**
     * 链表两数相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        int add = 0;
        ListNode head = null;
        ListNode tail = null;

        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int temp = num1 + num2 + add;
            add = temp / 10;
            ListNode node = new ListNode(temp % 10);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (add != 0) {
            ListNode node = new ListNode(add);
            tail.next = node;
            tail = node;
        }

        return head;
    }

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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (Objects.isNull(head) || m <= 0 || n <= 0 || m > n) {
            return head;
        }
        ListNode p = head;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int i = 1;

        while (i < m && p != null) {
            ListNode next = p.next;
            p.next = null;
            tail.next = p;
            tail = p;
            p = next;
            i++;
        }

        ListNode reverseHead = tail;
        while (i <= n && p != null) {
            ListNode next = p.next;
            p.next = reverseHead.next;
            reverseHead.next = p;
            if (i == m) {
                tail = reverseHead.next;
            }
            i++;
            p = next;
        }

        tail.next = p;

        return dummy.next;
    }

    /**
     * 删除倒数第n个元素
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n && fast != null; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = next.next;
        next = null;

        return dummy.next;
    }

    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode next = l1.next;
                l1.next = null;
                tail.next = l1;
                tail = l1;
                l1 = next;
            } else {
                ListNode next = l2.next;
                l2.next = null;
                tail.next = l2;
                tail = l2;
                l2 = next;
            }
        }

        tail.next = l1 == null ? l2 : l1;

        return dummy.next;
    }
}
