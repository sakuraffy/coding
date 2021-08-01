package top.sakuraffy.offer.custom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinStackTest {

    private MinStack minStackUnderTest;

    @BeforeEach
    void setUp() {
        minStackUnderTest = new MinStack();
    }

    @Test
    void testPush() {
        minStackUnderTest.push(0);
        assertEquals(0, minStackUnderTest.top());
    }

    @Test
    void testPop() {
        minStackUnderTest.push(0);
        minStackUnderTest.pop();
        assertTrue(minStackUnderTest.stack.isEmpty());
    }

    @Test
    void testTop() {
        minStackUnderTest.push(0);
        assertEquals(0, minStackUnderTest.top());
    }

    @Test
    void testMin() {
        minStackUnderTest.push(0);
        final int result = minStackUnderTest.min();
        // Verify the results
        assertEquals(0, result);
    }
}
