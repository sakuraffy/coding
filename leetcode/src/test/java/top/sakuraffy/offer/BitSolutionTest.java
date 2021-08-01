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
        // Setup

        // Run the test
        final int result = bitSolutionUnderTest.singleNumber(new int[]{0});

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testHammingWeight() {
        // Setup

        // Run the test
        final int result = bitSolutionUnderTest.hammingWeight(0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testCountDigitOne() {
        // Setup

        // Run the test
        final int result = bitSolutionUnderTest.countDigitOne(0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testAdd() {
        // Setup

        // Run the test
        final int result = bitSolutionUnderTest.add(0, 0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testMyPow() {
        // Setup

        // Run the test
        final double result = bitSolutionUnderTest.myPow(0.0, 0);

        // Verify the results
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    void testSingleNumbers() {
        // Setup

        // Run the test
        final int[] result = bitSolutionUnderTest.singleNumbers(new int[]{0});

        // Verify the results
        assertArrayEquals(new int[]{0}, result);
    }
}
