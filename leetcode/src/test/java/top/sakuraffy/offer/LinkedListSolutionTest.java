package top.sakuraffy.offer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.sakuraffy.commom.ListNode;
import top.sakuraffy.commom.RandomListNode;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListSolutionTest {

    private LinkedListSolution linkedListSolutionUnderTest;

    @BeforeEach
    void setUp() {
        linkedListSolutionUnderTest = new LinkedListSolution();
    }

    @Test
    void testReverseList() {
        final ListNode head = ListNode.create(Arrays.asList(1, 2, 3, 4, 5));
        final ListNode result = linkedListSolutionUnderTest.reverseList(head);
        assertEquals(ListNode.create(Arrays.asList(5,4,3,2,1)).toString(), result.toString());
    }

    @Test
    void testGetKthFromEnd() {
        final ListNode head = ListNode.create(Arrays.asList(1, 2, 3, 4, 5));
        final ListNode result = linkedListSolutionUnderTest.getKthFromEnd(head, 2);
        assertEquals(ListNode.create(Arrays.asList(4, 5)).toString(), result.toString());
    }

    @Test
    void testReversePrint() {
        final ListNode head = ListNode.create(Arrays.asList(1, 2, 3, 4, 5));
        final int[] result = linkedListSolutionUnderTest.reversePrint(head);
        assertArrayEquals(new int[]{5,4,3,2,1}, result);
    }

    @Test
    void testCopyRandomList() {
        final RandomListNode head = RandomListNode.create(Arrays.asList(new Integer[]{1, 1}, new Integer[]{2, 1}));
        final RandomListNode result = linkedListSolutionUnderTest.copyRandomList(head);
        assertTrue(head.equals(result));
    }

    @Test
    void testGetIntersectionNode() {
        final ListNode headA = ListNode.create(Arrays.asList(1,2,3,6,7));
        final ListNode headB = ListNode.create(Arrays.asList(4,5,6,7));;
        final ListNode result = linkedListSolutionUnderTest.getIntersectionNode(headA, headB);
        assertNull(result);
    }

    @Test
    void testDeleteNode() {
        final ListNode head = ListNode.create(Arrays.asList(1,2,3,3,3));
        final ListNode result = linkedListSolutionUnderTest.deleteNode(head, 3);
        assertEquals(Arrays.asList(1,2).toString(), result.toString());
        final ListNode head1 = ListNode.create(Arrays.asList(3,3,3,3,3));
        final ListNode result1 = linkedListSolutionUnderTest.deleteNode(head1, 3);
        assertNull(result1);
    }
}
