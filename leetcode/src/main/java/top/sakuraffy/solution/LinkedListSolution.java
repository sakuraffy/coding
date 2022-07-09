package top.sakuraffy.solution;

import top.sakuraffy.commom.ListNode;

import java.util.Objects;

/**
 * @author: zhangqiushi
 * @create: 2021/07/21 20:47
 */
public class LinkedListSolution {

    /**
     * 链表的中间结点
     * @param head 头节点
     * @return ListNode
     */
    public ListNode middleNode(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 链表所表示数字的 十进制值
     * @param head 链表头
     * @return int
     */
    public int getDecimalValue(ListNode head) {
        if (Objects.isNull(head)) {
            return 0;
        }
        int res = 0;
        for (ListNode curr = head; Objects.nonNull(curr); curr = curr.next) {
            res = (res << 1) + curr.val;
        }
        return res;
    }

    /**
     * 删除重复节点
     * @param head 头节点
     * @return 无重复节点的头节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 1. 判空
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        // 2. 遍历链表，创建虚拟节点，解决第一个相同节点重复的问题
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for (ListNode curr = head; Objects.nonNull(curr);) {
            // 3.寻找相同元素中的最后一个,尾插法插入
            while (Objects.nonNull(curr.next) && curr.val.equals(curr.next.val)) {
                curr = curr.next;
            }
            tail.next = curr;
            tail = curr;
            curr = curr.next;
        }
        return dummy.next;
    }

    /**
     * 判断链表是否有环
     * @param head 头节点
     * @return 是否有环
     */
    public boolean hasCycle(ListNode head) {
        // 1. 判空
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return false;
        }
        // 2. 使用快慢指针判断环
        ListNode slow = head;
        ListNode fast = head.next;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

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
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. 判空
        if (Objects.isNull(list1)) {
            return list2;
        }
        if (Objects.isNull(list2)) {
            return list1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        // 2. 寻找较小节点，以尾插法插入
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode next = list1.next;
                tail.next = list1;
                tail = tail.next;
                list1 = next;
            } else {
                ListNode next = list2.next;
                tail.next = list2;
                tail = tail.next;
                list2 = next;
            }
        }
        // 3. 拼接不空链表
        tail.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
