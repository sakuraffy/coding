package top.sakuraffy.offer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BitSolutionTest {

    private BitSolution bitSolutionUnderTest;

    @BeforeEach
    void setUp() {
        bitSolutionUnderTest = new BitSolution();
    }

    @Test
    void testSumNums() {
        // Setup

        // Run the test
        final int result = bitSolutionUnderTest.sumNums(0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testSingleNumber() {
        final int result = bitSolutionUnderTest.singleNumber(new int[]{1,5,1,1});
        assertEquals(5, result);
    }

    @Test
    void testHammingWeight() {
        final int result = bitSolutionUnderTest.hammingWeight(5);
        assertEquals(2, result);
    }

    @Test
    void testCountDigitOne() {
        final int result = bitSolutionUnderTest.countDigitOne(21354);
        assertEquals(18831, result);
    }

    @Test
    void testAdd() {
        final int result = bitSolutionUnderTest.add(0, 0);
        assertEquals(0, result);
    }

    @Test
    void testMyPow() {
        final double result = bitSolutionUnderTest.myPow(2, 5);
        assertEquals(32, result, 0.0001);
        final double result1 = bitSolutionUnderTest.myPow(2, -1);
        assertEquals(0.5, result1, 0.0001);
    }

    @Test
    void testSingleNumbers() {
        final int[] result = bitSolutionUnderTest.singleNumbers(new int[]{1,1,4,6});
        assertArrayEquals(new int[]{4,6}, result);
    }
}
