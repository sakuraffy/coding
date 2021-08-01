package top.sakuraffy.offer.custom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxQueueTest {

    private MaxQueue maxQueueUnderTest;

    @BeforeEach
    void setUp() {
        maxQueueUnderTest = new MaxQueue();
    }

    @Test
    void testMax_value() {
        // Setup

        // Run the test
        final int result = maxQueueUnderTest.max_value();

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testPush_back() {
        // Setup

        // Run the test
        maxQueueUnderTest.push_back(0);

        // Verify the results
    }

    @Test
    void testPop_front() {
        // Setup

        // Run the test
        final int result = maxQueueUnderTest.pop_front();

        // Verify the results
        assertEquals(0, result);
    }
}
