package top.sakuraffy.offer.custom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CQueueTest {

    private CQueue cQueueUnderTest;

    @BeforeEach
    void setUp() {
        cQueueUnderTest = new CQueue();
        cQueueUnderTest.stack = new Stack<>();
        cQueueUnderTest.temp = new Stack<>();
    }

    @Test
    void testAppendTail() {
        cQueueUnderTest.appendTail(1);
        assertEquals(1, cQueueUnderTest.stack.pop());
    }

    @Test
    void testDeleteHead() {
        cQueueUnderTest.appendTail(1);
        final int result = cQueueUnderTest.deleteHead();
        assertEquals(1, result);
    }
}
