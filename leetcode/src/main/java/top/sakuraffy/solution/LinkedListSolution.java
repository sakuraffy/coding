package top.sakuraffy.solution;

import top.sakuraffy.commom.ListNode;

import java.util.List;

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
}
