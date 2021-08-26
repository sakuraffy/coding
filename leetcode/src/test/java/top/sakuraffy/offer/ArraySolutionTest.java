package top.sakuraffy.offer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySolutionTest {

    private ArraySolution arraySolutionUnderTest;

    @BeforeEach
    void setUp() {
        arraySolutionUnderTest = new ArraySolution();
    }

    @Test
    void testMaxProfit() {
        final int result = arraySolutionUnderTest.maxProfit(new int[]{0});
        assertEquals(0, result);
    }

    @Test
    void testSmallestK() {
        final int[] result = arraySolutionUnderTest.smallestK(new int[]{0}, 0);
        assertArrayEquals(new int[]{0}, result);
    }

    @Test
    void testSpiralOrder() {
        // Setup
        final int[][] matrix = new int[][]{{0}};

        // Run the test
        final int[] result = arraySolutionUnderTest.spiralOrder(matrix);

        // Verify the results
        assertArrayEquals(new int[]{0}, result);
    }

    @Test
    void testFindRepeatNumber() {
        // Setup

        // Run the test
        final int result = arraySolutionUnderTest.findRepeatNumber(new int[]{0});

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testMinNumberInRotateArray() {
        // Setup

        // Run the test
        final int result = arraySolutionUnderTest.minNumberInRotateArray(new int[]{0});

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testFindNumberIn2DArray() {
        final int[][] matrix = new int[][]{{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24},{18,21,23,26,30}};
        final boolean result = arraySolutionUnderTest.findNumberIn2DArray(matrix, 5);
        assertTrue(result);
        final boolean result1 = arraySolutionUnderTest.findNumberIn2DArray(matrix, 20);
        assertFalse(result1);
    }

    @Test
    void testFib() {
        final int result = arraySolutionUnderTest.fib(5);
        assertEquals(5, result);
    }

    @Test
    void testMovingCount() {
        final int result = arraySolutionUnderTest.movingCount(2, 3, 1);
        assertEquals(3, result);
    }

    @Test
    void testNumWays() {
        final int result = arraySolutionUnderTest.numWays(7);
        assertEquals(21, result);
    }

    @Test
    void testMaxSlidingWindow() {
        final int[] result = arraySolutionUnderTest.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        assertArrayEquals(new int[]{3,3,5,5,6,7}, result);
    }

    @Test
    void testLastRemaining() {
        final int result = arraySolutionUnderTest.lastRemaining(5, 3);
        assertEquals(3, result);
    }

    @Test
    void testMaxSubArray() {
        final int result = arraySolutionUnderTest.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5});
        assertEquals(6, result);
        final int result1 = arraySolutionUnderTest.maxSubArray(new int[]{-2});
        assertEquals(-2, result1);
    }

    @Test
    void testFindContinuousSequence() {
        final int[][] result = arraySolutionUnderTest.findContinuousSequence(5);
        assertArrayEquals(new int[][]{{2,3}}, result);
    }

    @Test
    void testConstructArr() {
        final int[] result = arraySolutionUnderTest.constructArr(new int[]{1,2,3,4,5});
        assertArrayEquals(new int[]{120,60,40,30,24}, result);
    }

    @Test
    void testDicesProbability() {
        final double[] result = arraySolutionUnderTest.dicesProbability(2);
        assertArrayEquals(new double[]{0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778}, result, 0.00001);
    }

    @Test
    void testExchange() {
        final int[] result = arraySolutionUnderTest.exchange(new int[]{1,2,3,4});
        assertArrayEquals(new int[]{1,3,2,4}, result);
    }

    @Test
    void testSearch() {
        final int result = arraySolutionUnderTest.search(new int[]{1,2,2,2,3,4,5}, 2);
        assertEquals(3, result);
    }

    @Test
    void testCuttingRope() {
        final int result = arraySolutionUnderTest.cuttingRope(10);
        assertEquals(36, result);
    }

    @Test
    void testTwoSum() {
        final int[] result = arraySolutionUnderTest.twoSum(new int[]{1,2,3,4}, 5);
        assertArrayEquals(new int[]{2,3}, result);
    }

    @Test
    void testIsStraight() {
        final boolean result = arraySolutionUnderTest.isStraight(new int[]{0,0,1,4,5});
        assertTrue(result);
        final boolean result1 = arraySolutionUnderTest.isStraight(new int[]{0,0,6,4,5});
        assertTrue(result1);
        final boolean result2 = arraySolutionUnderTest.isStraight(new int[]{0,0,3,3,5});
        assertFalse(result2);
    }

    @Test
    void testMissingNumber() {
        final int result = arraySolutionUnderTest.missingNumber(new int[]{0,1,2,4,5,6,7});
        assertEquals(3, result);
        final int result1 = arraySolutionUnderTest.missingNumber(new int[]{0,1,2,3});
        assertEquals(4, result1);
    }

    @Test
    void testNthUglyNumber() {
        final int result = arraySolutionUnderTest.nthUglyNumber(10);
        assertEquals(12, result);
    }

    @Test
    void testExist() {
        final char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        final boolean result = arraySolutionUnderTest.exist(board, "ABCCED");
        assertTrue(result);
        final char[][] board1 = new char[][]{{'A'}};
        final boolean result1 = arraySolutionUnderTest.exist(board, "A");
        assertTrue(result1);
    }

    @Test
    void testMajorityElement() {
        final int result = arraySolutionUnderTest.majorityElement(new int[]{1,2,1,2,1,1,3,1});
        assertEquals(1, result);
    }

    @Test
    void testMaxValue() {
        final int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        final int result = arraySolutionUnderTest.maxValue(grid);
        assertEquals(12, result);
    }

    @Test
    void testMinArray() {
        final int[] numbers = new int[]{2,2,2,0,1};
        final int result = arraySolutionUnderTest.minArray(numbers);
        assertEquals(0, result);
        final int[] numbers1 = new int[]{3,3,1,3};
        final int result1 = arraySolutionUnderTest.minArray(numbers1);
        assertEquals(1, result1);
    }


    @Test
    void testReversePairs() {
        final int[] numbers = new int[]{7,5,6,4};
        final int result = arraySolutionUnderTest.reversePairs(numbers);
        assertEquals(5, result);
    }

    @Test
    void testPrintNumbers() {
        final int[] result = arraySolutionUnderTest.printNumbers(1);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, result);
    }

}
