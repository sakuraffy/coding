package top.sakuraffy.offer.custom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianFinderTest {

    private MedianFinder medianFinderUnderTest;

    @BeforeEach
    void setUp() {
        medianFinderUnderTest = new MedianFinder();
    }

    @Test
    void testAddNum() {
        // Setup

        // Run the test
        medianFinderUnderTest.addNum(0);

        // Verify the results
    }

    @Test
    void testFindMedian() {
        // Setup

        // Run the test
        final double result = medianFinderUnderTest.findMedian();

        // Verify the results
        assertEquals(0.0, result, 0.0001);
    }
}
