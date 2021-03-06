package top.sakuraffy.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.sakuraffy.commom.ListNode;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListSolutionTest {

    private LinkedListSolution linkedListSolutionUnderTest;

    @BeforeEach
    void setUp() {
        linkedListSolutionUnderTest = new LinkedListSolution();
    }

    @Test
    void testMiddleNode() {
        final ListNode head = ListNode.create(Arrays.asList(1,2,3,4,5));
        final ListNode result = linkedListSolutionUnderTest.middleNode(head);
        assertEquals(Arrays.asList(3,4,5).toString(), result.toString());

        final ListNode head1 = ListNode.create(Arrays.asList(1,2,3,4,5,6));
        final ListNode result1 = linkedListSolutionUnderTest.middleNode(head1);
        assertEquals(Arrays.asList(3,4,5,6).toString(), result1.toString());
    }

    @Test
    void testHasCycle() {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        node.next = head;
        final boolean result = linkedListSolutionUnderTest.hasCycle(head);
        assertTrue(result);
    }

    @Test
    void testGetDecimalValue() {
        final ListNode head = ListNode.create(Arrays.asList(1, 1, 1));
        final int result = linkedListSolutionUnderTest.getDecimalValue(head);
        assertEquals(7, result);
    }

    @Test
    void testDeleteDuplicates() {
        final ListNode head = ListNode.create(Arrays.asList(1, 1, 1, 2, 3, 3));
        final ListNode result = linkedListSolutionUnderTest.deleteDuplicates(head);
        assertEquals(Arrays.asList(1, 2, 3).toString(), result.toString());
    }

    @Test
    void testReverseList() {
        final ListNode head = ListNode.create(Arrays.asList(1,2,3,4,5));
        final ListNode result = linkedListSolutionUnderTest.reverseList(head);
        assertEquals(Arrays.asList(5,4,3,2,1).toString(), result.toString());
    }

    @Test
    void testRemoveNthFromEnd() {
        final ListNode head = ListNode.create(Arrays.asList(1));
        final ListNode result = linkedListSolutionUnderTest.removeNthFromEnd(head, 1);
        assertNull(result);
        final ListNode head1 = ListNode.create(Arrays.asList(1, 2));
        final ListNode result1 = linkedListSolutionUnderTest.removeNthFromEnd(head1, 2);
        assertEquals(Arrays.asList(2).toString(), result1.toString());
    }

    @Test
    void testReverseBetween() {
        final ListNode head = ListNode.create(Arrays.asList(1,2,3,4,5));
        final ListNode result = linkedListSolutionUnderTest.reverseBetween(head, 2, 4);
        assertEquals(Arrays.asList(1,4,3,2,5).toString(), result.toString());
        final ListNode head1 = ListNode.create(Arrays.asList(1, 2));
        final ListNode result1 = linkedListSolutionUnderTest.reverseBetween(head1, 1, 4);
        assertEquals(Arrays.asList(2, 1).toString(), result1.toString());
    }

    @Test
    void testMergeTwoLists() {
        final ListNode head1 = ListNode.create(Arrays.asList(1, 1, 2, 4, 6, 8));
        final ListNode head2 = ListNode.create(Arrays.asList(3, 4, 5));
        final ListNode result = linkedListSolutionUnderTest.mergeTwoLists(head1, head2);
        assertEquals(Arrays.asList(1, 1, 2, 3, 4, 4, 5, 6, 8).toString(), result.toString());
    }
}
