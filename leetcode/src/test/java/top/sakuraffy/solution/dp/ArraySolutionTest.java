package top.sakuraffy.solution.dp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArraySolutionTest {

    private ArraySolution arraySolutionUnderTest;

    @BeforeEach
    void setUp() {
        arraySolutionUnderTest = new ArraySolution();
    }

    @Test
    void testMaxSubArray() {
        final int result = arraySolutionUnderTest.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        assertEquals(6, result);
    }

    @Test
    void testMaxSubArrayProduct() {
        final int result = arraySolutionUnderTest.maxSubArrayProduct(new int[]{2,-3,-2,4});
        assertEquals(48, result);
    }

    @Test
    void testGenerate() {
        final List<List<Integer>> result = arraySolutionUnderTest.generate(0);
        assertEquals(Arrays.asList(Arrays.asList(0)), result);
    }

    @Test
    void testMinCostClimbingStairs() {
        final int result = arraySolutionUnderTest.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1});
        assertEquals(6, result);
    }

    @Test
    void testGetMaximumGenerated() {
        final int result = arraySolutionUnderTest.getMaximumGenerated(7);
        assertEquals(3, result);
    }

    @Test
    void testCanJump() {
        final boolean result = arraySolutionUnderTest.canJump(new int[]{2,3,1,1,4});
        assertTrue(result);
    }

    @Test
    void testJump() {
        final int result = arraySolutionUnderTest.jump(new int[]{2,3,1,1,4});
        assertEquals(2, result);
    }

    @Test
    void testMinPathSum() {
        final int result = arraySolutionUnderTest.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
        assertEquals(7, result);
    }

    @Test
    void testUniquePathsWithObstacles() {
        final int result = arraySolutionUnderTest.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
        assertEquals(2, result);
    }

    @Test
    void testMinimumTotal() {
        final int result = arraySolutionUnderTest.minimumTotal(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3,4),
                Arrays.asList(6,5,7),
                Arrays.asList(4,1,8,3)
        ));
        assertEquals(11, result);
    }

    @Test
    void testRob() {
        final int result = arraySolutionUnderTest.rob(new int[]{2,7,9,3,1});
        assertEquals(12, result);
    }

    @Test
    void testRobWithCircle() {
        final int result = arraySolutionUnderTest.robWithCircle(new int[]{2,3,2});
        assertEquals(3, result);
    }

    @Test
    void testLengthOfLIS() {
        final int result = arraySolutionUnderTest.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
        assertEquals(6, result);
    }

    @Test
    void testMaximalSquare() {
        final int result = arraySolutionUnderTest.maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        });
        assertEquals(4, result);
    }

    @Test
    void testNthSuperUglyNumber() {
        final int result = arraySolutionUnderTest.nthSuperUglyNumber(12, new int[]{2,7,13,19});
        assertEquals(32, result);
    }

    @Test
    void testCoinChange() {
        final int result = arraySolutionUnderTest.coinChange(new int[]{1,2,5}, 11);
        assertEquals(3, result);
    }

    @Test
    void testChange() {
        final int result = arraySolutionUnderTest.change(5, new int[]{1,2,5});
        assertEquals(4, result);
    }

    @Test
    void testCombinationSum4() {
        final int result = arraySolutionUnderTest.combinationSum4(new int[]{1,2,3}, 4);
        assertEquals(7, result);
    }

    @Test
    void testLargestDivisibleSubset() {
        final List<Integer> result = arraySolutionUnderTest.largestDivisibleSubset(new int[]{1,2,4,8,12});
        assertEquals(Arrays.asList(1,2,4,8).toString(), result.toString());
    }

    @Test
    void testWiggleMaxLength() {
        final int result = arraySolutionUnderTest.wiggleMaxLength(new int[]{1,7,4,9,2,5});
        assertEquals(6, result);
    }

    @Test
    void testNumberOfArithmeticSlices() {
        final int result = arraySolutionUnderTest.numberOfArithmeticSlices(new int[]{1,2,3,4});
        assertEquals(3, result);
    }

    @Test
    void testLongestArithmeticSeqLength() {
        final int result = arraySolutionUnderTest.longestArithmeticSeqLength(new int[]{1,2,3,4});
        assertEquals(4, result);
    }

    @Test
    void testLongestSubsequence() {
        final int result = arraySolutionUnderTest.longestSubsequence(new int[]{1,2,3,4}, 1);
        assertEquals(4, result);
        final int result1 = arraySolutionUnderTest.longestSubsequence(new int[]{4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8}, 0);
        assertEquals(2, result1);
    }

    @Test
    void testCanPartition() {
        final boolean result = arraySolutionUnderTest.canPartition(new int[]{1,5,11,5});
        assertEquals(true, result);
    }

    @Test
    void testFindMaxForm() {
        final int result = arraySolutionUnderTest.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5,3);
        assertEquals(4, result);
    }
}
