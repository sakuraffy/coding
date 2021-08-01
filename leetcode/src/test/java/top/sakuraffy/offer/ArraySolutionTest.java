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
        // Setup

        // Run the test
        final int result = arraySolutionUnderTest.maxProfit(new int[]{0});

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testSmallestK() {
        // Setup

        // Run the test
        final int[] result = arraySolutionUnderTest.smallestK(new int[]{0}, 0);

        // Verify the results
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
        // Setup
        final int[][] matrix = new int[][]{{0}};

        // Run the test
        final boolean result = arraySolutionUnderTest.findNumberIn2DArray(matrix, 0);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testFib() {
        // Setup

        // Run the test
        final int result = arraySolutionUnderTest.fib(0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testMovingCount() {
        // Setup

        // Run the test
        final int result = arraySolutionUnderTest.movingCount(0, 0, 0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testNumWays() {
        // Setup

        // Run the test
        final int result = arraySolutionUnderTest.numWays(0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testMaxSlidingWindow() {
        // Setup

        // Run the test
        final int[] result = arraySolutionUnderTest.maxSlidingWindow(new int[]{0}, 0);

        // Verify the results
        assertArrayEquals(new int[]{0}, result);
    }

    @Test
    void testLastRemaining() {
        // Setup

        // Run the test
        final int result = arraySolutionUnderTest.lastRemaining(0, 0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testMaxSubArray() {
        // Setup

        // Run the test
        final int result = arraySolutionUnderTest.maxSubArray(new int[]{0});

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testTranslateNum() {
        // Setup

        // Run the test
        final int result = arraySolutionUnderTest.translateNum(0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testFindContinuousSequence() {
        // Setup
        final int[][] expectedResult = new int[][]{{0}};

        // Run the test
        final int[][] result = arraySolutionUnderTest.findContinuousSequence(0);

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void testConstructArr() {
        // Setup

        // Run the test
        final int[] result = arraySolutionUnderTest.constructArr(new int[]{0});

        // Verify the results
        assertArrayEquals(new int[]{0}, result);
    }

    @Test
    void testDicesProbability() {
        // Setup

        // Run the test
        final double[] result = arraySolutionUnderTest.dicesProbability(0);

        // Verify the results
        assertArrayEquals(new double[]{0.0}, result);
    }

    @Test
    void testExchange() {
        // Setup

        // Run the test
        final int[] result = arraySolutionUnderTest.exchange(new int[]{0});

        // Verify the results
        assertArrayEquals(new int[]{0}, result);
    }

    @Test
    void testSearch() {
        // Setup

        // Run the test
        final int result = arraySolutionUnderTest.search(new int[]{0}, 0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testCuttingRope() {
        // Setup

        // Run the test
        final int result = arraySolutionUnderTest.cuttingRope(0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testTwoSum() {
        // Setup

        // Run the test
        final int[] result = arraySolutionUnderTest.twoSum(new int[]{0}, 0);

        // Verify the results
        assertArrayEquals(new int[]{0}, result);
    }

    @Test
    void testIsStraight() {
        // Setup

        // Run the test
        final boolean result = arraySolutionUnderTest.isStraight(new int[]{0});

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testMissingNumber() {
        // Setup

        // Run the test
        final int result = arraySolutionUnderTest.missingNumber(new int[]{0});

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testNthUglyNumber() {
        // Setup

        // Run the test
        final int result = arraySolutionUnderTest.nthUglyNumber(0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testExist() {
        // Setup
        final char[][] board = new char[][]{{'a'}};

        // Run the test
        final boolean result = arraySolutionUnderTest.exist(board, "word");

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testMajorityElement() {
        // Setup

        // Run the test
        final int result = arraySolutionUnderTest.majorityElement(new int[]{0});

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testMaxValue() {
        // Setup
        final int[][] grid = new int[][]{{0}};

        // Run the test
        final int result = arraySolutionUnderTest.maxValue(grid);

        // Verify the results
        assertEquals(0, result);
    }
}
